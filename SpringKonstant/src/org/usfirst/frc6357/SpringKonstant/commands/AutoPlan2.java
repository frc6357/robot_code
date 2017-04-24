package org.usfirst.frc6357.SpringKonstant.commands;

import org.usfirst.frc6357.SpringKonstant.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */

// This is the auto for the middle with placing


public class AutoPlan2 extends CommandGroup 
{
	
	boolean isDone = true;
	boolean driving = false;
	
    public AutoPlan2() 
    {
        requires(Robot.gearDeploymentSystem);
        requires(Robot.driveBaseSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	
    	isDone = false;
    	Robot.gearDeploymentSystem.resetSolenoids();
    	
    	if(!isDone)
    	{
        	new Thread() 
        	{
       		     public void run() 
       		     {
       		          //Code to run here:
       		          try     		          
       		          {
        		       	  Robot.driveBaseSystem.DriveStraight(90/12);
        		       	  Thread.sleep(3000);
        		       	  Robot.gearDeploymentSystem.pushGear();
        		       	  Thread.sleep(500);
        		       	  Robot.gearDeploymentSystem.resetPush(); 
        		       	  isDone = true;
        		      } 
        		      catch (InterruptedException e) 
        		      {
        		    	  e.printStackTrace();
        		      }
        		 }
        	} 
        		.start();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {

    	
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return isDone;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	//timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    }
    
    
    
    /*
	////////////////// STATE MACHINE ////////////////////
	////////////////////////////////////////////////////
	private gearState currentState;
	
	private enum gearState
    {
    	GEAR_EMPTY,
    	GEAR_RETREAVING,
    	CARRING_GEAR,
    	READY_TO_PLACE,
    	GEAR_PLACED
    };
	
    public gearState getGearState()
    {
    	return currentState;
    }
    
    public void setGearState(gearState state)
    {
    	currentState = state;
    }
    //////////////////////////////////////////////////////
	//////////////////////////////////////////////////////*/
}

package org.usfirst.frc6357.SpringKonstant.commands;

import org.usfirst.frc6357.SpringKonstant.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */

// This is the Auto for the left side


public class AutoPlan3 extends CommandGroup 
{

	boolean isDone = true;
	
	public AutoPlan3() 
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
       		        	  Robot.driveBaseSystem.DriveStraight(94/12);	
      		       	  	  Thread.sleep(3000);
      		       	  	  Robot.driveBaseSystem.SetPositionMode();
      		       	  	  Robot.driveBaseSystem.rotateRobot(60);
      		       	  	  Thread.sleep(4000);
      		       	  	  Robot.driveBaseSystem.SetPositionMode();
      		       	  	  Robot.driveBaseSystem.DriveStraight(46/12);
      		       	  	  Thread.sleep(2500);
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
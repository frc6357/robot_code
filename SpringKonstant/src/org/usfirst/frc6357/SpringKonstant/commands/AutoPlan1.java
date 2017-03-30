package org.usfirst.frc6357.SpringKonstant.commands;

import org.usfirst.frc6357.SpringKonstant.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoPlan1 extends Command 
{
	
	Boolean isDone = true;
	Boolean driving = false;
	Timer timer;
	
    public AutoPlan1() 
    {
        requires(Robot.gearDeploymentSystem);
        requires(Robot.driveBaseSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	timer.start();
    	isDone = false;
    	Robot.gearDeploymentSystem.resetSolenoids();
    	setGearState(gearState.CARRING_GEAR);
    	Robot.driveBaseSystem.DriveStraight(64.34/12);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	if(timer.get() > 3.0 && !driving)
    	{
    		setGearState(gearState.READY_TO_PLACE);
    	}
    	
    	if(getGearState() == gearState.READY_TO_PLACE && !driving)
    	{
    		Robot.gearDeploymentSystem.pushGear();
    		setGearState(gearState.GEAR_PLACED);
    	}
    	
    	if(getGearState() == gearState.GEAR_PLACED)
    		setGearState(gearState.GEAR_EMPTY);
    	
    	if(getGearState() == gearState.GEAR_EMPTY)
		{
			Robot.gearDeploymentSystem.resetPush();
			isDone = true;
		}
    	
    	if(!Robot.driveBaseSystem.isDriving())
    	{
    		driving = false;
    	}
    	
    	if(Robot.driveBaseSystem.isDriving())
    	{
    		driving = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return isDone;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    }
    
    
    
    
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
	//////////////////////////////////////////////////////
}

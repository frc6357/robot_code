package org.usfirst.frc6357.SpringKonstant.commands;

import org.usfirst.frc6357.SpringKonstant.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoPlan2 extends Command {

	Boolean isDone = true;
	Timer timer;
	
	public AutoPlan2() 
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
    	Robot.driveBaseSystem.DriveStraight(69.84/12);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	if(timer.get() >= 3.0)
    	{
        	Robot.driveBaseSystem.rotateRobot(60);
    	}
    	
    	if(timer.get() >= 6.0)
    	{
    		Robot.driveBaseSystem.DriveStraight(54/12);
    		setGearState(gearState.READY_TO_PLACE);
    	}
    	setGearState(gearState.READY_TO_PLACE);
    	
    	if(getGearState() == gearState.READY_TO_PLACE && timer.get() >= 7.0)
    	{
    		Robot.gearDeploymentSystem.pushGear();
    		setGearState(gearState.GEAR_PLACED);
    	}
    	
    	if(getGearState() == gearState.GEAR_PLACED && timer.get() >= 8.0)
    	{
    		Robot.gearDeploymentSystem.resetPush();
    		isDone = true;
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

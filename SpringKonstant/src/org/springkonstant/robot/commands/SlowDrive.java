package org.springkonstant.robot.commands;

import org.springkonstant.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SlowDrive extends Command {

    public SlowDrive() 
    {
        requires(Robot.driveBaseSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	Robot.driveBaseSystem.setSlowMode();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
 
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false;
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
}

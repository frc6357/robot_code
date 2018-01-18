package org.springkonstant.robot.commands;

import org.springkonstant.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WinchStop extends Command
{
    boolean isDone;

    // Called just before this Command runs the first time
    protected void initialize()
    {
        isDone = false;
        //Robot.ropeClimbSystem.stopMotors();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
        Robot.ropeClimbSystem.stopMotors();
        isDone = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return isDone;
    }

    // Called once after isFinished returns true
    protected void end()
    {
        //Robot.ropeClimbSystem.stopMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {

    }
 }

package org.springkonstant.robot.commands;
import org.springkonstant.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GearPull extends Command
{

    private boolean isDone = false;

    // Called just before this Command runs the first time
    protected void initialize()
    {

    }

    protected void execute()
    {
        isDone = false;
        Robot.gearDeploymentSystem.resetPush();
        isDone = true;
    }

    protected boolean isFinished()
    {
        return isDone;
    }

    // Called once after isFinished returns true
    protected void end()
    {

    }

    protected void interrupted()
    {

    }
}

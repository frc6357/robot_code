package org.usfirst.frc6357.SpringKonstant.commands;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6357.SpringKonstant.Robot;

public class GearPull extends Command 
{
	
	private boolean isDone = true;
	
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

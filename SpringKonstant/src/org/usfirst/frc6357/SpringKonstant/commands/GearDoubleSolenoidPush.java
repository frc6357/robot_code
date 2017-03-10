package org.usfirst.frc6357.SpringKonstant.commands;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6357.SpringKonstant.Robot;

public class GearDoubleSolenoidPush extends Command 
{
	
    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	
    }
    
    protected void execute() 
    {
    	Robot.gearDeploymentSystem.pushGear();
    }
    
    protected boolean isFinished() 
    {
        return false;
    }
    
    // Called once after isFinished returns true
    protected void end() 
    {
    	Robot.gearDeploymentSystem.resetPush();
    }
    
    protected void interrupted() 
    {
    	
    }
}

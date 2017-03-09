package org.usfirst.frc6357.SpringKonstant.commands;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6357.SpringKonstant.Robot;

public class GearDoubleSolenoidPush extends Command 
{
	
	private final DoubleSolenoid gearDoubleSolenoidPush;
	
	public GearDoubleSolenoidPush(DoubleSolenoid gearDoubleSolenoidPushin)
	{
    	gearDoubleSolenoidPush = gearDoubleSolenoidPushin;
	}
	
    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	
    }
    
    protected void execute() 
    {
    	gearDoubleSolenoidPush.set(DoubleSolenoid.Value.kForward);
    	gearDoubleSolenoidPush.set(DoubleSolenoid.Value.kReverse);
    }
    
    protected boolean isFinished() 
    {
        return false;
    }
    
    // Called once after isFinished returns true
    protected void end() 
    {
    	
    }
    
    protected void interrupted() 
    {
    	
    }
}

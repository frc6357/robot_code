package org.usfirst.frc6357.SpringKonstant.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Delay extends Command {

	boolean isDone = false;
	private Timer timer = new Timer();
	
    public Delay(double delayTime)
    {
    	isDone = false;
    	timer.reset();
    	timer.start();
    	Timer.delay(delayTime);
    }

    protected void initialize() 
    {
    	
    }

    protected void execute()
    {
    	isDone = true;
    }

    protected boolean isFinished() 
    {
        return isDone;
    }

    protected void end() 
    {
    	
    }

    protected void interrupted() 
    {
    	
    }
}

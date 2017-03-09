package org.usfirst.frc6357.SpringKonstant;

import org.usfirst.frc6357.SpringKonstant.subsystems.DriveBaseSystem;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;

public class AutonomousMatchController 
{
	private final Encoder encoderRight, encoderLeft;
	private final DriveBaseSystem driveBaseSystem;
	
	
	Timer timer = new Timer(); 		// Creates the timer used in auto
	
	double speed = 5.0;		//  ****  TEMPORY  ****   This is the speed the robot goes at the motors set at 1.0
	
	public AutonomousMatchController(Encoder leftEncoder, Encoder rightEncoder, DriveBaseSystem driveSystem)
	{
		encoderRight = rightEncoder;
		encoderLeft = leftEncoder;
		driveBaseSystem = driveSystem;
	}

	public void driveDistance(double distance)
	{
		
	}
	
	public void rotateLeft(double degree)
	{
		
	}
	
	public void rotateRight(double degree)
	{
		
	}
	
	public void stop()
	{

	}
	

	public double getRightDistance()
	{
		double distance = encoderRight.get() * 2 * Math.PI * 2;
				
		return distance;
	}
	
	public double getLeftDistance()
	{
		double distance = encoderLeft.get() * 2 * Math.PI * 2;
				
		return distance;
	}
	
	public void update(int time, boolean drive, boolean rotateLeft, boolean rotateRight)
	{

	}
}

package org.usfirst.frc6357.SpringKonstant;

import org.usfirst.frc6357.SpringKonstant.subsystems.DriveBaseSystem;

import edu.wpi.first.wpilibj.Encoder;

public class Auto 
{
	
	private final Encoder encoderRight, encoderLeft;
	private final DriveBaseSystem driveBaseSystem;
	
	public Auto(Encoder leftEncoder, Encoder rightEncoder, DriveBaseSystem driveSystem)
	{
		encoderRight = rightEncoder;
		encoderLeft = leftEncoder;
		driveBaseSystem = driveSystem;
	}

	public void driveDistance(double distance)
	{
		driveBaseSystem.setLeftMotors(1.0);
		driveBaseSystem.setRightMotors(1.0);
	}
	
	public void rotate(double distance)
	{
		
	}
	
	public void stop()
	{
		driveBaseSystem.setLeftMotors(0.0);
		driveBaseSystem.setRightMotors(0.0);
	}
	
	public void startCounting()
	{
		resetEncoders();
	}
	
	public void resetEncoders()
	{
		encoderRight.reset();
		encoderLeft.reset();
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
	
}

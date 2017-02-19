package org.usfirst.frc6357.SpringKonstant;

import org.usfirst.frc6357.SpringKonstant.subsystems.DriveBaseSystem;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;

public class Auto 
{
	private final Encoder encoderRight, encoderLeft;
	private final DriveBaseSystem driveBaseSystem;
	
	
	Timer timer = new Timer(); 		// Creates the timer used in auto
	
	double speed = 5.0;		//  ****  TEMPORY  ****   This is the speed the robot goes at the motors set at 1.0
	
	public Auto(Encoder leftEncoder, Encoder rightEncoder, DriveBaseSystem driveSystem)
	{
		encoderRight = rightEncoder;
		encoderLeft = leftEncoder;
		driveBaseSystem = driveSystem;
	}

	public void driveDistance(double distance)
	{
		double time = distance / speed;
		
		timer.start();
		
	/*	while(timer.get() < time)
		{
			driveBaseSystem.setLeftMotors(1.0);
			driveBaseSystem.setRightMotors(1.0);
		} */
		timer.reset();
	}
	
	public void rotateLeft(double degree)
	{
		double time = 5.0;			// **** TEMPORY VALUE NEED TO TEST ROTATION TIME ****
		
	/*	while(timer.get() < time)
		{
			driveBaseSystem.setLeftMotors(-0.5);
			driveBaseSystem.setRightMotors(0.5);
		}*/
	}
	
	public void rotateRight(double degree)
	{
		double time = degree * 0.05;		// **** TEMPORY VALUE NEED TO TEST ROTATION TIME ****
		
	/*	while(timer.get() < time)
		{
			driveBaseSystem.setLeftMotors(0.5);
			driveBaseSystem.setRightMotors(-0.5);
		}*/
	}
	
	public void stop()
	{
		driveBaseSystem.setLeftMotorSpeed(0.0);
		driveBaseSystem.setRightMotorSpeed(0.0);
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
	
	public void update(int time, boolean drive, boolean rotateLeft, boolean rotateRight)
	{
		if(timer.get() < time && drive)		// Used for rotateRight method
		{
			driveBaseSystem.setLeftMotorSpeed(0.5);
			driveBaseSystem.setRightMotorSpeed(-0.5);
		}
		
		if(timer.get() < time && rotateLeft)		// Used for the rotateLeft method
		{
			driveBaseSystem.setLeftMotorSpeed(-0.5);
			driveBaseSystem.setRightMotorSpeed(0.5);
		}
		
		if(timer.get() < time && rotateRight)		// Used for the drive distance method
		{
			driveBaseSystem.setLeftMotorSpeed(1.0);
			driveBaseSystem.setRightMotorSpeed(1.0);
		}
	}
}

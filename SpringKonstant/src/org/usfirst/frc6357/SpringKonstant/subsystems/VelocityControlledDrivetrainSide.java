package org.usfirst.frc6357.SpringKonstant.subsystems;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

public class VelocityControlledDrivetrainSide implements PIDOutput 
{

	private final SpeedController mySpeedController;
	private final PIDSource mySpeedMeasurement;
	private final PIDController myPidController;
	
    private final double Kp = 0.1;
    private final double Kd = 0.0;
    private final double Ki = 0.0;
    
    private final double maxRobotSpeed = 9.5; //feet per second
	
	public VelocityControlledDrivetrainSide(SpeedController inSpeedController, PIDSource inSpeedMeasurement)
	{
		mySpeedController = inSpeedController;
		mySpeedMeasurement = inSpeedMeasurement;
		myPidController = new PIDController(Kp, Ki, Kd, mySpeedMeasurement, mySpeedController);
		
	}
	
	public void Enable(){
		myPidController.enable();
	}
	public void Disable(){
		myPidController.disable();
	}
	
	public void SetSpeedAbsoluteFps(double speed)
	{
		myPidController.setSetpoint(speed);
		if(Math.abs(speed) < 0.01)
		{
			speed = 0.0;
			mySpeedController.set(0.0);
		}
	}
	
	public void SetSpeedPercent(double percent)
	{
		myPidController.setSetpoint(percent * maxRobotSpeed);
	}
	
	public void pidWrite(double output)
	{
		SetSpeedAbsoluteFps(output);
	}
	
	public void reset()
	{
		myPidController.reset();
		myPidController.enable();
	}
	
	public double GetSetpoint(){
		return myPidController.getSetpoint();
	}
}

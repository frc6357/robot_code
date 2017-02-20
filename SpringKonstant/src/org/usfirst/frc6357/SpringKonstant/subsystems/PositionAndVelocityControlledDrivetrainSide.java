package org.usfirst.frc6357.SpringKonstant.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedController;

public class PositionAndVelocityControlledDrivetrainSide 
{
	private final SpeedController mySpeedController;
	private final Encoder myEncoder;
	private final PIDController myPidController;
	private final VelocityControlledDrivetrainSide myVelocityControl;

	
    private final double Kp = 4.0;
    private final double Kd = 0.0;
    private final double Ki = 0.01;
    
    public enum DrivetrainMode 
    {
    	kDrivetrainPositionMode,
    	kDrivetrainVelocityMode
    }
    
    private DrivetrainMode myMode;
	
	public PositionAndVelocityControlledDrivetrainSide(SpeedController inSpeedController, Encoder inEncoder)
	{
		mySpeedController = inSpeedController;
		myEncoder = inEncoder;
		myVelocityControl = new VelocityControlledDrivetrainSide(mySpeedController, new EncoderSpeedForPID(myEncoder));
		myPidController = new PIDController(Kp, Ki, Kd, 
				new EncoderPositionForPID(myEncoder), 
				myVelocityControl
				);
		myMode = PositionAndVelocityControlledDrivetrainSide.DrivetrainMode.kDrivetrainVelocityMode;
	}
	
	public boolean SetDistanceTarget(double distance)
	{
		if(myMode == PositionAndVelocityControlledDrivetrainSide.DrivetrainMode.kDrivetrainPositionMode)
		{
			myPidController.setSetpoint(distance);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void SetPositionMode()
	{
		myPidController.reset();
		myVelocityControl.reset();
		myPidController.enable();
		myMode = PositionAndVelocityControlledDrivetrainSide.DrivetrainMode.kDrivetrainPositionMode;
	}
	
	public void SetVelocityMode()
	{
		myPidController.disable();
		myVelocityControl.reset();
		myMode = PositionAndVelocityControlledDrivetrainSide.DrivetrainMode.kDrivetrainVelocityMode;
	}
	
	public boolean SetSpeedAbsolute(double speed)
	{
		if(myMode == PositionAndVelocityControlledDrivetrainSide.DrivetrainMode.kDrivetrainVelocityMode)
		{
			myVelocityControl.SetSpeedAbsoluteFps(speed);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean SetSpeedPercent(double percent){
		if(myMode == PositionAndVelocityControlledDrivetrainSide.DrivetrainMode.kDrivetrainVelocityMode)
		{
			myVelocityControl.SetSpeedPercent(percent);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
}

package org.usfirst.frc6357.SpringKonstant.subsystems;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

public class VelocityControlledDrivetrainSide implements PIDOutput {

	private final SpeedController mySpeedController;
	private final PIDSource mySpeedMeasurement;
	private final PIDController myPidController;
	
    private final double Kp = 0.1;
    private final double Kd = 0.0;
    private final double Ki = 0.0;
    
    private final double maxRobotSpeed = 9.5; //feet per second
	
	public VelocityControlledDrivetrainSide(SpeedController inSpeedController, PIDSource inSpeedMeasurement){
		mySpeedController = inSpeedController;
		mySpeedMeasurement = inSpeedMeasurement;
		myPidController = new PIDController(Kp, Ki, Kd, mySpeedMeasurement, mySpeedController);
		myPidController.enable();
	}
	
	public void SetSpeedAbsoluteFps(double speed){
		myPidController.setSetpoint(speed);
	}
	
	public void SetSpeedPercent(double percent){
		myPidController.setSetpoint(percent * maxRobotSpeed);
	}
	
	public void pidWrite(double output){
		SetSpeedAbsoluteFps(output);
	}
	
	public void reset(){
		myPidController.reset();
	}
}
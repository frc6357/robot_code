// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6357.SpringKonstant.subsystems;

import org.usfirst.frc6357.SpringKonstant.Robot;
import org.usfirst.frc6357.SpringKonstant.commands.*;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveBaseSystem extends Subsystem // MARK: BreakPoint
{
    private final SpeedController frontLeft;
    private final SpeedController centerLeft;
    private final SpeedController backLeft;
    private final SpeedController frontRight;
    private final SpeedController centerRight;
    private final SpeedController backRight;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public DriveBaseSystem(SpeedController baseFrontLeft, SpeedController baseCenterLeft, 
    		SpeedController baseBackLeft, SpeedController baseFrontRight,SpeedController baseBackRight)
    {
    	super();
        frontLeft = Robot.baseFrontLeft;
        centerLeft = Robot.baseCenterLeft;
        backLeft = Robot.baseBackLeft;
        frontRight = Robot.baseFrontRight;
        centerRight = Robot.baseCenterRight;
        backRight = Robot.baseBackRight;
    }
    
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void setLeftMotors(double speed)
    {
    	frontLeft.set(speed);
    	centerLeft.set(speed);
    	backLeft.set(speed);
    }
    
    public void setRightMotors(double speed)
    {
    	frontRight.set(speed);
    	centerRight.set(speed);
    	backRight.set(speed);
    	
    }
}


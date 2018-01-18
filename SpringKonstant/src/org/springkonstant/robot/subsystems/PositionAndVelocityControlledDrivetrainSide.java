package org.springkonstant.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedController;

public class PositionAndVelocityControlledDrivetrainSide
{
    private final SpeedController mySpeedController;
    private final Encoder myEncoder;
    private final PIDController myPidController;
    private final VelocityControlledDrivetrainSide myVelocityControl;


    private final double Kp = 2.0;
    private final double Kd = 0.1;
    private final double Ki = 0.0;

    private boolean isPositionModeEnabled;

    public PositionAndVelocityControlledDrivetrainSide(SpeedController inSpeedController, Encoder inEncoder)
    {
        mySpeedController = inSpeedController;
        myEncoder = inEncoder;
        myVelocityControl = new VelocityControlledDrivetrainSide(mySpeedController, new EncoderSpeedForPID(inEncoder));

        myPidController = new PIDController(Kp, Ki, Kd,
                new EncoderPositionForPID(myEncoder),
                myVelocityControl
                );
        myPidController.setOutputRange(-5.0, 5.0);
        myPidController.disable();

        isPositionModeEnabled = false;
    }

    public boolean SetDistanceTarget(double distance)
    {
        if(isPositionModeEnabled)
        {
            myPidController.setSetpoint(distance);
            return true;
        }
        else
        {
            return false;
        }
    }

    public void Enable(){
        myVelocityControl.Enable();
        if(isPositionModeEnabled){
            myPidController.enable();
        }
    }

    public void Disable(){
        myVelocityControl.Disable();
        myPidController.disable();
    }

    public void SetPositionMode()
    {
        myPidController.reset();
        myVelocityControl.reset();
        myPidController.enable();
        isPositionModeEnabled = true;
    }

    public void SetVelocityMode()
    {
        myVelocityControl.reset();
        myPidController.disable();
        isPositionModeEnabled = false;
    }

    public boolean SetSpeedAbsolute(double speed)
    {
        if(!isPositionModeEnabled)
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
        if(!isPositionModeEnabled)
        {
            myVelocityControl.SetSpeedPercent(percent);
            return true;
        }
        else
        {
            return false;
        }
    }

    public double GetSpeedSetpoint(){
        return myVelocityControl.GetSetpoint();
    }


}

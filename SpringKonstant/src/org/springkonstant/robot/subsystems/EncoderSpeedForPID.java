package org.springkonstant.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class EncoderSpeedForPID implements PIDSource
{

    private final Encoder myEncoder;

    public EncoderSpeedForPID(Encoder inEncoder)
    {
        myEncoder = inEncoder;
    }
    public void setPIDSourceType(PIDSourceType pidSource)
    {
        return;
    }

    public PIDSourceType getPIDSourceType()
    {
        return PIDSourceType.kRate;
    }
    public double pidGet()
    {
        return myEncoder.getRate();
    }
}

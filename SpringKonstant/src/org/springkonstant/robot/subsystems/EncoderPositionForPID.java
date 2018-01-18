package org.springkonstant.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class EncoderPositionForPID implements PIDSource
{

    private final Encoder myEncoder;

    public EncoderPositionForPID(Encoder inEncoder)
    {
        myEncoder = inEncoder;
    }
    public void setPIDSourceType(PIDSourceType pidSource)
    {
            return;
    }

    public PIDSourceType getPIDSourceType()
    {
        return PIDSourceType.kDisplacement;
    }

    public double pidGet()
    {
        return myEncoder.getDistance();
    }


}

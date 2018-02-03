package util;

import static org.usfirst.frc.team1764.robot.RobotParameters.*;

public class MathUtil {
	
	public static double threshold(double val, double upper, double lower)
	{
		if(val >= upper)
			return upper;
		else if (val <= lower)
			return lower;
		return val;
	}
	
	public static DiffDriveSignal inverseKinematics(double angularVel, double turnRadius)
	{
		
		return new DiffDriveSignal(Math.abs(angularVel*turnRadius) + angularVel*HALF_WIDTH, Math.abs(angularVel*turnRadius) - angularVel*HALF_WIDTH);
			//return new DiffDriveSignal(angularVel*(turnRadius + HALF_WIDTH), angularVel*(turnRadius - HALF_WIDTH));
//		}
//		else if(turnRadius < 0)
//		{
//			return new DiffDriveSignal(angularVel*(turnRadius - HALF_WIDTH), angularVel*(turnRadius + HALF_WIDTH));
//		}
//		else
//		{
//			return new DiffDriveSignal((angularVel*HALF_WIDTH))
//		}
	}
}

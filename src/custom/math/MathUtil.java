package custom.math;

import custom.drive.DiffDriveState;

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
	
	/*
	 * This finds the optimal wheelspeeds for the drivetrain to go a turning velocity and radius
	 * This will probably be set to return a DiffDriveState instead and have a PID that reads from DiffDriveState called targetState 
	 * and will set the wheel speeds to whatever is in the state. But there might be issues with having the same class being used to describe the current state
	 * of the drivetrain from the encoders while manually setting a value on the state and using it for a target state. 
	 */
	public static DiffDriveState inverseKinematics(double angularVel, double turnRadius)
	{
		
		return new DiffDriveState(Math.abs(angularVel*turnRadius) + angularVel*HALF_WIDTH, Math.abs(angularVel*turnRadius) - angularVel*HALF_WIDTH);

	}
}

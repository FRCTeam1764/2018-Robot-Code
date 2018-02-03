package util;

import static org.usfirst.frc.team1764.robot.RobotParameters.*;

public class DiffDriveState {
	
	public double left, right;
	
	public DiffDriveState(double left, double right)
	{
		this.left = left;
		this.right = right;
	}
	
	public double getTurnRadius()
	{
		return ((CHASSIS_WIDTH / 2)*(left + right))/ (right - left);
	}
	
	public double getAngularVel()
	{
		return (right - left)/CHASSIS_WIDTH;
	}
	
	public double getTangentVel()
	{
		return getTurnRadius() * getAngularVel();
	}
	
	
}

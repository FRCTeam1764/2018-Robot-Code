package util;

import static org.usfirst.frc.team1764.robot.RobotParameters.*;

public class DiffDriveState {
	/* 
	 * This class contains info about the current state of the drivetrain and the wheelspeeds and stuff. Probably going to throw in
	 * GrayHill63R in here which will get the left and right wheelspeeds. 
	 * */
	public double left, right;
	
	public DiffDriveState(double left, double right)
	{
		this.left = left;
		this.right = right;
	}
	
	/*
	 * TODO If we add the GrayHill63R class in here, then we need a function called update or something that will 
	 * set the left and right wheel speeds to whatever the output of our two encoders is
	 */
	
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

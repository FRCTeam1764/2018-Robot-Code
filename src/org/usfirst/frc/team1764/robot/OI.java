/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1764.robot;

import org.usfirst.frc.team1764.robot.commands.AlignToCamera;
import org.usfirst.frc.team1764.robot.commands.DriveForwardForTime;
import org.usfirst.frc.team1764.robot.commands.FollowPath;
import org.usfirst.frc.team1764.robot.commands.ResetGyro;
import org.usfirst.frc.team1764.robot.commands.RunBoxIntake;
import org.usfirst.frc.team1764.robot.commands.TurnToAngle;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public OperatorDevice in;
	
	public double getThrottle()
	{
		return in.getThrottle();
	}
	
	public double getTurn()
	{
		return in.getTurn();
	}
	
	
	
	public OI() {
		this.in = new Extreme3DPro(0);
	}
	
	
}

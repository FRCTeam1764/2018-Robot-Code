/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1764.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	public static final int GYRO_PORT = 0;
	public static int INTAKE_LEFT_MOTOR = 6;
	public static int INTAKE_RIGHT_MOTOR = 5;
	public static int FRONT_LEFT_MOTOR_PORT = 8;
	public static int BACK_LEFT_MOTOR_PORT = 8;
	public static int FRONT_RIGHT_MOTOR_PORT = 4;
	public static int BACK_RIGHT_MOTOR_PORT = 7;
	public static int SHIFT_SOLENOID_LEFT = 0;
	public static int SHIFT_SOLENOID_RIGHT = 4;

	public static int LIFTER_MOTOR_1_PORT = 1;
	public static int LIFTER_MOTOR_2_PORT = 2;
	
}

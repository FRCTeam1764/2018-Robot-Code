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
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	public static Joystick joy = new Joystick(0);
	public static JoystickButton boxIntakeIn = new JoystickButton(joy, 5);
	public static JoystickButton boxIntakeOut = new JoystickButton(joy, 6);
	
	public static JoystickButton alignToCamButton = new JoystickButton(joy, 1);
	
	public static JoystickButton resetGyroButton = new JoystickButton(joy, 7);
	public static JoystickButton driveForwardTime = new JoystickButton(joy, 11);
	
	public static JoystickButton followPathButton = new JoystickButton(joy, 12);
	
	public double getThrottle()
	{
		return joy.getY();
	}
	
	public double getTurn()
	{
		return joy.getZ();
	}
	
	public OI() {
		
		
		//followPathButton.whenPressed(new FollowPath(p));
		
		boxIntakeIn.whileHeld(new RunBoxIntake(-0.5));
		boxIntakeOut.whileHeld(new RunBoxIntake(0.5));
		alignToCamButton.whenPressed(new TurnToAngle(45));
		resetGyroButton.whileHeld(new ResetGyro());
		driveForwardTime.whenPressed(new DriveForwardForTime(4000));
	}
	
	
}

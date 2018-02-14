package org.usfirst.frc.team1764.robot;

import static org.usfirst.frc.team1764.robot.Robot.oi;

import org.usfirst.frc.team1764.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import util.DiffDriveSignal;

/**
 * 
 * @author FRC1764
 * This class serves as a wrapper for WPILib Joystick class that allows for multiple types of input methods to be defined
 * To create a new input device, simply create a subclass of OperatorDevice and override the abstract methods.
 *
 * Something
 */
public abstract class OperatorDevice {
	
	/* Initialize the joystick as a WPILib object*/
	protected Joystick inputDevice;
	
	/* To add new buttons, put them here */
	protected JoystickButton alignToCamButton, resetGyroButton, driveForwardTimeButton, 
							runLifterUpButton, runLifterDownButton, runIntakeInButton,
							runIntakeOutButton;
	
	public OperatorDevice(int port)
	{
		this.inputDevice = new Joystick(port);
		/* Buttons will be instantiated and bound to whatever the subclass wants them to be bound to */
		attachCommands();
	}
	
	/* So this is required to be overridden, this is because the button bindings for each input method will be different.
	 * When you make a subclass, you will initialize the buttons to whatever port number is for that input method */
	public abstract void bindButtons(); 
	
	/* 
	 * This method is for actually assigning buttons to commands. Every instance of OperatorDevice will have buttons with these actions
	 */
	public void attachCommands()
	{
		bindButtons();
		alignToCamButton.whenPressed(new TurnToAngle(45));
		resetGyroButton.whileHeld(new ResetGyro());
		driveForwardTimeButton.whenPressed(new DriveForwardForTime(4000));
		runLifterUpButton.whileHeld(new RunLifter(1.0));
		runLifterDownButton.whileHeld(new RunLifter(-1.0));
		runIntakeInButton.whileHeld(new RunIntake(1.0));
		runIntakeOutButton.whileHeld(new RunIntake(-0.75));
	}
	
	/*
	 * Some input methods have different ways of finding throttle and turning speed. (eg. An Xbox gamepad uses the left and right triggers for throttle
	 */
	public abstract double getThrottle();
	public abstract double getTurn();
	
	/*
	 * No matter what input method there is, the turn speed and throttle are used in the same formula to convert to a differential drive signal
	 */
	public DiffDriveSignal toDiffDriveSignal()
	{
		double left = oi.getThrottle() + oi.getTurn()*0.5;
    	double right = oi.getThrottle() - oi.getTurn() * 0.5;
		return new DiffDriveSignal(left, right);
	}
}

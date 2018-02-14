package org.usfirst.frc.team1764.robot;

import org.usfirst.frc.team1764.robot.commands.DriveForwardForTime;
import org.usfirst.frc.team1764.robot.commands.ResetGyro;
import org.usfirst.frc.team1764.robot.commands.RunBoxIntake;
import org.usfirst.frc.team1764.robot.commands.TurnToAngle;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * 
 * @author FRC1764
 *
 * This class is an extension of OperatorDevice and defines the button bindings and analog bindings for a logitech Extreme3DPro
 */

public class Extreme3DPro extends OperatorDevice {

	
	public Extreme3DPro(int port) {
		super(port);
	}

	@Override
	public double getThrottle() {
		// TODO Auto-generated method stub
		return this.inputDevice.getY();
	}

	@Override
	public double getTurn() {
		// TODO Auto-generated method stub
		return this.inputDevice.getX();
	}

	/*
	 Assign buttons to port numbers
	 */
	@Override
	public void bindButtons() {
		// TODO Auto-generated method stub
		this.alignToCamButton = new JoystickButton(this.inputDevice, 0);
		this.resetGyroButton = new JoystickButton(this.inputDevice, 1);
		this.driveForwardTimeButton = new JoystickButton(this.inputDevice, 2);
	}

}

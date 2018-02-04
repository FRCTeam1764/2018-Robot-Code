package org.usfirst.frc.team1764.robot;

import org.usfirst.frc.team1764.robot.commands.DriveForwardForTime;
import org.usfirst.frc.team1764.robot.commands.ResetGyro;
import org.usfirst.frc.team1764.robot.commands.RunBoxIntake;
import org.usfirst.frc.team1764.robot.commands.TurnToAngle;

public class Joy extends OperatorDevice {

	public Joy(int port) {
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

	@Override
	public void initButtons() {
		// TODO Auto-generated method stub

	}

}

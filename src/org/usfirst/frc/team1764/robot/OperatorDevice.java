package org.usfirst.frc.team1764.robot;

import static org.usfirst.frc.team1764.robot.Robot.oi;

import edu.wpi.first.wpilibj.Joystick;
import util.DiffDriveSignal;

public abstract class OperatorDevice {
	protected Joystick inputDevice;
	public OperatorDevice(int port)
	{
		this.inputDevice = new Joystick(port);
	}
	
	public abstract void initButtons();
	public abstract double getThrottle();
	public abstract double getTurn();
	
	public DiffDriveSignal toDiffDriveSignal()
	{
		double left = oi.getThrottle() + oi.getTurn()*0.5;
    	double right = oi.getThrottle() - oi.getTurn() * 0.5;
		return new DiffDriveSignal(left, right);
	}
}

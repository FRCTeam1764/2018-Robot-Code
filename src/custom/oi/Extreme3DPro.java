package custom.oi;

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
		return -this.inputDevice.getY();
	}

	@Override
	public double getTurn() {
		// TODO Auto-generated method stub
		return this.inputDevice.getZ();
	}

	/*
	 Assign buttons to port numbers
	 */
	@Override
	public void bindButtons() {
		// TODO Auto-generated method stub
		this.alignToCamButton = new JoystickButton(this.inputDevice, 11);
		this.resetGyroButton = new JoystickButton(this.inputDevice, 10);
		this.driveForwardTimeButton = new JoystickButton(this.inputDevice, 9);
		this.runLifterUpButton = new JoystickButton(this.inputDevice, 7);
		this.runLifterDownButton = new JoystickButton(this.inputDevice, 8);
		this.runIntakeInButton = new JoystickButton(this.inputDevice, 5);
		this.runIntakeOutButton = new JoystickButton(this.inputDevice, 3);
	}

}

package org.usfirst.frc.team1764.robot.subsystems;

import org.usfirst.frc.team1764.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private TalonSRX left, right;
	
	public Intake()
	{
		this.left = new TalonSRX(RobotMap.INTAKE_LEFT_MOTOR);
		this.right = new TalonSRX(RobotMap.INTAKE_RIGHT_MOTOR);
		
	}
	
	public void setSpeed(double speed)
	{
		this.left.set(ControlMode.PercentOutput, speed);
		this.right.set(ControlMode.PercentOutput, -speed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


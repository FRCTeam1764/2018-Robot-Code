package org.usfirst.frc.team1764.robot.subsystems;

import org.usfirst.frc.team1764.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BoxIntake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public SpeedController left, right;
	
	public BoxIntake() {
		left = new Spark(RobotMap.INTAKE_LEFT_MOTOR);
		right = new Spark(RobotMap.INTAKE_RIGHT_MOTOR);
	}
	
	public void set(double speed) {
		left.set(speed);
		right.set(-speed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


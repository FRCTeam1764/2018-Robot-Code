package org.usfirst.frc.team1764.robot.commands;

import static org.usfirst.frc.team1764.robot.Robot.*;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveWithJoystick extends Command {

    public DriveWithJoystick() {
    	requires(chassis);
    	requires(lidar);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	/*
    	 * This doesn't disable the subsystem, rather, it disables the PID Controller so it's not fighting the operator
    	 */
    	chassis.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*
    	 * Nice thing about this is that if you have a different input device that perhaps doesn't calculate differential drives the same way, 
    	 * all you have to do is explicitly override that without touching this code at all. 
    	 */
    	SmartDashboard.putNumber("LEFT_ENCODER: ", chassis.left.encoder.getDistance());
    	SmartDashboard.putNumber("RIGHT_ENCODER: ", chassis.right.encoder.getDistance());

    	chassis.setSignal(oi.in.toDiffDriveSignal());

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

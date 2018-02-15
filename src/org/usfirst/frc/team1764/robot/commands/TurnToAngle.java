package org.usfirst.frc.team1764.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import custom.drive.DiffDriveSignal;

import static org.usfirst.frc.team1764.robot.Robot.*;

import org.usfirst.frc.team1764.robot.Robot;

/**
 *
 */
public class TurnToAngle extends Command {
	
	double targetAngle;
	double additive;
	long deltaTime;
	long lastTime;
    public TurnToAngle(double targetAngle) {
    	this.targetAngle = targetAngle;
    	
    	requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	chassis.setSetpoint(targetAngle);
    	chassis.enable();   	
    }

    protected void execute() {
    }

    protected boolean isFinished() {
    	/* Want to make sure that the robot is settled and on target before dying */
        return Robot.chassis.onTarget() && (Math.abs(Robot.chassis.navx.getRate()) <= 0.1);
    }

    // Called once after isFinished returns true
    protected void end() {
    	/* Want to make sure the next time we enable the PID controller it doesn't go forward for like, no reason */
    	chassis.setAdditive(DiffDriveSignal.NEUTRAL);
    	chassis.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	chassis.disable();
    }
}

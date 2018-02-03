package org.usfirst.frc.team1764.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import util.DiffDriveSignal;

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
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.targetAngle = targetAngle;
    	
    	requires(chassis);
    	
    	//this.setInterruptible(false);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//chassis.shiftDown();
    	//chassis.setAdditive(new DiffDriveSignal(additive, additive));
    	chassis.setSetpoint(targetAngle);
    	chassis.enable();
    	
    	//chassis.setSetpoint(targetAngle);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.chassis.onTarget() && (Math.abs(Robot.chassis.navx.getRate()) <= 0.1);
    }

    // Called once after isFinished returns true
    protected void end() {
    	chassis.setAdditive(DiffDriveSignal.NEUTRAL);
    	chassis.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	chassis.disable();
    }
}

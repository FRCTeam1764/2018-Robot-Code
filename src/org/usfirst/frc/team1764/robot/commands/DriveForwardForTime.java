package org.usfirst.frc.team1764.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import custom.drive.DiffDriveSignal;

import org.usfirst.frc.team1764.robot.Robot;

/**
 *
 */
public class DriveForwardForTime extends Command {
	long startTime;
	long endTime;
	long time;
    public DriveForwardForTime(long time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    	this.time = time;
    	
    	//this.setInterruptible(false);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassis.resetGyro();
    	this.startTime = System.currentTimeMillis();
    	this.endTime = this.time + this.startTime;
    	Robot.chassis.setSetpoint(0);
    	
    	/*
    	 * Ok so the additive is just something that is not controlled by the PID loop and just makes it go forward. 
    	 * The PID loop only cares about locking to an angle, so it will add onto that additive to adjust for the angle. 
    	 * This allows it to drive in a straight line without going off target
    	 */
    	
    	Robot.chassis.setAdditive(new DiffDriveSignal(-0.25, -0.25));
    	
    	Robot.chassis.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    }

    /*
     * Die when it runs out of time
     */
    protected boolean isFinished() {
        return System.currentTimeMillis() >= this.endTime;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	Robot.chassis.disable();
    	/*
    	 * We don't want the robot to start driving forward if/when we want it to just align to an angle without moving forward.
    	 */
    	Robot.chassis.setAdditive(DiffDriveSignal.NEUTRAL);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//Robot.chassis.disable();
    	end();
    }
}

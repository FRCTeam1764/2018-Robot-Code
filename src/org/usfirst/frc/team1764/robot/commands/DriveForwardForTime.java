package org.usfirst.frc.team1764.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import util.DiffDriveSignal;

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
    	Robot.chassis.setAdditive(new DiffDriveSignal(-0.25, -0.25));
    	
    	Robot.chassis.enable();
    	//Robot.chassis.autoSpeed = -0.5;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.chassis.setLeft(speed);
    	
    	
    	//Robot.chassis.setLeft(0.2);
    	//Robot.chassis.setRight(-0.2);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis() >= this.endTime;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	Robot.chassis.disable();
    	Robot.chassis.setAdditive(DiffDriveSignal.NEUTRAL);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//Robot.chassis.disable();
    	end();
    }
}

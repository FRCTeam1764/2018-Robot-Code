package org.usfirst.frc.team1764.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WaitFor extends Command {
	long startTime;
	long endTime;
	long duration;
	
	/*
	 * This allows for a wait in a command group without interrupting everything else 
	 */
	
    public WaitFor(long time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.duration = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.startTime = System.currentTimeMillis();
    	this.endTime = this.startTime + duration;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis() >= endTime;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

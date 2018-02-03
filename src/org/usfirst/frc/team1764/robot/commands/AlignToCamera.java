package org.usfirst.frc.team1764.robot.commands;

import org.usfirst.frc.team1764.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AlignToCamera extends Command {

	private double angle;
	private int num = 0;
	public AlignToCamera() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	//Robot.chassis.resetGyro();
    	Robot.chassis.enable();
    	this.num = 0;
    	
    	//System.out.println(angle);
    	//Robot.chassis.setOutputRange(-0.7, 0.7);
    	
    	/*
    	 * Run this stuff once. Basically coarse adjustment to get it pointing in the target's 
    	 * general direction.
    	 */
    	
    	this.angle = -Robot.table.getNumber("targetAngle", 0);
		Robot.chassis.setSetpoint(Robot.chassis.getAngle() + this.angle);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putBoolean("onTarget", Robot.chassis.onTarget());
    	//SmartDashboard.putNumber("iteration", num);
    	//if(Robot.chassis.onTarget())
    	//{
    	//	num++;
    		
    		//this.angle = -Robot.table.getNumber("targetAngle", 0);
    		//Robot.chassis.setSetpoint(this.angle);
    	//}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	// Run two iterations of the auto align. Increase for better accuracy. 
        return Robot.chassis.onTarget() && !Robot.chassis.navx.isRotating();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.chassis.disable();
    }
}

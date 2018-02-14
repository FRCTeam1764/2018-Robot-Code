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
	public AlignToCamera() {

    	requires(Robot.chassis);
    }

    protected void initialize() {
    	Robot.chassis.enable();

    	
    	this.angle = -Robot.table.getNumber("targetAngle", 0);
		Robot.chassis.setSetpoint(Robot.chassis.getAngle() + this.angle);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putBoolean("onTarget", Robot.chassis.onTarget());
    }

    protected boolean isFinished() {
    	/* Checks if the robot has ceased oscillating and is on target */
        return Robot.chassis.onTarget() && !Robot.chassis.navx.isRotating();
    }

    protected void end() {
    	Robot.chassis.disable();
    }

    protected void interrupted() {
    	Robot.chassis.disable();
    }
}

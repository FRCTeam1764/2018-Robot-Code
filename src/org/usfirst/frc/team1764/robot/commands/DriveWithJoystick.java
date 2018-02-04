package org.usfirst.frc.team1764.robot.commands;

import static org.usfirst.frc.team1764.robot.Robot.*;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import util.DiffDriveSignal;

/**
 *
 */
public class DriveWithJoystick extends Command {

    public DriveWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	chassis.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//System.out.println("ANGLE: " +  chassis.getAngle());

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

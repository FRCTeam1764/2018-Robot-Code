package org.usfirst.frc.team1764.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import custom.drive.DiffDriveState;
import custom.math.MathUtil;

import static org.usfirst.frc.team1764.robot.Robot.chassis;


public class DriveArc extends Command {

    double targetDistance;
    double currentDistance;
    double angularSpeed;
    double radius;
    long currentTime;
    long lastTime;

    public DriveArc(double time, double angle, double radius) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        angularSpeed = angle/time;
        this.targetDistance = angle*radius;
        this.radius = radius;
        requires(chassis);
    }

    @Override
    protected void initialize() {
        chassis.enableIndividualPID();
        chassis.resetEncoders();
        chassis.setDiffDriveState(MathUtil.inverseKinematics(angularSpeed, radius));
    }

    @Override
    protected void execute() {
        currentTime = System.currentTimeMillis();
        double dt = (currentTime - lastTime)/1000;
        this.currentDistance += chassis.getCurrentState().getTangentVel()*dt;
        lastTime = System.currentTimeMillis();
    }

    @Override
    protected boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return currentDistance >= targetDistance;
    }

    @Override
    protected void end() {
        chassis.disableIndividualPID();
        chassis.setDiffDriveState(DiffDriveState.NEUTRAL);
    }

    @Override
    protected void interrupted() {
        end();
    }
}

package org.usfirst.frc.team1764.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import custom.drive.DiffDriveState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import static org.usfirst.frc.team1764.robot.Robot.chassis;


public class DriveForwardForDistance extends Command {
    double targetDistance;
    double currentDistance;
    double speed;
    long currentTime;
    long lastTime;
    long startTime;
    public DriveForwardForDistance(double speed, double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(chassis);
        this.speed = speed;
        this.targetDistance = distance;


    }

    @Override
    protected void initialize() {
        chassis.enableIndividualPID();
        chassis.resetEncoders();
        chassis.setDiffDriveState(new DiffDriveState(speed, -speed));
        this.startTime = System.currentTimeMillis();

    }

    @Override
    protected void execute() {
//        currentTime = System.currentTimeMillis();
//        double dt = (currentTime - lastTime)/1000;
//        this.currentDistance += chassis.getCurrentState().getTangentVel()*dt;
//        lastTime = System.currentTimeMillis();
//
//        chassis.setDiffDriveState(new DiffDriveState(speed, -chassis.right.encoder.getRate()));
        SmartDashboard.putNumber("EncRIGHT", chassis.right.encoder.getRate());
    }

    @Override
    protected boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()

        return System.currentTimeMillis() >= startTime + 4000;
    }

    @Override
    protected void end() {
        System.out.println("FINISHED");
        chassis.disableIndividualPID();
        chassis.setDiffDriveState(DiffDriveState.NEUTRAL);
    }

    @Override
    protected void interrupted() {
        end();
    }
}

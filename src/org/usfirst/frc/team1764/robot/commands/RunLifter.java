package org.usfirst.frc.team1764.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1764.robot.Robot;

public class RunLifter extends Command {
    double speed;
    public RunLifter(double speed)
    {
        this.speed = speed;
        requires(Robot.lifter);
    }
    @Override
    protected void initialize()
    {

    }

    @Override
    protected void execute()
    {
        Robot.lifter.set(speed);
        SmartDashboard.putNumber("LifterPos", Robot.lifter.getPos());
    }

    @Override
    protected void end()
    {
        Robot.lifter.set(0);
    }

    @Override
    protected void interrupted()
    {
        end();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}

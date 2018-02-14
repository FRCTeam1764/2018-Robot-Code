package org.usfirst.frc.team1764.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
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
        Robot.lifter.setSpeed(this.speed);
    }

    @Override
    protected void execute()
    {

    }

    @Override
    protected void end()
    {
        Robot.lifter.setSpeed(0);
    }

    @Override
    protected void interrupted()
    {
        Robot.lifter.setSpeed(0);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}

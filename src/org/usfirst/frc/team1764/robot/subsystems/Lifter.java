package org.usfirst.frc.team1764.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import custom.Gearbox;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1764.robot.RobotMap;

public class Lifter extends Subsystem {
    private Gearbox lifterGearbox;

    public Lifter()
    {
        lifterGearbox = new Gearbox(RobotMap.LIFTER_MOTOR_1_PORT, RobotMap.LIFTER_MOTOR_2_PORT);
    }

    public void setSpeed(double speed)
    {
        lifterGearbox.set(speed);
    }
    @Override
    protected void initDefaultCommand() {

    }
}

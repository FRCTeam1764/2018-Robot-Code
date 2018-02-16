package org.usfirst.frc.team1764.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import custom.Gearbox;
import custom.PIDGearbox;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1764.robot.RobotMap;

public class Lifter extends Subsystem {
    private PIDGearbox lifterGearbox;

    public Lifter()
    {
        lifterGearbox = new PIDGearbox(RobotMap.LIFTER_MOTOR_1_PORT, RobotMap.LIFTER_MOTOR_2_PORT,
                                    RobotMap.LIFTER_ENCODER_A,
                                    RobotMap.LIFTER_ENCODER_B);
        lifterGearbox.setPIDParams(0.01, 0, 0, 0);
        lifterGearbox.encoder.getEncoder().setPIDSourceType(PIDSourceType.kDisplacement);
        lifterGearbox.motor1.setInverted(true);
        lifterGearbox.motor2.setInverted(true);
        lifterGearbox.motor1.configOpenloopRamp(0, 0);
        lifterGearbox.motor2.configOpenloopRamp(0, 0);
    }



    public void setSpeed(double speed)
    {
        lifterGearbox.set(speed);
    }
    public void setPosition(double pos) {
        lifterGearbox.setPosition(pos);
    }
    public double getPos()
    {
        return lifterGearbox.encoder.getDistance();
    }

    public void set(double speed)
    {
        this.lifterGearbox.set(speed);
    }

    public void enable()
    {
        lifterGearbox.enablePID();
    }

    public void disable()
    {
        lifterGearbox.disablePID();
    }
    @Override
    protected void initDefaultCommand() {

    }
}

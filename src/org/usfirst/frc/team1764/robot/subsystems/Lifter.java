package org.usfirst.frc.team1764.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc.team1764.robot.RobotMap;

public class Lifter extends PIDSubsystem {
    public static final double Kp = 0.01;
    public static final double Ki = 0.00;
    public static final double Kd = 0.00;

    private TalonSRX motor1, motor2;

    public Lifter()
    {
        super(Kp, Ki, Kd);
        motor1 = new TalonSRX(RobotMap.LIFTER_MOTOR_1_PORT);
        motor2 = new TalonSRX(RobotMap.LIFTER_MOTOR_2_PORT);
    }
    @Override
    protected double returnPIDInput() {
        return 0;
    }

    @Override
    protected void usePIDOutput(double output) {

    }

    public void setSpeed(double speed)
    {
        this.motor1.set(ControlMode.PercentOutput, speed);
        this.motor2.set(ControlMode.PercentOutput, speed);
    }

    @Override
    protected void initDefaultCommand() {

    }
}

package org.usfirst.frc.team1764.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import util.Grayhill63R;

public class Gearbox extends PIDSubsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public static double kP = 0;
    public static double kI = 0;
    public static double kD = 0;
    public static double kF = 0;

    private TalonSRX motor1, motor2;
    public Grayhill63R encoder;

    public Gearbox(int motorPort1, int motorPort2, int encoderPort1, int encoderPort2)
    {
        super(kP, kI, kD, kF);
        this.motor1 = new TalonSRX(motorPort1);
        this.motor2 = new TalonSRX(motorPort2);
        this.encoder = new Grayhill63R(encoderPort1, encoderPort2);

    }

    public void setSpeed(double speed)
    {
        this.motor1.set(ControlMode.PercentOutput, speed);
        this.motor2.set(ControlMode.PercentOutput, speed);
    }

    @Override
    protected double returnPIDInput() {
        return encoder.getRate();
    }

    @Override
    protected void usePIDOutput(double output) {
        this.motor1.set(ControlMode.PercentOutput, output);
        this.motor2.set(ControlMode.PercentOutput, output);
    }

    public void initDefaultCommand() {
        // TODO: Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
    }


}


package custom;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import custom.sensors.Grayhill63R;

public class PIDGearbox extends Gearbox {
    public static final double KP = 0;
    public static final double KI = 0;
    public static final double KD = 0;
    public static final double KF = 0;

    public Grayhill63R encoder;

    private SRXPIDAdapter pidOutput;
    private PIDController controller;

    public PIDGearbox(int motorPort1, int motorPort2, int encoderPort1, int encoderPort2)
    {
        super(motorPort1, motorPort2);
        this.encoder = new Grayhill63R(encoderPort1, encoderPort2);

        this.pidOutput = new SRXPIDAdapter(this.motor1);

        pidOutput.addTalon(motor2);

        controller = new PIDController( KP, KI, KD, KF, encoder.getEncoder(), pidOutput);
        encoder.getEncoder().setPIDSourceType(PIDSourceType.kRate);
    }

    public void set(double speed)
    {
        this.motor1.set(ControlMode.PercentOutput, speed);
        this.motor2.set(ControlMode.PercentOutput, speed);
    }

    public void enablePID()
    {
        this.controller.enable();
    }

    public void disablePID()
    {
        this.controller.disable();
    }

    public void setSpeed(double speed)
    {
        this.controller.setSetpoint(speed);
    }
}

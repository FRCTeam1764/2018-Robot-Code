package custom;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Gearbox {

    protected TalonSRX motor1, motor2;

    public Gearbox(int motorPort1, int motorPort2)
    {
        this.motor1 = new TalonSRX(motorPort1);
        this.motor2 = new TalonSRX(motorPort2);
    }

    public void set(double speed)
    {
        this.motor1.set(ControlMode.PercentOutput, speed);
        this.motor2.set(ControlMode.PercentOutput, speed);
    }
}

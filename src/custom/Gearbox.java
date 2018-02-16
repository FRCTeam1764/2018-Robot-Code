package custom;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Gearbox {

    /*
    This combines two motors to ensure that they both go in the same direction as they are on
    an actual gearbox. While on some subsystems, it is possible to just have the two motors on there
    both going at the same speed, for some subsystems with two different gearboxes (like the drivetrain),
    it is necessary to have them in their own classes running their own PIDs. this is here for consistency so that
    you don't have some subsystems just have 2 motors running at the same speed and others using gearboxes.
     */

    public TalonSRX motor1, motor2;

    public Gearbox(int motorPort1, int motorPort2)
    {
        this.motor1 = new TalonSRX(motorPort1);
        this.motor2 = new TalonSRX(motorPort2);
    }

    public void set(double speed)
    {
        this.motor1.set(ControlMode.PercentOutput, speed);
        this.motor2.set(ControlMode.PercentOutput, speed);
        //this.motor1.
    }
}

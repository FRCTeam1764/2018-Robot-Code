package custom;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.PIDOutput;

import java.util.ArrayList;

public class SRXPIDAdapter implements PIDOutput {
    private ArrayList<TalonSRX> talons;

    public SRXPIDAdapter(TalonSRX motor)
    {
        this.talons = new ArrayList<>();
        talons.add(motor);
    }

    public void addTalon(TalonSRX talon)
    {
        this.talons.add(talon);
    }

    public void set(double speed)
    {
        for(TalonSRX t : talons)
        {
            t.set(ControlMode.PercentOutput, speed);
        }
    }

    @Override
    public void pidWrite(double output) {
        for(TalonSRX t : talons)
        {
            t.set(ControlMode.PercentOutput, output);
        }
    }
}

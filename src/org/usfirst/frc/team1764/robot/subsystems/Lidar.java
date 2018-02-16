package org.usfirst.frc.team1764.robot.subsystems;


import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lidar extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public SerialPort lidar;

    public void initDefaultCommand() {
        // TODO: Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
    }
    private int buad = 115200;
    /*
    private int dataBits =8;
     int parityBit = 0;
     int stopBit = 1;*/

    public Lidar()
    {
        lidar = new SerialPort(115200,SerialPort.Port.kMXP,8, SerialPort.Parity.kNone,SerialPort.StopBits.kOne);
    }

    public int GetLidar()
    {
        byte[] result = lidar.read(9);

        int distance = (((int)result[3])<<8)+result[2];
        return distance;



    }
}


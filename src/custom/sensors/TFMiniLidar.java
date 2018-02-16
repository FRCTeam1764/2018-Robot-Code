package custom.sensors;

import edu.wpi.first.wpilibj.SerialPort;

public class TFMiniLidar implements Runnable{
    public static final int BAUD = 115200;

    private Thread thread;
    private SerialPort port;

    private double distance;
    public TFMiniLidar()
    {
        port = new SerialPort(BAUD, SerialPort.Port.kMXP, 8, SerialPort.Parity.kNone, SerialPort.StopBits.kOne);
        thread = new Thread(this,"tfminithread");
        thread.start();
    }
    public double getDistance()
    {
        return distance;
    }

    @Override
    public void run() {

        while(true)
        {
            try
            {

                if(port.read(1)[0] == 0x59 && port.read(1)[0] == 0x59)
                {
                    int t1 = port.read(1)[0];
                    int t2 = port.read(1)[0];
                    t2 <<= 8;
                    t2 += t1;

                    distance = (double)t2;

                    t1 = port.read(1)[0];
                    t2 = port.read(1)[0];

                    t2 <<= 8;
                    t2 += t1;

                    for(int i = 0; i < 3; i++)
                    {
                        port.read(1);
                    }
                }
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                distance = -1.0;
            }
        }
    }
}

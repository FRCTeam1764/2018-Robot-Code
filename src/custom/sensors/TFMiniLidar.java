package custom.sensors;

import edu.wpi.first.wpilibj.SerialPort;

public class TFMiniLidar implements Runnable{
    public static final int BAUD = 115200;

    private Thread thread;
    private SerialPort port;
    private byte[] reads;
    private int bytesBuffered;



    private double distance;
    public TFMiniLidar()
    {
        port = new SerialPort(BAUD, SerialPort.Port.kMXP, 8, SerialPort.Parity.kNone, SerialPort.StopBits.kOne);
        thread = new Thread(this,"tfminithread");
        thread.start();
        reads = new byte[7];
    }
    public synchronized double getDistance()
    {
        return distance;
    }

    @Override
    public synchronized void run() {

        while(true)
        {
            try
            {
                int tempDistance;
                if(port.read(1)[0] == 0x59 && port.read(1)[0] == 0x59)
                {
                    tempDistance = (port.read(1)[0]<<8)+port.read(1)[0];
                    //touch distance as quickly as possible to avoid blocking other threads
                    distance = (double) tempDistance;
                }
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
               // distance = -1.0;
            }
        }
    }
}

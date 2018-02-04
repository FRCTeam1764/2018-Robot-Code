package util;

import edu.wpi.first.wpilibj.Encoder;

public class Grayhill63R {
	Encoder encoder;
	
	public Grayhill63R(int a, int b)
	{
		encoder = new Encoder(a, b, false);
		encoder.setDistancePerPulse(0.07363);
		encoder.reset();
	}
	
	public double getRate()
	{
		return encoder.getRate();
	}
	
	public double getDistance()
	{
		return encoder.getDistance();
	}
	
	public boolean getDirection()
	{
		return encoder.getDirection();
	}
}

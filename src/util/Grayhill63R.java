package util;

import edu.wpi.first.wpilibj.Encoder;

public class Grayhill63R {
	Encoder encoder;
	
	/*
	 * This class is a wrapper for a generic encoder, and specifically configures it for a Grayhill63R hall effect encoder
	 */
	
	public Grayhill63R(int a, int b)
	{
		encoder = new Encoder(a, b, false);
		/*
		 * This is based on wheel diameter 
		 * TODO Change this distance per pulse to be dependent on RobotParameters (gearing and wheel diameter)
		 */
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

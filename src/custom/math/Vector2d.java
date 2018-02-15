package custom.math;

public class Vector2d {
	
	public double x;
	public double y;
	
	/*
	 * This is just a utility class. pretty self explanatory if you understand vector math which most people know. 
	 */
	
	public Vector2d(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Vector2d add(Vector2d v)
	{
		return new Vector2d(this.x + v.x, this.y + v.y);
	}
	
	public Vector2d scale(double s)
	{
		return new Vector2d(this.x * s, this.y * s);
	}
	
	public Vector2d subtract(Vector2d v)
	{
		return this.add(v.scale(-1));
	}
	
	public double getAngle()
	{
		return Math.toDegrees(Math.atan2(this.x, this.y));
	}
	
	public double getAngle(Vector2d v)
	{
		return v.getAngle() - this.getAngle();
	}
	
	public double getLength()
	{
		return Math.sqrt(this.x*this.x + this.y*this.y);
	}
	
	public Vector2d normalize()
	{
		return this.scale(1/this.getLength());
	}
}

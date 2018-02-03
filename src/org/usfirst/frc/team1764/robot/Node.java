package org.usfirst.frc.team1764.robot;

public class Node {
	private double x;
	private double y;
	
	public Node(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double getX()
	{
		return x;
	}
	public double getY()
	{
		return y;
	}
	
	public void setX(double x)
	{
		this.x = x;
	}
	
	public void setY(double y)
	{
		this.y = y;
	}
	
	public Node subtract(Node n)
	{
		return new Node(this.getX() - n.getX(), this.getY() - n.getY());
	}

	public Node add(Node n)
	{
		return new Node(this.getX() + n.getX(), this.getY() + n.getY());
	}
	
	public double getAngle()
	{
		return Math.toDegrees(Math.atan(this.x/this.y));
	}
}

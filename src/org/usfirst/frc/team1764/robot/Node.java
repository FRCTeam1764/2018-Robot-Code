package org.usfirst.frc.team1764.robot;

/**
 * 
 * @author FRC1764
 * This class contains position data for a single point on a path for the robot to follow
 * This is for a very rudimentary path following algorithm and will probably not be used 
 */

public class Node {
	
	private double x;
	private double y;
	
	/*
	 * TODO Change the positional data to be a Vector2d to make math more generalized for these classes
	 */
	
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

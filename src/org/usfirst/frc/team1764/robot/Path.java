package org.usfirst.frc.team1764.robot;

import java.util.ArrayList;

import org.usfirst.frc.team1764.robot.commands.DriveForwardForTime;
import org.usfirst.frc.team1764.robot.commands.TurnToAngle;
import org.usfirst.frc.team1764.robot.commands.WaitFor;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * 
 * @author FRC1764
 *
 * This class basically builds a list of commands for the robot to follow in sequence to move from node to node on a path
 */
public class Path {
	//private CommandGroup parent;

	private ArrayList<Node> nodes;
	
	
	public Path(double[][] path)
	{
		nodes = new ArrayList<>();
		/* Copy a double[][] into a series of nodes */
		for(int i = 0; i < path.length; i++)
		{
			nodes.add(new Node(path[i][0], path[i][1]));
		}
	}
	
	/*
	 * returns a sequence of commands to be followed. will be used by the FollowPath commandGroup to turn the sequence into a commandGroup
	 */
	public ArrayList<Command> buildPath()
	{
		ArrayList<Command> commandList = new ArrayList<>();
		
		commandList.add(new TurnToAngle(nodes.get(0).getAngle()));
		//parent.addSequential(new TurnToAngle(nodes.get(0).getAngle()));
		commandList.add(new DriveForwardForTime(1000));
		for(int i = 1; i < nodes.size(); i++)
		{
			commandList.add(new TurnToAngle(nodes.get(i).getAngle()));
			commandList.add(new DriveForwardForTime(1000));
			commandList.add(new WaitFor(500));
		}
		
		return commandList;
	}
	
}

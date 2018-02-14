package org.usfirst.frc.team1764.robot.commands;

import java.util.ArrayList;

import org.usfirst.frc.team1764.robot.Path;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FollowPath extends CommandGroup {
	ArrayList<Command> commands;
    public FollowPath(Path p) {
    	commands = p.buildPath();
    	
    	/*
    	 * Go through all the commands that the path built for us and make a sequence to follow
    	 */
    	for(Command c : commands)
    	{
    		this.addSequential(c);
    	}

    }
}

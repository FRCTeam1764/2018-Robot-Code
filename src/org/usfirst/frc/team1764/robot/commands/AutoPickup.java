package org.usfirst.frc.team1764.robot.commands;

import org.usfirst.frc.team1764.robot.Path;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoPickup extends CommandGroup {

    public AutoPickup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	double[][] path = {{1,1},
				   {-1,1},
				   {1,1},
				   {-1,1}};

		Path p = new Path(path);
    	addSequential(new FollowPath(p));
    	//addSequential(new AlignToCamera());
    	//addSequential(new DriveForwardForTime(2000));
    }
}

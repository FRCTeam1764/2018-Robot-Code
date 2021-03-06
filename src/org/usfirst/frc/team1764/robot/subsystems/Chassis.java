package org.usfirst.frc.team1764.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SerialPort;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import util.DiffDriveSignal;
import util.Grayhill63R;

import org.usfirst.frc.team1764.robot.RobotMap;
import org.usfirst.frc.team1764.robot.commands.DriveWithJoystick;
/**
 *
 */
public class Chassis extends PIDSubsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	/*
	 * Initialize the motors and stuff
	 */
	public TalonSRX frontLeft, backLeft, frontRight, backRight;
	
	/*
	 * Used for getting angle and acceleration and stuff
	 */
	public AHRS navx;
	
	/*
	 * Shaft encoder
	 */
	public Grayhill63R thingy;
	
	/*
	 * This is added onto the PID output so that you can make the robot drive forward or backwards while aligning to an angle
	 */
	public DiffDriveSignal additive = DiffDriveSignal.NEUTRAL;

	/*
	 * Parameters for PID controller (don't change please) These must be tuned for whatever chassis you are using
	 */
	public static double KP = 0.0275;
	public static double KI = 0.00;
	public static double KD = 0.06;
	
	public Chassis()
	{
		super(KP, KI, KD);
		//this.getPIDController().setContinuous(true);
		this.frontLeft = new TalonSRX(RobotMap.FRONT_LEFT_MOTOR_PORT);
		this.frontRight = new TalonSRX(RobotMap.FRONT_RIGHT_MOTOR_PORT);
		this.backLeft = new TalonSRX(RobotMap.BACK_LEFT_MOTOR_PORT);
		this.backRight = new TalonSRX(RobotMap.BACK_RIGHT_MOTOR_PORT);
		
		/* NavX plugged in to SPI on the MyRioExpansion(MXP) slot */
		this.navx = new AHRS(SPI.Port.kMXP);
		this.thingy = new Grayhill63R(0,1);
		
		/* Defines how close the robot has to be to the target angle to be considered "on target" */
		setAbsoluteTolerance(1);
	}
	
	/* Allows for the input of a diffDriveSignal and sets the motor values without dealing with left and right motor speeds and stupid stuff */
	public void setSignal(DiffDriveSignal s)
	{
		this.frontLeft.set(ControlMode.PercentOutput, s.left);
		this.backLeft.set(ControlMode.PercentOutput, s.left);
		
		this.backRight.set(ControlMode.PercentOutput, -s.right);
		this.frontRight.set(ControlMode.PercentOutput, -s.right);
	}
	
	public void setAdditive(DiffDriveSignal s)
	{
		this.additive = s;
	}
	
	public double getAngle()
	{
		//System.out.println(navx.isConnected());
		return navx.getAngle();
	}
	
	public void resetGyro()
	{
		navx.reset();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveWithJoystick());
    }

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return navx.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		/* So we build a signal from the output that turns to the angle, but don't set our speeds to that just yet */
		DiffDriveSignal pidSignal = new DiffDriveSignal(output, -output);
		/* We tack on that additive value so that we can make the robot drive forward, the PID loop then adjusts for the error in moving forward */
		setSignal(pidSignal.add(additive));
	}
}


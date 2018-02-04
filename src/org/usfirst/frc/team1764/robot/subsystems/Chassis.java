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
	public Talon frontLeft, backLeft, frontRight, backRight;
	public AHRS navx;
	
	public Grayhill63R thingy;
	
	public DiffDriveSignal additive = DiffDriveSignal.NEUTRAL;
	
	//public Potentiometer pot;
	
	public double autoSpeed = 0;
		
	//private DoubleSolenoid shiftSolenoid;
	
	public static double KP = 0.0275;
	public static double KI = 0.00;
	public static double KD = 0.06;
	//public static final double F = 0.00;
	public Chassis()
	{
		super(KP, KI, KD);
		//this.getPIDController().setContinuous(true);
		this.frontLeft = new Talon(RobotMap.FRONT_LEFT_MOTOR_PORT);
		this.frontRight = new Talon(RobotMap.FRONT_RIGHT_MOTOR_PORT);
		this.backLeft = new Talon(RobotMap.BACK_LEFT_MOTOR_PORT);
		this.backRight = new Talon(RobotMap.BACK_RIGHT_MOTOR_PORT);
		this.navx = new AHRS(SPI.Port.kMXP);
		//this.shiftSolenoid = new DoubleSolenoid(RobotMap.SHIFT_SOLENOID_LEFT, RobotMap.SHIFT_SOLENOID_RIGHT);
		this.thingy = new Grayhill63R(0,1);
		setAbsoluteTolerance(1);
	}
	
	public void setSignal(DiffDriveSignal s)
	{
		this.frontLeft.set(s.left);
		this.backLeft.set(s.left);
		
		this.backRight.set(-s.right);
		this.frontRight.set(-s.right);
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
		DiffDriveSignal pidSignal = new DiffDriveSignal(output, -output);
		setSignal(pidSignal.add(additive));
	}
}


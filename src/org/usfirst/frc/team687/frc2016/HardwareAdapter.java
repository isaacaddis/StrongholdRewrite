package org.usfirst.frc.team687.frc2016;

import org.usfirst.frc.team687.lib.Gearbox;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.VictorSP;

//import edu.wpi.first.wpilibj.AnalogGyro;

/**
 * @author huge help from tedfoodlin and team 687
 * 
 */

public class HardwareAdapter {
//	Joysticks, lol
	public static final Joystick articJoy = new Joystick(3);
	public static final Joystick driveJoyLeft = new Joystick(1);
	public static final Joystick driveJoyRight = new Joystick(2);
//	Pneumatics :)
	public static final Compressor compress = new Compressor();
	public static final DoubleSolenoid shooterPunch = new DoubleSolenoid(1, 6);
	public static final DoubleSolenoid kShifter	= new DoubleSolenoid(3,4);
//	Drive Motors (West Coast Drive)
	public static final VictorSP driveRight1 = new VictorSP(0);
	public static final VictorSP driveRight2 = new VictorSP(1);
	public static final VictorSP driveRight3 = new VictorSP(2);
	public static final VictorSP driveLeft1 = new VictorSP(3);
	public static final VictorSP driveLeft2 = new VictorSP(4);
	public static final VictorSP driveLeft3 = new VictorSP(5);
//	Shooter CANTalons
	public static final CANTalon rightShooter = new CANTalon(1);
	public static final CANTalon leftShooter = new CANTalon(2);
	public static final CANTalon shooterAngle = new CANTalon(3);
//	Intake CANTalons
	public static final CANTalon intakeAngle = new CANTalon(4);
	public static final CANTalon intakeRollers = new CANTalon(5);
//	Sensors
	public static final AHRS NavX = new AHRS(SerialPort.Port.kMXP);
	public static final Encoder leftDriveEncode = new Encoder (0,1);
	public static final Encoder rightDriveEncode = new Encoder (2,3);
// Gearboxes
	public static final Gearbox DriveLeftGearbox = new Gearbox(driveLeft1, driveLeft2, driveLeft3, leftDriveEncode, kShifter);
	public static final Gearbox DriveRightGearbox = new Gearbox(driveRight1, driveRight2, driveRight3, rightDriveEncode, null);
// PDP
	public static final PowerDistributionPanel pdp = new PowerDistributionPanel();
	
}
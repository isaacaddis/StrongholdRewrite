package org.usfirst.frc.team687.frc2016.subsystems;

import org.usfirst.frc.team687.frc2016.DriveStraightAction;
import org.usfirst.frc.team687.frc2016.HardwareAdapter;
import org.usfirst.frc.team687.lib.Gearbox;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;

public class Drive {

	private Joystick m_leftJoy = HardwareAdapter.driveJoyLeft;
	private Joystick m_rightJoy = HardwareAdapter.driveJoyRight;
	private Gearbox m_gearLeft = HardwareAdapter.DriveLeftGearbox;
	private Gearbox m_gearRight = HardwareAdapter.DriveRightGearbox;
	private Encoder m_leftDriveEncode = HardwareAdapter.leftDriveEncode;
	private Encoder m_rightDriveEncode = HardwareAdapter.rightDriveEncode;
	private double leftY, rightY;
	/*
	 * @description Tank Drive!	
	 */
	public void drive()
	{
		leftY = m_leftJoy.getY();
		rightY = m_rightJoy.getY();
		if(leftY==rightY){
			DriveStraightAction.driveStraight(clamp(rightY));
		}
		else{
			m_gearLeft.setSpeed(clamp(leftY));
			m_gearRight.setSpeed(clamp(rightY));
		}
	}
	public void shiftUp()
	{
		m_gearLeft.shiftUp();
		m_gearRight.shiftUp();
	}
	
	public void shiftDown()	
	{
		m_gearLeft.shiftDown();
		m_gearRight.shiftDown();
	}
	
	public void resetDriveEncoders()
	{
		m_rightDriveEncode.reset();
		m_leftDriveEncode.reset();
	}
	public double clamp(double input){
		if(input>1)
			return 1;
		else if(input<1)
			return -1;
		else
			return input;
	}
}

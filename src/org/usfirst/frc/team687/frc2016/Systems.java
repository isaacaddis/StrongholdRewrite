package org.usfirst.frc.team687.frc2016;

import org.usfirst.frc.team687.frc2016.subsystems.Shooter;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/*
 * @author: Isaac
 */
public class Systems {
	/*
	 * @description Set everything in our HardwareAdapter class to 0
	 */
	private static PowerDistributionPanel pdp = HardwareAdapter.pdp;
	public static void stop()
	{
//		Stop the drive motors
		HardwareAdapter.driveRight1.set(0);
		HardwareAdapter.driveRight2.set(0);
		HardwareAdapter.driveRight3.set(0);
		HardwareAdapter.driveLeft1.set(0);
		HardwareAdapter.driveLeft1.set(0);
//Stop the shooter motors
		HardwareAdapter.rightShooter.set(0);
		HardwareAdapter.leftShooter.set(0);
		HardwareAdapter.shooterAngle.set(0);
//		Stop the intake motors
		HardwareAdapter.intakeAngle.set(0);
		HardwareAdapter.intakeRollers.set(0);
//		Reset Encoders
		HardwareAdapter.leftDriveEncode.reset();
		HardwareAdapter.rightDriveEncode.reset();
	}
	public static void sendPDPData()
	{
    	SmartDashboard.putNumber("PDP 0", pdp.getCurrent(0));
    	SmartDashboard.putNumber("PDP 1", pdp.getCurrent(1));
    	SmartDashboard.putNumber("PDP 2", pdp.getCurrent(2));
    	SmartDashboard.putNumber("PDP 3", pdp.getCurrent(3));
    	SmartDashboard.putNumber("PDP 4", pdp.getCurrent(4));
    	SmartDashboard.putNumber("PDP 5", pdp.getCurrent(5));
    	SmartDashboard.putNumber("PDP 6", pdp.getCurrent(6));
    	SmartDashboard.putNumber("PDP 7", pdp.getCurrent(7));
    	SmartDashboard.putNumber("PDP 8", pdp.getCurrent(8));
    	SmartDashboard.putNumber("PDP 9", pdp.getCurrent(9));
    	SmartDashboard.putNumber("PDP 10", pdp.getCurrent(10));
    	SmartDashboard.putNumber("PDP 11", pdp.getCurrent(11));
    	SmartDashboard.putNumber("PDP 12", pdp.getCurrent(12));
    	SmartDashboard.putNumber("PDP 13", pdp.getCurrent(13));
    	SmartDashboard.putNumber("PDP 14", pdp.getCurrent(14));
    	SmartDashboard.putNumber("PDP 15", pdp.getCurrent(15));
	}

}

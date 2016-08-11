package org.usfirst.frc.team687.frc2016;

import org.usfirst.frc.team687.lib.Gearbox;
import org.usfirst.frc.team687.lib.NerdyMath;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Timer;

public class DriveStraightAction {
	
	private Gearbox m_leftGearbox = HardwareAdapter.DriveLeftGearbox;
	private Gearbox m_rightGearbox = HardwareAdapter.DriveRightGearbox;
	private AHRS m_nav = HardwareAdapter.NavX;
	double totalError, error;
	
	public void driveStraight(double maxPow){

		totalError = 0;
		error = m_nav.getAngle() % 360;		
		totalError += error;
		double rotPow = (NerdyConstants.kDriveRotationP * error) + (totalError * NerdyConstants.kDriveRotationI);
		double adjustedRotPow = NerdyMath.normalizer(rotPow, maxPow);
			if (error < 180){
				m_rightGearbox.setSpeed(maxPow);
				m_leftGearbox.setSpeed(adjustedRotPow);
			} else if (error > 180){
				m_leftGearbox.setSpeed(maxPow);
				m_rightGearbox.setSpeed(adjustedRotPow);
				
			}
			
		Timer.delay(0.01);
	}
}

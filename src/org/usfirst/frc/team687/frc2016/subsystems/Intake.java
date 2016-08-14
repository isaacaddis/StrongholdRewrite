package org.usfirst.frc.team687.frc2016.subsystems;

import org.usfirst.frc.team687.frc2016.NerdyConstants;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;

public class Intake {
	private static CANTalon m_rollers, m_angleAdjust;
	private static Joystick m_articJoy;
	public static void control(CANTalon rollers, CANTalon angleAdjust, Joystick joy){
		m_rollers = rollers;
		m_angleAdjust = angleAdjust;
		m_articJoy = joy;
		if(m_articJoy.getRawButton(NerdyConstants.intakeAngleUpButton)){
			m_angleAdjust.set(1);
		}
		else if(m_articJoy.getRawButton(NerdyConstants.intakeAngleDownButton)){
			m_angleAdjust.set(-1);
		}	
		if(m_articJoy.getRawButton(NerdyConstants.intakeRollersButton)){
			m_rollers.set(1);
		}
		else if(m_articJoy.getRawButton(NerdyConstants.intakeRollersReverseButton)){
			m_rollers.set(-1);
		}
	}
}

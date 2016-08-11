package org.usfirst.frc.team687.lib;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;

public class Gearbox {
	private SpeedController m_motor1;
	private SpeedController m_motor2;
	private SpeedController m_motor3;
	private Encoder m_encode;
	private DoubleSolenoid m_shifter;
	private boolean m_reversed;
	public Gearbox(SpeedController motor1, SpeedController motor2, SpeedController motor3, Encoder encode, DoubleSolenoid shifter){
		m_motor1 = motor1;
		m_motor2 = motor2;
		m_motor3 = motor3;
		m_encode = encode;
		m_shifter = shifter;
	}
	public void setReversed(boolean reversed){
		m_reversed = reversed;
	}
	public void setReversed(){
		setReversed(true);
	}
	public void shiftUp(){
		if(m_shifter!=null){
			m_shifter.set(DoubleSolenoid.Value.kReverse);
		}
	}
	public void shiftDown(){
		if(m_shifter!=null){
			m_shifter.set(DoubleSolenoid.Value.kForward);
		}
	}
	public void setSpeed(double speed){
		m_motor1.set(speed * (m_reversed ? -1:1));
		m_motor2.set(speed * (m_reversed ? -1:1));
		m_motor3.set(speed * (m_reversed ? -1:1));

	}
	public void setEncoderDistancePerPulse(double distancePerPulse){
		if(m_encode!=null){
			m_encode.setDistancePerPulse(distancePerPulse);
		}
	}
	public double getEncoderDistance(){
		if(m_encode!=null){
			return m_encode.getDistance();
		}
		else{
			return 0;
		}
	}
	public void resetEncoder(){
		if(m_encode!=null){
			m_encode.reset();
		}
	}
}

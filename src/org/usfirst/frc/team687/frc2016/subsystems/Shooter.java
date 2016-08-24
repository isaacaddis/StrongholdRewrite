package org.usfirst.frc.team687.frc2016.subsystems;

import org.usfirst.frc.team687.frc2016.NerdyConstants;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
/*
 * @author Isaac with some elements (noted by Javadocs) borrowed from tedfoodlin
 * 
 * TODO: Take-Back-Half Control
 */
public class Shooter {
	private static CANTalon m_leftShoot;
	private static CANTalon m_rightShoot;
	private static CANTalon m_lifter;
	private static DoubleSolenoid m_shooterSol;
	private static double m_actual;
	private static double m_desired;
	private static double m_error;
	private static Joystick m_articJoy;
	private static Encoder m_angleEncode;
	private static Encoder m_leftEncode;
	private static Encoder m_rightEncode;
	private static double m_outerWorksAngle = NerdyConstants.kOuterWorksAngle;
	private static double m_batterAngle = NerdyConstants.kOuterWorksAngle;
	private static double m_lifterAlpha = NerdyConstants.kLiftAlpha;
	public Shooter(CANTalon leftShooter, CANTalon rightShooter, CANTalon lifter, DoubleSolenoid shooterKick, Joystick articJoy, Encoder lifterEncode, Encoder leftEncode, Encoder rightEncode){
		m_leftShoot = leftShooter;
		m_rightShoot = rightShooter;
		m_lifter = lifter;
		m_shooterSol = shooterKick;
		m_articJoy = articJoy;
		m_angleEncode = lifterEncode;
		m_leftEncode = leftEncode;
		m_rightEncode = rightEncode;
	}
	/*
	 * Controls m_lifter based on the parameter provided. 
	 * TODO: Create a switch/case instead of if/else???
	 */
	public static void changeAngle(String type){
		if(type=="BUTTON"){
			buttonStuff();
			m_error = determineError(m_articJoy.getY());
			setAngle(m_error);
		}
		else{
			buttonStuff();
			m_error = determineError((m_articJoy.getThrottle()+1)/2);
			setAngle(m_error);
		}
	}
	/*
	 * Bang bang
	 */
	public static void shoot()
	{
		double throttleRaw = (m_articJoy.getThrottle() + 1)/2;
		
		timedShooterEncoderReset();
			
		//push
		if (m_articJoy.getRawButton(NerdyConstants.shooterPunchButton)){
			m_shooterSol.set(DoubleSolenoid.Value.kForward);
		}
		//shoot (minus all complicated physics formulas)
		if (m_articJoy.getRawButton(NerdyConstants.shootOuterWorksButton)){
			bangBang(4000 * throttleRaw);
		}

	}
	public static void bangBang(double desired)
	{
		double rightRate = m_rightEncode.getRate();
		double leftRate = m_leftEncode.getRate();

		if (rightRate < (desired + 2) && leftRate < (desired + 2)){
			m_rightShoot.set(1);
			m_leftShoot.set(1);
		}
	}
	/*
	 * Does what it says. Finds actual value at a given point and applies the formula desired-actual to return error.
	 */
	public static double determineError(double desired){
		double actual = m_angleEncode.get() - angleEncoderNegation();
		return desired - actual;
	}
	/*
	 * @author: Ted
	 * Thanks
	 */
	protected static double angleEncoderNegation(){
		double previousEncoderVal = m_angleEncode.get();
		if (m_angleEncode.getDirection()){
			m_angleEncode.reset();
		}
		double currentEncoderVal = m_angleEncode.get();
		return previousEncoderVal - currentEncoderVal;
	}
	/*
	 * @TODO: Smarter outputting****
	 */
	public static void setAngle(double error){
		if (error < 0.1) {
			if(error<0.05){
				m_lifter.set(-0.1);
			}
			else{
			m_lifter.set(-1);
			}
		}
		if (error > 0.1) {
			if (error > 0.05) {
				m_lifter.set(0.1);
			}
			else{
				m_lifter.set(0.8);	
			}
		}
		
	}
	/*
	 * Could not think of a good name. Created to avoid repeat code
	 */
	public static void buttonStuff()
	{
		m_lifter.changeControlMode(TalonControlMode.Position);
		if (m_articJoy.getRawButton(NerdyConstants.shooterAngleBatterShotButton)){
			m_desired = m_batterAngle; // 0.86
			lowPassFilter();
			m_lifter.set(m_actual);
		}
		if (m_articJoy.getRawButton(NerdyConstants.shooterAngleOuterworksShotButton)){
			m_desired = m_outerWorksAngle; // 0.86
			lowPassFilter();
			m_lifter.set(m_actual);
		}	
	}
	private static double lowPassFilter()
	{
					m_actual = m_actual*(1-m_lifterAlpha) + m_desired*m_lifterAlpha; 
					return m_actual;
	}
	/*
	 * @author: Ted
	 */
	protected static void timedShooterEncoderReset()
	{
		if (!m_articJoy.getRawButton(NerdyConstants.shootOuterWorksButton) && !m_articJoy.getRawButton(NerdyConstants.shootBatterButton) 
				&& !m_articJoy.getRawButton(NerdyConstants.shootLowGoalButton)){
			if (m_leftEncode.getStopped() && m_rightEncode.getStopped()){
				m_leftEncode.reset();
				m_rightEncode.reset();
			}
		}
	}
}

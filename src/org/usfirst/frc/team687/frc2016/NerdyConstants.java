package org.usfirst.frc.team687.frc2016;

public class NerdyConstants {

	public final static double kDriveRotationP		= 0.04444444;
	public final static double kDriveRotationI		= 0.00044444;
	public final static double kDriveMaxAccel		= 1.5;
	
	public final static double kFlywheelF			= 0;
	public final static double kFlywheelP			= 0.08204;
	public final static double kFlywheelI			= 0.0005;
	public final static double kFlywheelD			= 0.375;
	public final static double kLiftF				= 0;
	public final static double kLiftP				= 3;
	public final static double kLiftI				= 0.015625;
	public final static double kLiftD				= 0;
	public final static double kLiftAlpha			= 0.05;
	public final static double kShootTime			= 0.5;
	
	//random values
	public static final double kForward				= 0.000137500;
	public static final double bForward				= 0.080000000;
	
	public static int kHighGoalRPM					= 4000;
	public static int kLowGoalRPM					= 1000;
	public final static int kShortRangeRPM			= 2000;
	public final static int kMediumRangeRPM			= 3000;
	public final static int kLongRangeRPM			= 4000;

	public static double kOuterWorksAngle			= 0.860;	// 45 deg
	public static double kBatterAngle				= 0.860;	
	public static double kOffBatterAngle			= 0.860;	
	
	public final static double kMinHeight			= 0.652;
	public final static double kMaxHeight			= 0.823;
	
	public final static double kIntakeSpeed			= 0.8;
	public final static double kIntakeF				= 0;
	public final static double kIntakeP				= 4;
	public final static double kIntakeI				= 0;
	public final static double kIntakeD				= 16;
	public final static double kIntakeAlpha			= 0.025;
	
	public final static double kIntakeBallPickup	= 0.473;
	public final static double kIntakeResting		= 0.787;
	public final static double kIntakeTucked		= 0.575;
	public final static double kIntakeGround		= 0.421;
	
	public final static int intakeBallAngleButton 		 		= 1;
	public final static int intakeTuckButton 		   		    = 2;
	public final static int intakeRestButton				    = 3;
	public final static int intakeRollersButton 			    = 4;
	public final static int intakeRollersReverseButton		    = 5;
	
	public final static int shooterAngleBatterShotButton 		= 6;
	public final static int shooterAngleOuterworksShotButton 	= 7;
	
	public final static int shooterPunchButton 					= 8;
	public final static int shootBatterButton 					= 9;
	public final static int shootOuterWorksButton				= 11;
	public final static int shootLowGoalButton 					= 12;
	
}


package org.usfirst.frc.team687.frc2016;

import org.usfirst.frc.team687.frc2016.subsystems.Drive;
import org.usfirst.frc.team687.frc2016.subsystems.Intake;
import org.usfirst.frc.team687.frc2016.subsystems.Shooter;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
    final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    String autoSelected;
    SendableChooser chooser;
    CANTalon intakeRollers = HardwareAdapter.intakeRollers;
    CANTalon intakeAngle = HardwareAdapter.intakeAngle;
    Joystick articJoy = HardwareAdapter.articJoy;

    public void robotInit() {
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", defaultAuto);
        chooser.addObject("My Auto", customAuto);
        SmartDashboard.putData("Auto choices", chooser);
    }
    
    public void autonomousInit() {
    	autoSelected = (String) chooser.getSelected();
//		autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
    }
    public void autonomousPeriodic() {
    	switch(autoSelected) {
    	case customAuto:
        //Put custom auto code here   
            break;
    	case defaultAuto:
    	default:
    	//Put default auto code here
            break;
    	}
    }
    public void teleopPeriodic() {
    	Intake.control(intakeRollers, intakeAngle, articJoy);
    	Drive.drive();	
    	Shooter.shoot();
    	Shooter.changeAngle("BUTTON");
    	
    }
    public void disabledInit(){
    	Systems.stop();
    	System.out.println("Robot disabled.");
    }
    public void disabledPeriodic(){
//    	Don't do anything since we already stop everything in init
    }
    public void allPeriodic(){
    	Systems.sendPDPData();
    }
}

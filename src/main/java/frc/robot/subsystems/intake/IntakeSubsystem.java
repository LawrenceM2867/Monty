// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;

/** Add your docs here. */
public class IntakeSubsystem extends SubsystemBase {
    TalonSRX frontmotor = new TalonSRX(MotorConstants.frontRollerID);
    TalonSRX LIndexer = new TalonSRX(MotorConstants.leftIndexerID);
    TalonSRX RIndexer = new TalonSRX(MotorConstants.rightIndexerID);

    Solenoid intake;

    public IntakeSubsystem(PneumaticHub hub) {
        intake = hub.makeSolenoid(MotorConstants.intakesolenoidID);

        LIndexer.follow(frontmotor);
        RIndexer.follow(frontmotor);

        intake.set(false);
    }

    public void setSpeed(double speed) {
        frontmotor.set(ControlMode.PercentOutput, speed);
    }

    public void setState(boolean state) {
        intake.set(state);
    }
}

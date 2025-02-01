// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drivetrain;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import frc.robot.Constants.MotorConstants;

public class DrivetrainSparkMax implements DrivetrainIO {
    private final SparkMax leftMain = new SparkMax(MotorConstants.LFSparkMaxID, MotorType.kBrushless);
    private final SparkMax leftFollow = new SparkMax(MotorConstants.LBSparkMaxID, MotorType.kBrushless);
    private final RelativeEncoder leftEncoder = leftMain.getEncoder();

    private final SparkMax rightMain = new SparkMax(MotorConstants.RFSparkMaxID, MotorType.kBrushless);
    private final SparkMax rightFollow = new SparkMax(MotorConstants.RBSparkMaxID, MotorType.kBrushless);
    private final RelativeEncoder rightEncoder = rightMain.getEncoder();
    
    SparkMaxConfig leftMainConfig = new SparkMaxConfig();
    SparkMaxConfig rightMainConfig = new SparkMaxConfig();
    SparkMaxConfig leftFollowConfig = new SparkMaxConfig();
    SparkMaxConfig rightFollowConfig = new SparkMaxConfig();

    public DrivetrainSparkMax() {
        leftMain.setCANTimeout(250);
        leftFollow.setCANTimeout(250);
        rightMain.setCANTimeout(250);
        rightFollow.setCANTimeout(250);

        leftMainConfig.inverted(true);
        rightMainConfig.inverted(false);

        leftFollowConfig.follow(leftMain);
        rightFollowConfig.follow(rightMain);

        leftMain.configure(leftMainConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightMain.configure(rightMainConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        leftFollow.configure(leftFollowConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightFollow.configure(rightFollowConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    @Override
    public void updateInputs(DrivetrainIOInputs inputs) {
        inputs.leftPositionMeters = leftEncoder.getPosition();
        inputs.leftVelocityMetersPerSecond = leftEncoder.getVelocity();
        inputs.leftCurrentAmps = new double[] {leftMain.getOutputCurrent()};
        inputs.leftTempCelsius = new double[] {leftMain.getMotorTemperature()};
        
        inputs.rightPositionMeters = rightEncoder.getPosition();
        inputs.rightVelocityMetersPerSecond = rightEncoder.getVelocity();
        inputs.rightCurrentAmps = new double[] {rightMain.getOutputCurrent()};
        inputs.rightTempCelsius = new double[] {rightMain.getMotorTemperature()};
    }

    @Override
    public void setVolts(double left, double right) {
        leftMain.setVoltage(left);
        rightMain.setVoltage(right);
    }
}
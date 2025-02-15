// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class MotorConstants {
    public static final int LBSparkMaxID = 3;
    public static final int LFSparkMaxID = 1;
    public static final int RFSparkMaxID = 2;
    public static final int RBSparkMaxID = 4;

    public static final int frontRollerID = 11;
    public static final int leftIndexerID = 12;
    public static final int rightIndexerID = 13;
    public static final int bottomTrackID = 14;
    public static final int intakesolenoidID = 8;
}
}

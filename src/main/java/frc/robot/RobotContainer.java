// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.drivetrain.DrivetrainSubsystem;
import frc.robot.subsystems.intake.IntakeSubsystem;
import frc.robot.subsystems.intake.commands.SetIntakeState;
import frc.robot.subsystems.drivetrain.DrivetrainSparkMax;

public class RobotContainer {
  CommandXboxController controller = new CommandXboxController(0);

  private final PneumaticHub hub = new PneumaticHub(31);
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem(hub);

  DrivetrainSubsystem drivetrainSubsystem;

  public RobotContainer() {
    drivetrainSubsystem = new DrivetrainSubsystem(new DrivetrainSparkMax());
    configureBindings();
  }

  private void configureBindings() {
    drivetrainSubsystem.setDefaultCommand(
      drivetrainSubsystem.setVoltagesArcadeCommand(
        () -> -modifyJoystick(controller.getLeftX()),
        () -> -modifyJoystick(controller.getLeftY())));
    
    controller.a().toggleOnTrue(new SetIntakeState(intakeSubsystem, true));
  }

  private double modifyJoystick(double in) {
    if (Math.abs(in) < 0.05) {
      return 0;
    }
    return in * in * Math.signum(in);
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}

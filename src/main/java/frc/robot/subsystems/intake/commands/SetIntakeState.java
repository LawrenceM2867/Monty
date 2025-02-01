// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.intake.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.intake.IntakeSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class SetIntakeState extends Command {
  public final IntakeSubsystem intake;
  public final boolean state;

  /** Creates a new SetIntakeState. */
  public SetIntakeState(IntakeSubsystem intake, boolean state) {
    this.intake = intake;
    this.state = state;
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intake.setState(state);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.setState(false);
  }
}

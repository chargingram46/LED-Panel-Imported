// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.LEDPanel.LEDPanel;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LEDStrip.LEDStrip;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  // private final LEDPanel m_LEDPanel = new LEDPanel();
  static public final LEDStrip m_LEDStrip = new LEDStrip();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    CommandBase c = new frc.robot.commands.LEDStrip.BallFound();
    c.setName("Ball Found");
    SmartDashboard.putData(c);

    CommandBase c1 = new frc.robot.commands.LEDStrip.BallNotFound();
    c1.setName("Ball Not Found");
    SmartDashboard.putData(c1);

    CommandBase c2 = new frc.robot.commands.LEDStrip.HubNotFound();
    c2.setName("Hub Not Found");
    SmartDashboard.putData(c2);

    CommandBase c3 = new frc.robot.commands.LEDStrip.HubFound();
    c3.setName("Hub Found");
    SmartDashboard.putData(c3);

    CommandBase c4 = new frc.robot.commands.LEDStrip.HubTargeted();
    c4.setName("Hub Targeted");
    SmartDashboard.putData(c4);

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.team5431.titan.core.misc.Logger;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  // Objects for mostly internal Robot.java usage
  private RobotMap robotMap;
  private Command autonCommand;

  private boolean performedEnabled = false;

  // The Following is Initializer Functions

  @Override
  public void robotInit() {
    Logger.DEBUG = true;
    robotMap = new RobotMap();
    CameraServer.getInstance().startAutomaticCapture();
    robotMap.printAutonChooser();
    robotMap.disabled();
  }

  @Override
  public void robotPeriodic() {
    robotMap.printAutonChooser();
    CommandScheduler.getInstance().run();
  }

  /**
   * This autonomous runs the autonomous command selected by your
   * {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    autonCommand = robotMap.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (autonCommand != null) {
      autonCommand.schedule();
    }

    robotMap.printAutonChooser();
  }

  @Override
  public void teleopInit() {
    if (autonCommand != null) {
      autonCommand.cancel();
    }
  }

  @Override
  public void disabledPeriodic() {
    robotMap.disabledPeriodic();
  }

  @Override
  public void autonomousPeriodic() {
    if (!performedEnabled) {
      robotMap.enabled();
      performedEnabled = true;
    }
  }

  @Override
  public void teleopPeriodic() {
    if (!performedEnabled) {
      robotMap.enabled();
      performedEnabled = true;
    }
  }

  @Override
  public void disabledInit() {
    robotMap.disabled();
    performedEnabled = false;
  }
}

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.button.*;
import frc.robot.auton.*;
import frc.robot.commands.defaults.*;
import frc.robot.commands.subsystems.*;
import frc.team5431.titan.core.joysticks.*;
// import frc.team5431.titan.core.joysticks.LogitechExtreme3D.Axis;
import frc.team5431.titan.core.misc.Logger;

/**
 * @author Colin Wong
 */
public class RobotMap {
	private final Systems systems = new Systems();

	private final Xbox driver = new Xbox(0);
	// private final Joystick buttonBoard = new Joystick(1);
	// private final LogitechExtreme3D operator = new LogitechExtreme3D(2);

	SendableChooser<AutonStates> chooser = new SendableChooser<>();

	public RobotMap() {
		bindKeys();

		printAutonChooser();
    }

	public void printAutonChooser() {
		chooser.setDefaultOption("Drive forward", AutonStates.DRIVE_FORWARD);
		chooser.addOption("Drive forward, backward", AutonStates.DRIVE_FORWARD_BACKWARD);
		SmartDashboard.putData("Auton Select", chooser);
	}

	private void bindKeys() {
		
		// ===========================
		// ||                       ||
		// ||    XBOX Controller    ||
		// ||                       ||
		// ===========================
		{
			// Balancer Left
			new JoystickButton(driver, Xbox.Button.BUMPER_L.ordinal() + 1)
					.whenHeld(new BalancerCommand(systems, true));

			// Balancer Right
			new JoystickButton(driver, Xbox.Button.BUMPER_R.ordinal() + 1)
					.whenHeld(new BalancerCommand(systems, false));

		}

		// ===========================
		// ||                       ||
		// ||     Button  Board     ||
		// ||                       ||
		// ===========================
		{
			/*
			 * Not used as it is bound to triggers for the driver but here for historical
			 * purposes
			 * 
			 * // Climb new JoystickButton(buttonBoard, 8);
			 */

			// Stow
			// new JoystickButton(buttonBoard, 12)
			// 		.whenPressed(new StowSuperCommand(systems));

		}

		// ===========================
		// ||                       ||
		// ||   Logitech Operator   ||
		// ||                       ||
		// ===========================
		{
			// RIP operator
		}

		// ===========================
		// ||                       ||
		// ||   Default  Commands   ||
		// ||                       ||
		// ===========================
		{
			driver.setDeadzone(Constants.DRIVER_XBOX_DEADZONE);

			systems.getDrivebase().setDefaultCommand(new DefaultDrive(systems,
					() -> -driver.getRawAxis(Xbox.Axis.LEFT_Y)*0.5,() -> -driver.getRawAxis(Xbox.Axis.LEFT_X)*0.5));

			systems.getElevator().setDefaultCommand(new DefaultElevator(systems,
					() -> driver.getRawAxis(Xbox.Axis.TRIGGER_RIGHT) - driver.getRawAxis(Xbox.Axis.TRIGGER_LEFT)));
		}
	}

	public CommandBase getAutonomousCommand() {
		switch(chooser.getSelected()) {
			case DRIVE_FORWARD:
				return new DriveForward(systems);
			case DRIVE_FORWARD_BACKWARD:
				return new DriveForwardBackward(systems);
			default:
				return new SequentialCommandGroup(
					
				);
		}
	}

	public void enabled() {
		Logger.l("enabled!");
	}

	public void disabled() {
		// These two functions should do the same thing but is both here just in case
		CommandScheduler.getInstance().cancelAll();
		systems.clearAllCommands();

		// Make sure chooser is always shown
		printAutonChooser();

		Logger.l("disabled!");
	}

	public void disabledPeriodic() {
		printAutonChooser();
	}
}
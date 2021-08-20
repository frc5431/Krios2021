package frc.robot;

import java.util.List;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.*;
import frc.team5431.titan.core.misc.Logger;

public class Systems {

	private final WPI_TalonSRX balancer_Talon;

	private final WPI_TalonFX drivebase_Falcon_Left_Back;
	private final WPI_TalonFX drivebase_Falcon_Left_Front;

	private final WPI_TalonFX drivebase_Falcon_Right_Back;
	private final WPI_TalonFX drivebase_Falcon_Right_Front;

	private final WPI_TalonFX elevator_Falcon;

	private final PowerDistributionPanel pdp;

	private final Balancer balancer;
	private final Drivebase drivebase;
	private final Elevator elevator;

	private final List<SubsystemBase> subsystems;

	public Systems() {

		balancer_Talon = new WPI_TalonSRX(Constants.CLIMBER_BALANCER_ID);

		drivebase_Falcon_Left_Back = new WPI_TalonFX(Constants.DRIVEBASE_BACK_LEFT_ID);
		drivebase_Falcon_Left_Front = new WPI_TalonFX(Constants.DRIVEBASE_FRONT_LEFT_ID);
		drivebase_Falcon_Right_Back = new WPI_TalonFX(Constants.DRIVEBASE_BACK_RIGHT_ID);
		drivebase_Falcon_Right_Front = new WPI_TalonFX(Constants.DRIVEBASE_FRONT_RIGHT_ID);

		elevator_Falcon = new WPI_TalonFX(Constants.CLIMBER_ELEVATOR_ID);

		final String constructing = "Constructing %s Object!";

		Logger.l(constructing, "PowerDistributionPanel");
		pdp = new PowerDistributionPanel();

		// Independent Subsystems
		Logger.l(constructing, "Balancer");
		balancer = new Balancer(balancer_Talon);
		
		Logger.l(constructing, "Drivebase");
		drivebase = new Drivebase(drivebase_Falcon_Left_Front, drivebase_Falcon_Right_Front, drivebase_Falcon_Left_Back, drivebase_Falcon_Right_Back);
		
		Logger.l(constructing, "Elevator");
		elevator = new Elevator(elevator_Falcon);

		subsystems = List.of(
			balancer, drivebase, elevator
		);
	}

	/**
	 * This Function Will Clear All Commands From Every Subsystem
	 */
	public void clearAllCommands() {
		Logger.l("Clearing Commands In All Subsystems");
		subsystems.forEach(subsystem -> {
            Command command = subsystem.getCurrentCommand();
            if (command != null) command.cancel();
        });
	}

	/**
	 * @return the balancer
	 */
	public Balancer getBalancer() {
		return balancer;
	}

	/**
	 * @return the drivebase
	 */
	public Drivebase getDrivebase() {
		return drivebase;
	}

	/**
	 * @return the elevator
	 */
	public Elevator getElevator() {
		return elevator;
	}

	/**
	 * @return the pdp
	 */
	public PowerDistributionPanel getPdp() {
		return pdp;
	}

	/**
	 * 
	 * @return a list of all Falcon 500s on the robot
	 */
	public List<WPI_TalonFX> getAllFalcons() {
		return List.of(
			drivebase_Falcon_Left_Back,
			drivebase_Falcon_Left_Front,
			drivebase_Falcon_Right_Back,
			drivebase_Falcon_Right_Front,
			elevator_Falcon
		);
	}
}
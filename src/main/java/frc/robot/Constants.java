package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import frc.robot.util.MotionMagic;

/**
 * @author Colin Wong
 */
public final class Constants {

    // ================================================================================
    // Teleop Controller Data
    // ================================================================================

    /*
     * Controller name does not need to be the enitre string but must contain a word
     * from the HID name.
     * 
     * Capitalization does not matter. All strings shoud be translated to lowercase
     * by the software. Setting the the name of the controller is for safty as you
     * do not want a secondary controller accidentally controlling the robot when it
     * may have a different layout.
     */

    public static final int DRIVER_XBOX_ID = 0;
    public static final double DRIVER_XBOX_DEADZONE = 0.15;
    public static final String DRIVER_XBOX_NAME = "xbox";

    public static final int OPERATOR_LOGITECH_ID = 1;
    public static final double OPERATOR_LOGITECH_DEADZONE = 0.10;
    public static final String OPERATOR_LOGITECH_NAME = "logitech";

    public static final int DRIVEBASE_TIMEOUT_MS = 30;

    public static final int SLOT_0 = 0;
    public static final int SLOT_1 = 1;
    public static final int SLOT_2 = 2;
    public static final int SLOT_3 = 3;

    public static final int REMOTE_0 = 0;
    public static final int REMOTE_1 = 1;

    // ================================================================================
    // Motor ID`s and Reverse State
    // ================================================================================

    // Drivebase Related
    public static final int DRIVEBASE_FRONT_LEFT_ID = 1;
    public static final int DRIVEBASE_BACK_LEFT_ID = 4;
    public static final boolean DRIVEBASE_LEFT_REVERSE = false;

    public static final int DRIVEBASE_FRONT_RIGHT_ID = 3;
    public static final int DRIVEBASE_BACK_RIGHT_ID = 2;
    public static final boolean DRIVEBASE_RIGHT_REVERSE = true;

    public static final double DRIVEBASE_TURN_MAX_SPEED = 0.35;

    public static final NeutralMode DRIVEBASE_NEUTRAL_MODE = NeutralMode.Brake;

    public static final double DRIVEBASE_DEFAULT_RAMPING = 0.6;

    // Climber Related
    public static final int CLIMBER_BALANCER_ID = 13;
    public static final boolean CLIMBER_BALANCER_REVERSE = false;

    public static final int CLIMBER_ELEVATOR_ID = 6;
    public static final boolean CLIMBER_ELEVATOR_REVERSE = true;
    public static final NeutralMode CLIMBER_ELEVATOR_NEUTRALMODE = NeutralMode.Brake;

    public static final int CLIMBER_ELEVATOR_UPPER_LIMIT = 700000;
    public static final int CLIMBER_ELEVATOR_LOWER_LIMIT = 1000;

    // ================================================================================
    // IMU Data
    // ================================================================================

    public static final int DRIVEBASE_PIGEON_IMU_ID = 13;
    public static final int DRIVEBASE_PIGEON_IMU_REMOTE_FILTER = 0;

    // ================================================================================
    // Drive Base Motion Magic
    // ================================================================================

    // ================================================================================
    // Drive Base Numbers
    // ================================================================================

    public static final double COUNTS_PER_REVOLUTION = 2048;
    public static final double WHEEL_CIRCUMFERENCE = 18.85;
    public static final double GEAR_RATIO = 9.64;
    public static final double MAX_MOTOR_SPEED = 1;

    // TODO: Set Proper PID Values
    // P, I, D, F, INTERGRAL_ZONE, PEAKOUTPUT, CLOSEDLOOPTIME_MS
    public static final MotionMagic DRIVEBASE_MOTIONMAGIC_DRIVE_GAINS = new MotionMagic(0.2, 0, 0, 0, 100, 1, 1);
    public static final MotionMagic DRIVEBASE_MOTIONMAGIC_TURN_GAINS = new MotionMagic(0.2, 0, 0, 0, 100, 1, 1);
    public static final int DRIVEBASE_MOTIONMAGIC_DRIVE_SLOT = SLOT_0;
    public static final int DRIVEBASE_MOTIONMAGIC_TURN_SLOT = SLOT_1;
    public static final int DRIVEBASE_MOTIONMAGIC_DRIVE_REMOTE = REMOTE_0;
    public static final int DRIVEBASE_MOTIONMAGIC_TURN_REMOTE = REMOTE_1;

    // ================================================================================
    // Tolerances and Ranges
    // ================================================================================

    public static final double DRIVEBASE_MOTIONMAGIC_TOLERANCE = 150; // Tolerance in sensor units for deciding when
                                                                      // motion magic is finished
    public static final double DRIVEBASE_ANGLE_TOLERANCE = 5; // TODO: find good angle
}

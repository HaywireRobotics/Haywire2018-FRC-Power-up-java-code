/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team1569;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap 
{
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;

    //Joystick constants
    public static final int joystickLeftPort = 1;
    public static final int joystickRightPort = 0;
    public static final int joystickManipulator1Port = 2;
    public static final int getJoystickManipulator2Port = 3;

    //Motor constants
    public static final int driveTrainLeft0Port = 0;
    public static final int driveTrainLeft1Port = 1;
    public static final int driveTrainRight0Port = 8;
    public static final int driveTrainRight1Port = 9;

    public static final int liftPort0 = 5;
    public static final int liftPort1 = 6;
    public static final int clawPort = 4;

    public static final int climbTapePort = 2;
    public static final int climbWinchPort = 3;

    //Button constants
    public static final int JMExtendPistonNum = 1;
    public static final int JMRetractPistonNum = 3;

    public static final int JMClawRotatePos = 4;
    public static final int JMClawRotateNeg = 5;

    public static final int JMTapeOut = 6;
    public static final int JMTapeIn = 7;

    public static final int JMWinchIn = 10;
    public static final int JMWinchOut = 9;

    //Pneumatics constants
    public static final int solenoid1OpenPort = 0;
    public static final int solenoid1ClosePort = 1;

    //Sensors constants
    public static final int magSwitchPort = 2;
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team1569;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI 
{
    // CREATING BUTTONS
    // One type of button is a joystick button which is any button on a
    // joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    private Joystick stickLeft;
    private Joystick stickRight;
    private Joystick stickManipulate1;
    private Joystick stickManipulate2;
    private UsbCamera camera;
    private UsbCamera camera1;

    public OI() {
        this.stickLeft = new Joystick(RobotMap.joystickLeftPort);
        this.stickRight = new Joystick(RobotMap.joystickRightPort);
        this.stickManipulate1 = new Joystick(RobotMap.joystickManipulator1Port);
        this.stickManipulate2 = new Joystick(RobotMap.getJoystickManipulator2Port);

        this.camera = CameraServer.getInstance().startAutomaticCapture();
        this.camera.setResolution(640, 480);
        this.camera.setFPS(15);
        this.camera.setExposureAuto();

        this.camera1 = CameraServer.getInstance().startAutomaticCapture();
        this.camera1.setResolution(640, 480);
        this.camera1.setFPS(15);
        this.camera1.setExposureAuto();
    }

    public Joystick getLeftJoystick() { return this.stickLeft; }
    public Joystick getRightJoystick() { return this.stickRight; }
    public Joystick getManipulator1Joystick() { return this.stickManipulate1; }
    public Joystick getManipulator2Joystick() { return this.stickManipulate2; }

}

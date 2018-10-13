package frc.team1569.subsystems;


import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.team1569.RobotMap;
import frc.team1569.commands.TeleopCommand;

public class DriveTrainSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private PWMVictorSPX driveTrainLeft0 = new PWMVictorSPX(RobotMap.driveTrainLeft0Port);
    private PWMVictorSPX driveTrainLeft1 = new PWMVictorSPX(RobotMap.driveTrainLeft1Port);
    private SpeedControllerGroup driveTrainLeftGroup = new SpeedControllerGroup(driveTrainLeft0, driveTrainLeft1);

    private PWMVictorSPX driveTrainRight0 = new PWMVictorSPX(RobotMap.driveTrainRight0Port);
    private PWMVictorSPX driveTrainRight1 = new PWMVictorSPX(RobotMap.driveTrainRight1Port);
    private SpeedControllerGroup driveTrainRightGroup = new SpeedControllerGroup(driveTrainRight0, driveTrainRight1);

    private DifferentialDrive myRobot = new DifferentialDrive(driveTrainLeftGroup, driveTrainRightGroup);
    private boolean drivingBackward;

    private ADXRS450_Gyro gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);

    public DriveTrainSubsystem() {
        this.drivingBackward = false;
    }

    public void initDefaultCommand() {
        setDefaultCommand(new TeleopCommand());
    }

    public void takeJoystickInputs(Joystick left, Joystick right) {
        // TODO: Make sure the drive acts correctly
        myRobot.tankDrive(left.getY(), right.getY());
    }

    public void tankDrive(double left, double right) {
        myRobot.tankDrive(left, right, false);
    }

    public void stopRobot() {
        myRobot.tankDrive(0, 0, false);
    }

    public void driveForward(double speed) { this.tankDrive(speed, speed); }

    public boolean isDrivingBackward() {
        return drivingBackward;
    }

    public void setDrivingBackward(boolean drivingBackward) {
        this.drivingBackward = drivingBackward;
    }

    public double getGyroValue() { return this.gyro.getAngle(); }

    public void resetGyro() { gyro.reset(); }
}


package frc.team1569.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team1569.Robot;

import static java.lang.Math.max;


public class DriveRightTurn extends Command {

    private boolean startLoop;
    private double inputAngle;
    private double turnAngle;
    private double speed;
    private double rampSpeed;
    private double oneQuarterAngle;
    private double threeQuarterAngle;
    private double currentProgress;
    private double beforeAngle;

    public DriveRightTurn(double angle) {
        requires(Robot.driveTrainSubsystem);
        this.startLoop = true;
        this.turnAngle = Robot.driveTrainSubsystem.getGyroValue() + angle;
        this.inputAngle = angle;
        this.speed = 0.4;
        this.rampSpeed = 0.0;
        this.oneQuarterAngle = 0.0;
        this.threeQuarterAngle = 0.0;
        this.currentProgress = 0.0;
        this.beforeAngle = 0.0;
    }

    @Override
    protected void initialize() {}

    @Override
    protected void execute() {
        if (this.startLoop) {
            this.turnAngle = this.inputAngle*.66 + Robot.driveTrainSubsystem.getGyroValue();
            this.rampSpeed = 0.0;
            this.startLoop = false;
        }

        this.rampSpeed -= 0.05;
        this.rampSpeed = max(this.rampSpeed, this.speed);
        Robot.driveTrainSubsystem.tankDrive(this.rampSpeed, -2 * this.rampSpeed);
    }

    @Override
    protected boolean isFinished() { return (Robot.driveTrainSubsystem.getGyroValue() >= this.turnAngle); }

    @Override
    protected void end() {
        Robot.driveTrainSubsystem.stopRobot();
        this.startLoop = true;
    }

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}

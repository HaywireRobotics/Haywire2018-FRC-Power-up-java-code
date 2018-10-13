package frc.team1569.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.team1569.Robot;


public class DriveForward extends Command {

    private Timer time;
    private double speed;
    private double seconds;
    private boolean negative;

    public DriveForward(double seconds, double speed) {
        requires(Robot.driveTrainSubsystem);
        this.time = new Timer();
        this.seconds = seconds;
        this.speed = speed;
        if (seconds < 0 )
            this.negative = false;
        else
            this.negative = true;
    }

    @Override
    protected void initialize() {
        this.time.reset();
        this.time.start();
        Robot.driveTrainSubsystem.setDrivingBackward(false);
    }

    @Override
    protected void execute() {
        if(this.seconds < 0)
            Robot.driveTrainSubsystem.driveForward(speed);
    	else
            Robot.driveTrainSubsystem.driveForward(-speed);
    }

    @Override
    protected boolean isFinished() {
        if (this.seconds < 0) {
            Robot.driveTrainSubsystem.setDrivingBackward(true);
            return this.time.hasPeriodPassed(-seconds);
        }
        else {
            Robot.driveTrainSubsystem.setDrivingBackward(false);
            return this.time.hasPeriodPassed(seconds);
        }
    }

    @Override
    protected void end() {
        if (this.seconds < 0)
            Robot.driveTrainSubsystem.setDrivingBackward(true);

        Robot.driveTrainSubsystem.stopRobot();
    }

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}

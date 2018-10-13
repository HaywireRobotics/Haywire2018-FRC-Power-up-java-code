package frc.team1569.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team1569.Robot;


public class HoldLift extends Command {

    public HoldLift() {
        requires(Robot.liftSubsystem);
    }

    @Override
    protected void initialize() {}

    @Override
    protected void execute() { Robot.liftSubsystem.liftUp(0.3); }

    @Override
    protected boolean isFinished() { return Robot.driveTrainSubsystem.isDrivingBackward(); }

    @Override
    protected void end() { Robot.liftSubsystem.liftUp(-0.2); }

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}

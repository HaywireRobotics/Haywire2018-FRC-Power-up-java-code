package frc.team1569.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team1569.Robot;


public class LiftToSwitch extends Command {

    public LiftToSwitch() {
        requires(Robot.liftSubsystem);
    }

    @Override
    protected void initialize() {
        Robot.liftSubsystem.initCounter();
    }

    @Override
    protected void execute() {
        Robot.liftSubsystem.liftUp(0.7);
    }

    @Override
    protected boolean isFinished() { return Robot.liftSubsystem.hasSwitchActivated(); }

    @Override
    protected void end() {
        Robot.liftSubsystem.stopLift();
    }

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}

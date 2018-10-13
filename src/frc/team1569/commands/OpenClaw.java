package frc.team1569.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team1569.Robot;


public class OpenClaw extends Command {
    public OpenClaw() { requires(Robot.clawSubsystem); }

    @Override
    protected void initialize() {}

    @Override
    protected void execute() { Robot.clawSubsystem.setClawOpen(); }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {}

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}

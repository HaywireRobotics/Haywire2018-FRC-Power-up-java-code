package frc.team1569.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class LiftToSwitchAndHold extends CommandGroup {

    public LiftToSwitchAndHold() {
        addSequential(new LiftToSwitch());
        addSequential(new HoldLift());
    }
}

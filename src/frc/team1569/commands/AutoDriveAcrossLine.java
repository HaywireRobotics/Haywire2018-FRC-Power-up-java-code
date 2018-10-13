package frc.team1569.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class AutoDriveAcrossLine extends CommandGroup {

    public AutoDriveAcrossLine() {
        addSequential(new DriveForward(7.0, 0.5));
    }
}

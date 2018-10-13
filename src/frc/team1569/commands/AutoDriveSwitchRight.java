package frc.team1569.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team1569.Robot;


public class AutoDriveSwitchRight extends CommandGroup {

    public AutoDriveSwitchRight() {
        if(Robot.gameData.charAt(0) == 'R') {
            addParallel(new LiftToSwitchAndHold());
            addSequential(new DriveForward(2.3, 0.7));
            addSequential(new DriveLeftTurn(-75.0));
            addSequential(new DriveForward(0.3, 0.5));
            addSequential(new OpenClaw());
            addSequential(new DriveForward(-1.5, 0.4));
        }
        else if (Robot.gameData.charAt(1) == 'R') {
            addSequential(new DriveForward(3.1, 0.8));
            addSequential(new DriveLeftTurn(-77.0));
            addSequential(new DriveForward(-2.3, 0.5));
        }
        else if (Robot.gameData.charAt(1) == 'L') {
            addSequential(new DriveForward(5.0, 0.5));
        }
    }
}

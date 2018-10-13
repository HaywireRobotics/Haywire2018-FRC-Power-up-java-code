package frc.team1569.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team1569.Robot;


public class AutoDriveSwitchLeft extends CommandGroup {

    public AutoDriveSwitchLeft() {
        if (Robot.gameData.charAt(0) == 'L') {
            addParallel(new LiftToSwitchAndHold());
            addSequential(new DriveForward(2.3, 0.7));
            addSequential(new DriveRightTurn(90.0));
            addSequential(new OpenClaw());
            addSequential(new DriveForward(-1.5, 0.4));
        }
        else if (Robot.gameData.charAt(1) == 'L') {
            addSequential(new DriveForward(3.2, 0.8));
            addSequential(new DriveRightTurn(77.0));
            addSequential(new DriveForward(-1.6, 0.5));
        }
        else {
            addSequential(new DriveForward(2.5, 0.8));
            addSequential(new DriveRightTurn(74.0));
            addSequential(new DriveForward(2.25, 0.8));
            addSequential(new DriveLeftTurn(-87.0));
        }
    }
}
package frc.team1569.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team1569.Robot;


public class AutoDriveSwitchCenter extends CommandGroup {

    public AutoDriveSwitchCenter() {
        if (Robot.gameData.charAt(0) == 'L') {
            addSequential(new DriveForward(1.0, 0.5));
            addSequential(new DriveLeftTurn(-32.5));

            addParallel(new LiftToSwitchAndHold());
            addSequential(new DriveForward(3.5, 0.5));
            addSequential(new DriveRightTurn(32.5));

            addSequential(new DriveForward(0.5, 0.5));
            addSequential(new OpenClaw());
            addSequential(new DriveForward(-1.0, 0.5));
        }
        else if (Robot.gameData.charAt(0) == 'R') {
            addSequential(new DriveForward(0.8, 0.5));
            addSequential(new DriveRightTurn(40));

            addParallel(new LiftToSwitchAndHold());
            addSequential(new DriveForward(2.0, 0.5));
            addSequential(new DriveLeftTurn(-31.5));

            addSequential(new DriveForward(2.0, 0.5));
            addSequential(new OpenClaw());
            addSequential(new DriveForward(-1.0, 0.5));
        }
    }
}

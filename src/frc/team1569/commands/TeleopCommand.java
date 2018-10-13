package frc.team1569.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team1569.Robot;
import frc.team1569.RobotMap;


public class TeleopCommand extends Command {
    public TeleopCommand() {
        requires(Robot.driveTrainSubsystem);
        requires(Robot.liftSubsystem);
        requires(Robot.climbSubsystem);
    }

    @Override
    protected void initialize() {}

    @Override
    protected void execute() {

        //Tank drive
        Robot.driveTrainSubsystem.takeJoystickInputs(Robot.oi.getLeftJoystick(), Robot.oi.getRightJoystick());

        if (!Robot.liftSubsystem.movingToPosition)
            Robot.liftSubsystem.setLift(Robot.oi.getManipulator2Joystick().getY());

        //Claw open/close buttons
        if (Robot.oi.getManipulator1Joystick().getRawButton(RobotMap.JMExtendPistonNum)) {
            Robot.clawSubsystem.setClawOpen();
        }
        else if (Robot.oi.getManipulator1Joystick().getRawButton(RobotMap.JMRetractPistonNum)) {
            Robot.clawSubsystem.setClawClose();
        }

        //Tape control
        if (Robot.oi.getManipulator1Joystick().getRawButton(RobotMap.JMTapeOut)) {
            Robot.climbSubsystem.setTapeSpeed(0.55);
        }
        else if (Robot.oi.getManipulator1Joystick().getRawButton(RobotMap.JMTapeIn)) {
            Robot.climbSubsystem.setTapeSpeed(-0.55);
        }
        else {
            Robot.climbSubsystem.setTapeSpeed(0.0);
        }

        //Winch control
        if (Robot.oi.getManipulator1Joystick().getRawButton(RobotMap.JMWinchIn)) {
            Robot.climbSubsystem.setWinchSpeed(1.0);
        }
        else if (Robot.oi.getManipulator1Joystick().getRawButton(RobotMap.JMWinchOut)) {
            Robot.climbSubsystem.setWinchSpeed(-1.0);
        }
        else {
            Robot.climbSubsystem.setWinchSpeed(0.0);
        }

        //Claw rotation control
        if (!Robot.liftSubsystem.movingToPosition)
            Robot.clawSubsystem.setRotateClaw(Robot.oi.getManipulator1Joystick().getY());
    }

    @Override
    protected boolean isFinished() { return false; }

    @Override
    protected void end() { Robot.driveTrainSubsystem.stopRobot(); }

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}

package frc.team1569.subsystems;


import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1569.RobotMap;

public class ClimbSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private Spark tapeMotor = new Spark(RobotMap.climbTapePort);
    private Spark winchMotor = new Spark(RobotMap.climbWinchPort);

    public ClimbSubsystem() {}

    public void initDefaultCommand() {}

    public void setTapeSpeed(double speed) {
        this.tapeMotor.set(speed);
    }

    public void setWinchSpeed(double speed) {
        this.winchMotor.set(speed);
    }
}


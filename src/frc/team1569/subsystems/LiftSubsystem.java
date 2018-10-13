package frc.team1569.subsystems;


import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1569.RobotMap;

public class LiftSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private Spark liftMotor0 = new Spark(RobotMap.liftPort0);
    private Spark liftMotor1 = new Spark(RobotMap.liftPort1);

    private DigitalInput reedSwitch = new DigitalInput(RobotMap.magSwitchPort);

    private Counter counter = new Counter(reedSwitch);

    public boolean movingToPosition = false;

    public LiftSubsystem() {}

    public void initDefaultCommand() {
        // TODO: Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
    }

    public void liftUp(double speed) {
        this.setLiftSpeed(speed);
    }

    public void liftDown(double speed) {
        this.setLiftSpeed(-speed);
    }

    public void stopLift() {
        this.setLiftSpeed(0.0);
    }

    public void setLift(double speed) {
        this.setLiftSpeed(speed);
    }

    private void setLiftSpeed(double speed) {
        this.liftMotor0.set(speed);
        this.liftMotor1.set(speed);
    }

    public void initCounter() {
        this.counter.reset();
    }

    public boolean hasSwitchActivated() {
        return (this.counter.get() > 0);
    }
}
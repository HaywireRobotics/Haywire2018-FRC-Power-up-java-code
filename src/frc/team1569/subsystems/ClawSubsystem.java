package frc.team1569.subsystems;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1569.RobotMap;

public class ClawSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private VictorSP claw = new VictorSP(RobotMap.clawPort);
    private DoubleSolenoid clawSolenoid = new DoubleSolenoid(RobotMap.solenoid1OpenPort, RobotMap.solenoid1ClosePort);

    public ClawSubsystem() {}

    public void initDefaultCommand() {/* SetDefaultCommand(new Command());*/}

    public void setRotateClaw(double speed) {
        this.claw.set(speed);
    }

    public void setClawOpen() {
        this.clawSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void setClawClose() {
        this.clawSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    public void setClawSolenoidStop() {
        this.clawSolenoid.set(DoubleSolenoid.Value.kOff);
    }

}
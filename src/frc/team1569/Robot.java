/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team1569;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team1569.commands.*;
import frc.team1569.subsystems.*;

// If you rename or move this class, update the build.properties file in the project root
public class Robot extends TimedRobot 
{

    public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
    public static final DriveTrainSubsystem driveTrainSubsystem = new DriveTrainSubsystem();
    public static final LiftSubsystem liftSubsystem = new LiftSubsystem();
    public static final ClimbSubsystem climbSubsystem = new ClimbSubsystem();
    public static final ClawSubsystem clawSubsystem = new ClawSubsystem();
    public static String gameData;
    public static OI oi;

    private Command autonomousCommand;
    private SendableChooser<Command> autoChooser = new SendableChooser<>();

    @Override
    public void robotInit() {
        oi = new OI();
        autoChooser.addDefault("Default Auto", new AutoDriveAcrossLine());
        autoChooser.addObject("DriveAcrossLine", new AutoDriveAcrossLine());
        autoChooser.addObject("DriveSwitchLeft", new AutoDriveSwitchLeft());
        autoChooser.addObject("DriveSwitchRight", new AutoDriveSwitchRight());
        autoChooser.addObject("DriveSwitchCenter", new AutoDriveSwitchCenter());
        autoChooser.addObject("DriveScaleRight", new AutoDriveScaleRight());
        autoChooser.addObject("DriveScaleLeft", new AutoDriveScaleLeft());
        SmartDashboard.putData("Auto mode", autoChooser);
    }

    @Override
    public void disabledInit() {}

    @Override
    public void disabledPeriodic() { Scheduler.getInstance().run(); }

    @Override
    public void autonomousInit() 
    {
        autonomousCommand = autoChooser.getSelected();

        Robot.gameData = DriverStation.getInstance().getGameSpecificMessage();

        if (autonomousCommand != null) 
        {
            autonomousCommand.start();
        }
    }

    @Override
    public void autonomousPeriodic() { Scheduler.getInstance().run(); }

    @Override
    public void teleopInit() 
    {
        if (autonomousCommand != null) 
        {
            autonomousCommand.cancel();
        }

        Command teleopCommand = new TeleopCommand();
        teleopCommand.start();

    }

    @Override
    public void teleopPeriodic() { Scheduler.getInstance().run(); }

    @Override
    public void testPeriodic() {}
}

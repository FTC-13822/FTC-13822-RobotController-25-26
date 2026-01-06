package org.firstinspires.ftc.nocamerablueauton;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.nocamerablueauton.ForwardMove;

@Autonomous
public class BlueAutonNoCam extends LinearOpMode {
    DcMotor brm = hardwareMap.get(DcMotor.class, "BRM");
    DcMotor blm = hardwareMap.get(DcMotor.class, "BLM");
    DcMotor frm = hardwareMap.get(DcMotor.class, "FRM");
    DcMotor flm = hardwareMap.get(DcMotor.class, "FLM");
    DcMotor turretMotor = hardwareMap.get(DcMotor.class, "turretShooter");



    @Override
    public void runOpMode() throws InterruptedException {
        ForwardMove forwardMove = new ForwardMove();
        RightTurn rightTurn = new RightTurn();
        LeftTurn leftTurn = new LeftTurn();
        TurretShooter turretShooter = new TurretShooter();
        Intake intake = new Intake();
        forwardMove.init();

        waitForStart();
        intake.init();
        intake.loop();
        forwardMove.encoderDrive(0.5, 2, 5); //distance in inches, timeout in seconds (tells how long the movement for)
        rightTurn.init();
        rightTurn.rightTurnDrive(0.3, 2, 5); //
        leftTurn.init();
        leftTurn.leftTurnDrive(0.3, 2, 5);
        turretShooter.init();
        turretShooter.shoot(10000);



        stop();
        terminateOpModeNow();
    }
}

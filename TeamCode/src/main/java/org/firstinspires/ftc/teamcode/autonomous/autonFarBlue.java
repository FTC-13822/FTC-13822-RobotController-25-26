package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
@Autonomous
public class autonFarBlue extends OpMode {
    boolean end = false;
    Back back;
    Forward forward;
    left moveLeft;
    right moveRight;
    Shooting shot;
    Intake intake;
    DcMotor BRM;
    DcMotor FRM;
    DcMotor BLM;
    DcMotor FLM;
    //initialize both motors
    DcMotor ShooterPrecision;
    DcMotor ShooterPower;
    private CRServo Servo1;
    private CRServo Servo3;
    ElapsedTime runtime = new ElapsedTime();
    public void init(){
        forward = new Forward(hardwareMap);
        moveLeft = new left(hardwareMap);
        moveRight = new  right(hardwareMap);
        shot = new Shooting(hardwareMap);
        intake = new Intake(hardwareMap);
        back = new Back(hardwareMap);
    }
    public void loop() {
        if (end == false) {
            forward.moveF(2500);
            moveLeft.turnLeft(65);
            shot.outtake(3);
        }
    }
}



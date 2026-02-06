package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp
public class testMove extends OpMode {
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

    @Override
    public void init(){
         forward = new Forward(hardwareMap);
         moveLeft = new left(hardwareMap);
         moveRight = new  right(hardwareMap);
         //shot = new Shooting(hardwareMap);
         //intake = new Intake(hardwareMap);
         back = new Back(hardwareMap);
    }

    @Override
    public void loop(){
        if(end == false) {
            forward.moveF(10000);
            back.moveB(10000);
            moveLeft.turnLeft(3600);
            moveRight.turnRight(3600);
            //intake.takein(10);
            //shot.outtake(3);
        }
        end = true;
    }
}

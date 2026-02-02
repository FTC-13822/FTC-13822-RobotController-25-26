package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class testMove extends OpMode {
    boolean end = false;
    Forward forward;
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
    }

    @Override
    public void loop(){
        if(end == false) {
            forward.moveF(1000);
        }
        end = true;
    }
}

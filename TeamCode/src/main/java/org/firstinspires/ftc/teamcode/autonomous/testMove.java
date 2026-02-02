package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class testMove extends OpMode {
    Forward forward = new Forward();
    private DcMotor BRM;
    private DcMotor FRM;
    private DcMotor BLM;
    private DcMotor FLM;
    private DcMotor ShooterPrecision;
    private DcMotor ShooterPower;
    private CRServo Servo1;
    private CRServo Servo3;

    @Override
    public void init(){
        Servo1 = hardwareMap.get(CRServo.class, ("Servo1"));
        Servo3 = hardwareMap.get(CRServo.class, ("Servo3"));

        BRM = hardwareMap.get(DcMotor.class, ("BRM"));
        FRM = hardwareMap.get(DcMotor.class, ("FRM"));
        BLM = hardwareMap.get(DcMotor.class, ("BLM"));
        FLM = hardwareMap.get(DcMotor.class, ("FLM"));
        //initialize both motors
        ShooterPrecision = hardwareMap.get(DcMotor.class, ("Shooter1"));
        ShooterPower = hardwareMap.get(DcMotor.class, ("Shooter2"));
    }

    @Override
    public void loop(){
        forward.moveF(300);
    }
}

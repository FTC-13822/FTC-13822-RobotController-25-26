package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
@Autonomous
public class auton extends OpMode {

    DcMotor BRM;
    DcMotor FRM;
    DcMotor BLM;
    DcMotor FLM;

    DcMotor Shooter;
    DcMotor ShooterPower;

    @Override
    public void init(){
        BRM = hardwareMap.get(DcMotor.class, ("BRM"));
        FRM = hardwareMap.get(DcMotor.class, ("FRM"));
        BLM = hardwareMap.get(DcMotor.class, ("BLM"));
        FLM = hardwareMap.get(DcMotor.class, ("FLM"));
        Shooter = hardwareMap.get(DcMotor.class, ("Shooter"));
    }
    public void loop(){
    }
}

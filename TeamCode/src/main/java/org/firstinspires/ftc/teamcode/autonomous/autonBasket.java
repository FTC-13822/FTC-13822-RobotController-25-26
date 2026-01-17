package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class autonBasket extends OpMode {
    //go forward 2ft - under basket
    DcMotor BRM;
    DcMotor FRM;
    DcMotor BLM;
    DcMotor FLM;
    DcMotor ShooterPrecision;
    DcMotor ShooterPower;
    moveForward straight = new moveForward();
    public void init(){

        BRM = hardwareMap.get(DcMotor.class, ("BRM"));
        FRM = hardwareMap.get(DcMotor.class, ("FRM"));
        BLM = hardwareMap.get(DcMotor.class, ("BLM"));
        FLM = hardwareMap.get(DcMotor.class, ("FLM"));
        //initialize both motors
        ShooterPrecision = hardwareMap.get(DcMotor.class, ("Shooter1"));
        ShooterPower = hardwareMap.get(DcMotor.class, ("Shooter2"));
    }
    public void loop(){
        straight.forward(.5,1.5);
        requestOpModeStop();
    }
}

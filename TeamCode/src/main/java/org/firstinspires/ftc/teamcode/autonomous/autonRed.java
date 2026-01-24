package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
@Autonomous
public class autonRed extends OpMode {
    //left back 1 front -1
    //out ~2ft then strafe left - red
    DcMotor BRM;
    DcMotor FRM;
    DcMotor BLM;
    DcMotor FLM;
    DcMotor ShooterPrecision;
    DcMotor ShooterPower;
    Forward moveF;
    ElapsedTime runtime = new ElapsedTime();
    public void init(){

        BRM = hardwareMap.get(DcMotor.class, ("BRM"));
        FRM = hardwareMap.get(DcMotor.class, ("FRM"));
        BLM = hardwareMap.get(DcMotor.class, ("BLM"));
        FLM = hardwareMap.get(DcMotor.class, ("FLM"));
        //initialize both motors
        moveF = new Forward();
    }
    public void loop(){
        moveF.moveF(305);
    }
}

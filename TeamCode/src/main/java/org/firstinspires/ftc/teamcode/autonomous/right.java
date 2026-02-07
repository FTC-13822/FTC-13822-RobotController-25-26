package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class right extends OpMode {
    public DcMotor BLM;
    public DcMotor FRM;
    public DcMotor FLM;
    public DcMotor BRM;
    public DcMotor ShooterPrecision;
    public DcMotor ShooterPower;
    public right(HardwareMap hardwareMap) {
        BRM = hardwareMap.get(DcMotor.class, ("BRM"));
        FRM = hardwareMap.get(DcMotor.class, ("FRM"));
        BLM = hardwareMap.get(DcMotor.class, ("BLM"));
        FLM = hardwareMap.get(DcMotor.class, ("FLM"));
        //initialize both motors
        //ShooterPrecision = hardwareMap.get(DcMotor.class, ("Shooter1"));
        //ShooterPower = hardwareMap.get(DcMotor.class, ("Shooter2"));
    }
    @Override
    public void init(){
        BLM.setDirection(DcMotor.Direction.REVERSE);
        FLM.setDirection(DcMotor.Direction.REVERSE);
        BRM.setDirection(DcMotor.Direction.FORWARD);
        FRM.setDirection(DcMotor.Direction.FORWARD);
    }
    @Override
    public void loop(){
    }
    public void turnRight(int degrees){
        double CPR = 384.5;
        BRM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);//This already sets the encoders to zero
        BLM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FRM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FLM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        BRM.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BLM.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FRM.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FLM.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        int newBlmTarget = BLM.getCurrentPosition() + (int) (degrees * 385.4);//these tprs are wrong
        BLM.setTargetPosition(newBlmTarget);
        int newFrmTarget = FRM.getCurrentPosition() + (int) (degrees * -385.4);
        FRM.setTargetPosition(newFrmTarget);
        int newFlmTarget = FLM.getCurrentPosition() + (int) (degrees * 385.4);
        FLM.setTargetPosition(newFlmTarget);
        int newBrmTarget = BRM.getCurrentPosition() + (int) (degrees * -385.4);
        BRM.setTargetPosition(newBrmTarget);

        BRM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BLM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FRM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FLM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
}

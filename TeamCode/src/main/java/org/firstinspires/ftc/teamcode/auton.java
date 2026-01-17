package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;
@Autonomous
public class auton extends OpMode {
    AprilTag aprilTag = new AprilTag();
    public DcMotor BRM;
    public DcMotor BLM;
    public DcMotor FRM;
    public DcMotor FLM;
    public double CPR = 384.5;
    @Override
    public void init() {
        BRM = hardwareMap.get(DcMotor.class, "BRM");
        BLM = hardwareMap.get(DcMotor.class, "BLM");
        FRM = hardwareMap.get(DcMotor.class, "FRM");
        FLM = hardwareMap.get(DcMotor.class, "FLM");
        BRM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // Reset the motor encoder so that it reads zero ticks
        BLM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // Reset the motor encoder so that it reads zero ticks
        FRM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // Reset the motor encoder so that it reads zero ticks
        FLM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // Reset the motor encoder so that it reads zero ticks
        //motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // Turn the motor back on, required if you use STOP_AND_RESET_ENCODER
        BRM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FRM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BLM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FLM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //gets obelisk tag data? Pray ts works
        aprilTag.displayDetectionTelemetry(getObeliskTag.getTag());


        // Get the current position of the motor

/*
        if(getObeliskTag.obeliskTag.id == 21){
            //gpp
        }
        if(getObeliskTag.obeliskTag.id == 22){
            //pgp
        }
        if(getObeliskTag.obeliskTag.id == 23){
            //ppg
        }
*/

    }

@Override
    public void loop() {
    int position = BRM.getCurrentPosition();
    double revolutions = position/CPR;

    double angle = revolutions * 360;
    double angleNormalized = angle % 360;
    double circumference  = Math.PI*96;
    double distance  = circumference* revolutions;
        BLM.setTargetPosition(-(int)((609.6/circumference)*CPR));
        FLM.setTargetPosition(-(int)((609.6/circumference)*CPR));
        BRM.setTargetPosition((int)((609.6/circumference)*CPR));
        FRM.setTargetPosition((int)((609.6/circumference)*CPR));
        BLM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    FLM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    FRM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    BRM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    BLM.setPower(.5);
    BRM.setPower(.5);
    FLM.setPower(.5);
    FRM.setPower(.5);
    telemetry.addData("Encoder Position", position);
    telemetry.addData("CPR tested: ", CPR);
    telemetry.addData("Encoder Revolutions", revolutions);
    telemetry.addData("Encoder Angle (Degrees)", angle);
    telemetry.addData("Encoder Angle - Normalized (Degrees)", angleNormalized);
    telemetry.addData("Distance: ", distance);
    telemetry.addData("Target: " , (int)((609.6/circumference)*CPR));
    telemetry.update();
    }
}

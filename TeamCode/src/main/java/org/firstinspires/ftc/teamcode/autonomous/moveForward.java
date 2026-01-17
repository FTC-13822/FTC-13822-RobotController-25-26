package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

public class moveForward extends LinearOpMode {
    public DcMotor BRM;
    public DcMotor BLM;
    public DcMotor FRM;
    public DcMotor FLM;
    ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode(){
        BRM = hardwareMap.get(DcMotor.class, "BRM");
        BLM = hardwareMap.get(DcMotor.class, "BLM");
        FRM = hardwareMap.get(DcMotor.class, "FRM");
        FLM = hardwareMap.get(DcMotor.class, "FLM");
    }
    
        //out ~2ft then strafe left - red
        //out ~2ft then strafe right - blue

    public void forward(double power, double time){
        BRM.setPower(power);
        FRM.setPower(power);
        BLM.setPower(power);
        FLM.setPower(power);
        runtime.reset();

        while(opModeIsActive() && (runtime.seconds() < time)){
            telemetry.addData("Status", "Driving Forward");
            telemetry.addData("Elapsed Time", runtime.seconds());
            telemetry.update();
        }
        BRM.setPower(0);
        FRM.setPower(0);
        BLM.setPower(0);
        FLM.setPower(0);
    }
}

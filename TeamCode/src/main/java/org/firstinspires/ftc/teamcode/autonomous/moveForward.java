package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

public class moveForward extends LinearOpMode {
    public static DcMotor BRM;
    public static DcMotor BLM;
    public static DcMotor FRM;
    public static DcMotor FLM;
    static ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode(){
        BRM = hardwareMap.get(DcMotor.class, "BRM");
        BLM = hardwareMap.get(DcMotor.class, "BLM");
        FRM = hardwareMap.get(DcMotor.class, "FRM");
        FLM = hardwareMap.get(DcMotor.class, "FLM");
    }
    

        //out ~2ft then strafe right - blue

    public static void forward(double time){
        BRM.setPower(.25);
        FRM.setPower(.25);
        BLM.setPower(.25);
        FLM.setPower(.25);
        runtime.reset();
        double currentPower = .25;
        while(runtime.seconds() < time){
            /*
            telemetry.addData("Status", "Driving Forward");
            telemetry.addData("Elapsed Time", runtime.seconds());
            telemetry.update();
            */
            if(currentPower < .75){
                currentPower+=.05;
            }
            System.out.println("running");
        }
        BRM.setPower(0);
        FRM.setPower(0);
        BLM.setPower(0);
        FLM.setPower(0);
    }

}

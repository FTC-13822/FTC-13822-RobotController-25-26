package org.firstinspires.ftc.teamcode.autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;


public class Intake extends OpMode {

    public CRServo Servo1;
    public CRServo Servo2;
    public CRServo Servo3;
    public ElapsedTime runTime;

    public Intake(HardwareMap hardwareMap) {
        Servo1 = hardwareMap.get(CRServo.class,"Servo1");
        Servo2 = hardwareMap.get(CRServo.class,"Servo2");
        Servo3 = hardwareMap.get(CRServo.class,"Servo3");
        runTime = new ElapsedTime();
    }
    @Override
    public void init(){
    }
    @Override
    public void loop(){

    }
    public void takein(int time) {
        runTime.reset();
        while(runTime.seconds()<time) {
            Servo1.setPower(1);
            Servo2.setPower(1);
            Servo3.setPower(1);
        }
        Servo1.setPower(0);
        Servo2.setPower(0);
        Servo3.setPower(0);
    }
}
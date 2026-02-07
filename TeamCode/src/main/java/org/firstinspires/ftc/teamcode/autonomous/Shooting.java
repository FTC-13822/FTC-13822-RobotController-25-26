package org.firstinspires.ftc.teamcode.autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;


public class Shooting extends OpMode {

    public DcMotor ShooterPrecision;
    public DcMotor ShooterPower;
    public ElapsedTime runTime;
    Intake intake;
    public CRServo Servo1;
    public CRServo Servo2;
    public CRServo Servo3;

    public Shooting(HardwareMap hardwareMap) {

        ShooterPrecision = hardwareMap.get(DcMotor.class, ("Shooter1"));
        ShooterPower = hardwareMap.get(DcMotor.class, ("Shooter2"));
        Servo1 = hardwareMap.get(CRServo.class,"Servo1");
        Servo2 = hardwareMap.get(CRServo.class,"Servo2");
        Servo3 = hardwareMap.get(CRServo.class, "Servo3");
        runTime = new ElapsedTime();
        intake = new Intake(hardwareMap);
    }
    @Override
    public void init(){
    }
    @Override
    public void loop(){

    }
    public void outtake(int time){
        runTime.reset();
        while (runTime.seconds()<time){
            Servo1.setPower(1);
            Servo2.setPower(1);
            Servo3.setPower(1);
            ShooterPower.setPower(1);
            ShooterPrecision.setPower(1);

        }
        ShooterPower.setPower(0);
        ShooterPrecision.setPower(0);
        Servo1.setPower(0);
        Servo2.setPower(0);
        Servo3.setPower(0);
    }
}

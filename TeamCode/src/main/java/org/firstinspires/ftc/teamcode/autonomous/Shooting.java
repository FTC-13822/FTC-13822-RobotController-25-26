package org.firstinspires.ftc.teamcode.autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;


public class Shooting extends OpMode {

    public DcMotor ShooterPrecision;
    public DcMotor ShooterPower;
    public ElapsedTime runTime;

    public Shooting(HardwareMap hardwareMap) {

        ShooterPrecision = hardwareMap.get(DcMotor.class, ("Shooter1"));
        ShooterPower = hardwareMap.get(DcMotor.class, ("Shooter2"));
        runTime = new ElapsedTime();
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
            ShooterPower.setPower(1);
            ShooterPrecision.setPower(1);
        }
        ShooterPower.setPower(0);
        ShooterPrecision.setPower(0);
    }
}

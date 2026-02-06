package org.firstinspires.ftc.teamcode.autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Forward extends OpMode {
    public DcMotor BLM;
    public DcMotor FRM;
    public DcMotor FLM;
    public DcMotor BRM;
    public DcMotor ShooterPrecision;
    public DcMotor ShooterPower;

    public Forward(HardwareMap hardwareMap) {
        BRM = hardwareMap.get(DcMotor.class, ("BRM"));
        FRM = hardwareMap.get(DcMotor.class, ("FRM"));
        BLM = hardwareMap.get(DcMotor.class, ("BLM"));
        FLM = hardwareMap.get(DcMotor.class, ("FLM"));
        //initialize both motors
    }
    @Override
    public void init(){
    }
    @Override
    public void loop(){

    }
    public void moveF(int distance){

        BRM.setTargetPosition(distance);
        FRM.setTargetPosition(distance);
        BLM.setTargetPosition(-distance);
        FLM.setTargetPosition(-distance);
        FRM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FRM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BRM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BRM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BLM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BLM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FLM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FLM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        double CPR  = 384.5;
        double diameter = 96;
        double circumference = Math.PI*diameter;
        double position = FRM.getCurrentPosition();
        double revolutions = position/CPR;
        double distanceMoved = revolutions *circumference;
        double power = FRM.getPower();
        //acceleration

        while (distanceMoved < distance-200) {
            if(power < .75) {
                power += 0.05;
            }
            FRM.setPower(power);
            FLM.setPower(-power);
            BRM.setPower(power);
            BLM.setPower(-power);

        }
        while (power > .25){
            power -= .05;
            FRM.setPower(power);
            FLM.setPower(-power);
            BRM.setPower(power);
            BLM.setPower(-power);
        }
        power = 0;
        FRM.setPower(power);
        FLM.setPower(-power);
        BRM.setPower(power);
        BLM.setPower(-power);
    }
}
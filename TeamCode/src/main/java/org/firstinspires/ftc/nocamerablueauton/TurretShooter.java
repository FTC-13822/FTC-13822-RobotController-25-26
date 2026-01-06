package org.firstinspires.ftc.nocamerablueauton;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

public class TurretShooter extends OpMode {

    DcMotor turretShooter1;
    DcMotor turretShooter2;

    ElapsedTime shootTime = new ElapsedTime();

    @Override
    public void init() {

        turretShooter1.setDirection(DcMotor.Direction.FORWARD);
        turretShooter2.setDirection(DcMotor.Direction.FORWARD);

    }


    @Override
    public void loop(){

    }


    public void shoot(int time) throws InterruptedException {//Time is in milliseconds



        turretShooter1.setPower(1);
        turretShooter2.setPower(1);

        wait(time);
        terminateOpModeNow();


    }
}

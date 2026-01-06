package org.firstinspires.ftc.nocamerablueauton;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Intake extends OpMode {

DcMotor intakeMotor;

    @Override
    public void init() {

        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");

    }

    @Override
    public void loop() {

        intakeMotor.setPower(1);

        telemetry.addLine("Intake Status: On");

    }
}

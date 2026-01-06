package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class testing extends OpMode {
    private DcMotor BRM;
    private DcMotor FRM;

    @Override
    public void init() {

        BRM = hardwareMap.get(DcMotor.class, ("BRM"));
        FRM = hardwareMap.get(DcMotor.class, ("FRM"));



    }
    @Override
    public void loop() {
        double bpower = gamepad1.left_stick_y;
        double fpower = gamepad1.right_stick_y;
        BRM.setPower(bpower);
        FRM.setPower(fpower);
        telemetry.addData("BRM", BRM.getPower());
        telemetry.addData("FRM", FRM.getPower());
    }
}


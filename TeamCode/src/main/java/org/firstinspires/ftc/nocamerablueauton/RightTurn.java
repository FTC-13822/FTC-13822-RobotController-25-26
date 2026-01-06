package org.firstinspires.ftc.nocamerablueauton;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;



public class RightTurn extends OpMode {
    ElapsedTime runTime = new ElapsedTime();
    DcMotor blm;
    DcMotor brm;
    DcMotor flm;
    DcMotor frm;

    static final double TICKS_PER_REV = 384;
    static final double TICKS_PER_TURN = TICKS_PER_REV / (4 * 3.1415);
    int newBlmTarget;
    int newBrmTarget;
    int newFlmTarget;
    int newFrmTarget;

    @Override
    public void init() {

        blm.setDirection(DcMotor.Direction.FORWARD);
        flm.setDirection(DcMotor.Direction.FORWARD);
        frm.setDirection(DcMotor.Direction.REVERSE);
        brm.setDirection(DcMotor.Direction.REVERSE);

        brm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        blm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        flm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        brm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        blm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry.addData("brmCurPos", brm.getCurrentPosition());
        telemetry.update();
        telemetry.addData("blmCurPos", blm.getCurrentPosition());
        telemetry.update();
        telemetry.addData("frmCurPos", frm.getCurrentPosition());
        telemetry.update();
        telemetry.addData("flmCurPos", flm.getCurrentPosition());
        telemetry.update();

    }

    @Override
    public void loop() {



    }

    public void rightTurnDrive (double speed, double degrees, double timeout) {

        newBlmTarget = blm.getCurrentPosition() + (int) (degrees * TICKS_PER_TURN);
        blm.setTargetPosition(newBlmTarget);
        newFrmTarget = frm.getCurrentPosition() + (int) (degrees * -TICKS_PER_TURN);
        frm.setTargetPosition(newBlmTarget);
        newFlmTarget = flm.getCurrentPosition() + (int) (degrees * TICKS_PER_TURN);
        flm.setTargetPosition(newFlmTarget);
        newBrmTarget = brm.getCurrentPosition() + (int) (degrees * -TICKS_PER_TURN);
        brm.setTargetPosition(newBrmTarget);

        brm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        blm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        flm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        runTime.reset();
        blm.setPower(Math.abs(speed));
        brm.setPower(Math.abs(speed));
        frm.setPower(0);
        flm.setPower(0);

        while ((runTime.seconds() < timeout) &&
                brm.isBusy()) {
            telemetry.addData("Going To", "%7d", newBrmTarget);
        }
        while ((runTime.seconds() < timeout) &&
                blm.isBusy()) {
            telemetry.addData("Going To", "%7d", newBlmTarget);
        }
        while ((runTime.seconds() < timeout) &&
                frm.isBusy()) {
            telemetry.addData("Going To", "%7d", newFrmTarget);
        }
        while ((runTime.seconds() < timeout) &&
                flm.isBusy()) {
            telemetry.addData("Going To", "%7d", newFlmTarget);
        }

    }

}

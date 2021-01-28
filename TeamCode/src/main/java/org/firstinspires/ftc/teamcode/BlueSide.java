package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;




import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;
@Autonomous(name = "Blue Goal")

public class BlueSide extends LinearOpMode {
    private DcMotor front_left = null;

    private DcMotor front_right = null;

    private DcMotor back_right =null;

    private DcMotor back_left = null;

    public void encoderForwardRun (int desiredCounts) {
        front_left.setTargetPosition(desiredCounts);
        front_right.setTargetPosition(desiredCounts);
        back_left.setTargetPosition(desiredCounts);
        back_right.setTargetPosition(desiredCounts);
    }

   public void runOpMode() {

       front_left = hardwareMap.get(DcMotor.class, "front_left");
       front_right = hardwareMap.get(DcMotor.class, "front_right");
       back_left = hardwareMap.get(DcMotor.class, "back_left");
       back_right = hardwareMap.get(DcMotor.class, "back_right");

       front_left.setDirection(DcMotor.Direction.REVERSE);
       back_left.setDirection(DcMotor.Direction.REVERSE);

       front_right.setDirection(DcMotor.Direction.FORWARD);
       back_right.setDirection(DcMotor.Direction.FORWARD);

       front_left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       back_left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

       front_right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       back_right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

       waitForStart();

       front_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

       front_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

       back_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

       back_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

       encoderForwardRun(5000);

       front_right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

       front_left.setMode(DcMotor.RunMode.RUN_TO_POSITION);

       back_right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

       back_left.setMode(DcMotor.RunMode.RUN_TO_POSITION);


   }
}
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="Short Box",group="")
public class Bluesideshort extends LinearOpMode {

    private DcMotor sh00ter_right;
    private DcMotor front_left;
    private DcMotor back_left;
    private DcMotor sh00ter_left;
    private DcMotor back_right;
    private DcMotor front_right;
    private DcMotor intakeSystem;
    private Servo knockDown;

    /**
     * This function is executed when this OpMode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        sh00ter_right = hardwareMap.get(DcMotor.class, "sh00ter_right");
        front_left = hardwareMap.get(DcMotor.class, "front_left");
        back_left = hardwareMap.get(DcMotor.class, "back_left");
        sh00ter_left = hardwareMap.get(DcMotor.class, "sh00ter_left");
        back_right = hardwareMap.get(DcMotor.class, "back_right");
        front_right = hardwareMap.get(DcMotor.class, "front_right");
        intakeSystem = hardwareMap.get(DcMotor.class, "intakeSystem");
        knockDown = hardwareMap.get(Servo.class, "knockDown");

//Put initialization blocks here.
        waitForStart();
        sh00ter_right.setDirection(DcMotorSimple.Direction.REVERSE);
        front_left.setDirection(DcMotorSimple.Direction.REVERSE);
        back_left.setDirection(DcMotorSimple.Direction.REVERSE);

        if (opModeIsActive()) {
//Put run blocks here.
//Knock down the intake
            knockDown.setPosition(0);
            sleep(1000);

            sleep(50);
//Drive to forward to drop off the the Wobble Goal
            front_right.setPower(1);
            front_left.setPower(1);
            back_left.setPower(1);
            back_right.setPower(1);
            sleep(1100);
//Stopping after driving forward
            back_left.setPower(0);
            back_right.setPower(0);
            front_right.setPower(0);
            front_left.setPower(0);
            sleep(1000);

            knockDown.setPosition(.75);
            sleep(300);
//Driving backwards behind the line

            front_right.setPower(-1);
            front_left.setPower(-1);
            back_left.setPower(-1);
            back_right.setPower(-1);
            sleep(170);
//Stopping after the line
            back_left.setPower(0);
            back_right.setPower(0);
            front_right.setPower(0);
            front_left.setPower(0);
            sleep(1000);
//turning left
            back_right.setPower(.25);
            front_right.setPower(.25);
            sleep(1000);
            back_right.setPower(0);
            front_right.setPower(0);

//Shooting the rings
            sh00ter_left.setPower(0.5);
            sh00ter_right.setPower(0.5);
            sleep(2000);
            intakeSystem.setPower(1);
            sleep(7000);
//turingofftheshooter
            sh00ter_left.setPower(0);
            sh00ter_right.setPower(0);
            intakeSystem.setPower(0);
            sleep(50);
//Drivingacrossthline
            front_right.setPower(1);
            front_left.setPower(1);
            back_left.setPower(1);
            back_right.setPower(1);
            sleep(150);
//Stoppingafterdrivingontheline
            front_right.setPower(0);
            front_left.setPower(0);
            back_left.setPower(0);
            back_right.setPower(0);
            sleep(29130);
        }
    }
}

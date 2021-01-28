
package org.firstinspires.ftc.teamcode;


import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;



public class Methods extends hardWareMap {

    private LinearOpMode opModeObj;

    public hardWareMap robot;

    public Methods(hardWareMap hardwaremap, LinearOpMode opMode) {

        robot = hardwaremap;

        opModeObj = opMode;


    }

    /*
        /* Mecanum Drive Method */
    public void Drive() {



        /* Uses trig to calculate which way the motors should be spinning */

        double r = Math.hypot(opModeObj.gamepad1.left_stick_x, opModeObj.gamepad1.left_stick_y);

        double robotAngle = Math.atan2(-opModeObj.gamepad1.left_stick_y, opModeObj.gamepad1.left_stick_x) - Math.PI / 4;

        double rightX = opModeObj.gamepad1.right_stick_x;

        double v1 = r * Math.cos(robotAngle) - rightX;

        double v2 = r * Math.sin(robotAngle) + rightX;

        double v3 = r * Math.sin(robotAngle) - rightX;

        double v4 = r * Math.cos(robotAngle) + rightX;

        /* Assigns a control to the mecanum drive */
        if (opModeObj.gamepad1.x) {

            v1 *= 2;

            v2 *= 2;

            v3 *= 2;

            v4 *= 2;

        }

        robot.front_left.setPower(v1 * 1);

        robot.front_right.setPower(v2 * 1);

        robot.back_left.setPower(v3 * 1);

        robot.back_right.setPower(v4 * 1);


    }

    /* Extra Option for Mecanum Drive */
    public void TimeDrive(double time, double lx, double ly, double rx) {

        double r = Math.hypot(lx, ly);

        double robotAngle = Math.atan2(-ly, lx) - Math.PI / 4;

        double rightX = rx;

        double v1 = r * Math.cos(robotAngle) - rightX;

        double v2 = r * Math.sin(robotAngle) + rightX;

        double v3 = r * Math.sin(robotAngle) - rightX;

        double v4 = r * Math.cos(robotAngle) + rightX;


        if (opModeObj.gamepad1.x) {

            v1 *= 2;

            v2 *= 2;

            v3 *= 2;

            v4 *= 2;

        }

        robot.front_left.setPower(v1 * 1);

        robot.front_right.setPower(v2 * 1);

        robot.back_left.setPower(v3 * 1);

        robot.back_right.setPower(v4 * 1);

        opModeObj.sleep((long) time * 1000);

        robot.front_right.setPower(0);
        robot.front_left.setPower(0);
        robot.back_left.setPower(0);
        robot.back_right.setPower(0);
    }
    public void setSh00ters (double power) {
        robot.sh00ter_right.setPower(power);
        robot.sh00ter_left.setPower(-power);
    }



    public void activInputSh00ters(double powerLimit) {
        double RightT = opModeObj.gamepad2.right_trigger;
        double Distance_Determine;

        if (powerLimit > 0) {
            if (RightT > powerLimit) {
                setSh00ters(powerLimit);
            } else {
                setSh00ters(RightT);
            }
        }


    }


}









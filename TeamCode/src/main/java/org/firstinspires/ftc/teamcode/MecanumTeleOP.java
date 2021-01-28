

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name="Mecanum Drive Ethan")
public class MecanumTeleOP extends LinearOpMode {

    hardWareMap robot = new hardWareMap();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        Methods drive = new Methods(robot, this);
        telemetry.addData("Robot", "Initialized");
        telemetry.update();


        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        robot.runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            drive.activInputSh00ters(0.5);
            drive.Drive();
            if (gamepad2.x) {
                robot.intakeSystem.setPower(-0.75);
                robot.Intake = "Running";
                robot.isIntakeRunning = true;
            } else if (gamepad2.a) {
                robot.intakeSystem.setPower(-3);
                robot.Intake = "Running Fast";
            } else {
                robot.intakeSystem.setPower(0);
                robot.Intake = "Not Running";
            }
            if (gamepad2.y) {
                robot.intakeSystem.setPower(1);
                robot.isIntakeRunning = true;
            }
            telemetry.addData("Actual shooter speed", "(%.02f)", robot.sh00ter_left.getCurrentPosition() );

            telemetry.addData("CSP", "(%.2f)", robot.sh00ter_right.getPower());

            telemetry.addData("Wheel Power", "front left (%.2f), front right (%.2f), " +

                            "back left (%.2f), back right (%.2f)", robot.front_left.getPower(), robot.front_right.getPower(),

                    robot.back_left.getPower(), robot.back_right.getPower());

            telemetry.update();

        }
    }
}


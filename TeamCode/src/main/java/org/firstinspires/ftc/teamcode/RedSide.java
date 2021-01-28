package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;




import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;
@Autonomous(name = "Red Side Goal")

public class RedSide extends LinearOpMode {

    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontLeftDrive = null;

    private DcMotor frontRightDrive = null;

    private DcMotor backLeftDrive = null;

    private DcMotor backRightDrive = null;

    private DcMotor arm_one = null;

    private DcMotor arm_two = null;

    private ColorSensor sensorColor;


    @Override
    public void runOpMode() {
        arm_one = hardwareMap.get(DcMotor.class, "arm_one");
        arm_two = hardwareMap.get(DcMotor.class, "arm_two");
        frontLeftDrive = hardwareMap.get(DcMotor.class, "fleft");
        frontRightDrive = hardwareMap.get(DcMotor.class, "fright");
        backLeftDrive = hardwareMap.get(DcMotor.class, "bleft");
        backRightDrive = hardwareMap.get(DcMotor.class, "bright");
        sensorColor = hardwareMap.get(ColorSensor.class, "sensor_color_distance");

        frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        backLeftDrive.setDirection(DcMotor.Direction.REVERSE);

        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();


        // turn the light on for objects, tur if off if sensing color of lit up objects
        frontLeftDrive.setPower(.3);
        frontRightDrive.setPower(.3);
        backLeftDrive.setPower(.3);
        backRightDrive.setPower(.3);

        while ((sensorColor.red() < 35) && opModeIsActive()) {
            telemetry.addData("Red  ", sensorColor.red());
            telemetry.addData("Green", sensorColor.green());
            telemetry.addData("Blue ", sensorColor.blue());
            telemetry.update();
        }
        frontLeftDrive.setPower(0);
        frontRightDrive.setPower(0);
        backLeftDrive.setPower(0);
        backRightDrive.setPower(0);

        //telemetry.addData("Path", "Computer");
        frontLeftDrive.setPower(-.1);
        frontRightDrive.setPower(-.1);
        backLeftDrive.setPower(-.1);
        backRightDrive.setPower(-.1);
        frontRightDrive.setPower(0);
        backLeftDrive.setPower(0);
        backRightDrive.setPower(0);
        frontLeftDrive.setPower(0);

        while ((sensorColor.red() > 35) && opModeIsActive()) {
            frontLeftDrive.setPower(-.1);
            frontRightDrive.setPower(-.1);
            backLeftDrive.setPower(-.1);
            backRightDrive.setPower(-.1);
        }
    }

}

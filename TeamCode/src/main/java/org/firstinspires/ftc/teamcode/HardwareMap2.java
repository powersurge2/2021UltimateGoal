
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

 class hardWareMap {

     HardwareMap hwMap = null;

    ElapsedTime runtime = new ElapsedTime();

    public String shooter = "Not Running";

    public String Intake = "Not Running";

    public boolean isIntakeRunning = false;  /*The Boolean's not used, but it's there if you need it*/

    public DcMotor front_left = null;

    public DcMotor front_right = null;

    public DcMotor back_left = null;

    public DcMotor back_right = null;

     public DcMotor  intakeSystem = null;

    public DcMotor sh00ter_left = null;

    public DcMotor sh00ter_right = null;

    boolean shooterStatus = false;  /*The Boolean's not used, but it's there if you need it*/

     /* Constructor */

    public hardWareMap(){

    }



    public void init(HardwareMap ahwMap) {

        hwMap = ahwMap;

        front_left = hwMap.get(DcMotor.class, "front_left");

        front_right = hwMap.get(DcMotor.class, "front_right");

        back_left = hwMap.get(DcMotor.class, "back_left");

        back_right = hwMap.get(DcMotor.class, "back_right");

        intakeSystem = hwMap.get(DcMotor.class, "intakeSystem");

        sh00ter_left = hwMap.get(DcMotor.class, "sh00ter_left");

        sh00ter_right = hwMap.get(DcMotor.class, "sh00ter_right");

         intakeSystem.setDirection(DcMotor.Direction.REVERSE);

        back_right.setDirection(DcMotor.Direction.FORWARD);

        back_left.setDirection(DcMotor.Direction.REVERSE);

        front_right.setDirection(DcMotor.Direction.FORWARD);

        front_left.setDirection(DcMotor.Direction.REVERSE);

        sh00ter_right.setDirection(DcMotor.Direction.REVERSE);

        sh00ter_left.setDirection(DcMotor.Direction.REVERSE);


        front_left.setPower(0);

        front_right.setPower(0);

        back_left.setPower(0);

        back_right.setPower(0);

        sh00ter_right.setPower(0);

        sh00ter_left.setPower(0);

        intakeSystem.setPower(0);


    }
}

package swerve;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

/**
 * Proof of concept for Swerve drive for FIRST ROBOTICS Competition
 * Modified for use in FRC. Code adapted from Ether.
 * @author Marty 
 */
public class SwerveBase extends IterativeRobot {

    private Joystick left, right;

    public void robotInit() {
        left = new Joystick(1);
        left = new Joystick(2);
    }

    public void autonomousPeriodic() {

    }

    public void teleopPeriodic() {
        calc();

        try {
            Thread.sleep(20);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void testPeriodic() {

    }


    //calculation doubles used
    public double m1, m2, m3, m4, a1, a2, a3, a4, x, y, z;

    public void calc() {
        //creates g1, g2, g3, g4 (group[i]) new MtrTester class object giving each one the wheel id
        MtrTester g1 = new MtrTester(1),
                g2 = new MtrTester(2),
                g3 = new MtrTester(3),
                g4 = new MtrTester(4);

        x = left.getX();
        y = left.getY();
        z = right.getTwist();

        //run genCalc method for each group[i]
        g1.genCalc(x, y, z);
        g2.genCalc(x, y, z);
        g3.genCalc(x, y, z);
        g4.genCalc(x, y, z);

        //run get calcspeed and calc angle mathods to get angle and speed (motor value)
        // for debugging
//        m1 = (Math.round(g1.calcSpeed()*1000))/10;
//        a1 = (Math.round(g1.calcAngl()*1000))/1000;
//        m2 = (Math.round(g2.calcSpeed()*1000))/10;
//        a2 = (Math.round(g2.calcAngl()*1000))/1000;
//        m3 = (Math.round(g3.calcSpeed()*1000))/10;
//        a3 = (Math.round(g3.calcAngl()*1000))/1000;
//        m4 = (Math.round(g4.calcSpeed()*1000))/10;
//        a4 = (Math.round(g4.calcAngl()*1000))/1000;
    }

}

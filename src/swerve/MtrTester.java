package swerve;



// @author Mkaa 00x

public class MtrTester {


    public MtrTester(int w) {
        id = w;
        //main method takes id and uses it for that g[i] (difference in calculations for each motor)
    }

    //id of motor ranges from 1-4, used for a 4 wheel swerve drive.
    private int id;
    //    l = length
    //    w = width
    //    Vx = Velocity of X, (-1 - 1)
    //    Vy = Velocity of Y, (-1 - 1)
    //    A,B,C,D = variables used for ease of calculation, no actual meaning, just a lack in messy code :P
    //    rotation (-1 == -360, - 1 == +360) *in degrees
    //    m1, m2, m3, m4, values of motors. m1 would be top left, 2, top right, 3, bot left, 4 bot right
    //    max values used to make sure that value does not over exceed 1.0 (max motor value)
    //    a1, a2, a3, a4, values of angles for each motor representative of their number.
    private double l = 10, w = 10, Vx, Vy, A, B, C, D, rotation, radius, m1, m2, m3, m4, max, max1, max2, a1, a2, a3, a4;
    //Sets A, B, C, D for each motor group
    public void genCalc(double rotationOfRob, double VofX, double VofY) {
        radius = Math.sqrt(Math.pow(l, 2) + Math.pow(w, 2));
        rotation = rotationOfRob;
        Vx = VofX;
        Vy = VofY;

        A = Vx - rotation * (l / radius);
        B = Vx + rotation * (l / radius);
        C = Vy - rotation * (w / radius);
        D = Vy + rotation * (w / radius);
    }
    //Sets m1-m4 speeds and ONLY returns the one that matches ID
    public double calcSpeed() {

        m1 = Math.sqrt(Math.pow(B, 2) + Math.pow(D, 2));
        m2 = Math.sqrt(Math.pow(B, 2) + Math.pow(C, 2));
        m3 = Math.sqrt(Math.pow(A, 2) + Math.pow(D, 2));
        m4 = Math.sqrt(Math.pow(A, 2) + Math.pow(C, 2));

        max1 = Math.max(m1, m2);
        max2 = Math.max(m3, m4);

        max = Math.max(max1, max2);

        if (Math.abs(max) > 1) {
            m1 /= max;
            m2 /= max;
            m3 /= max;
            m4 /= max;
        }

        if(id == 1)
            return m1;
        else if(id == 2)
            return m2;
        else if(id == 3)
            return m3;
        else
            return m4;

        //return 1;
    }
    //Sets a1-a4 angles and ONLY returns the one that matches ID
    public double calcAngl() {
        a1 = Math.atan2(B, D) * (180 / Math.PI);
        a2 = Math.atan2(B, C) * (180 / Math.PI);
        a3 = Math.atan2(A, D) * (180 / Math.PI);
        a4 = Math.atan2(A, C) * (180 / Math.PI);

        if(id == 1)
            return a1;
        else if(id == 2)
            return a2;
        else if(id == 3)
            return a3;
        else
            return a4;
    }
}
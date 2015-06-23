package mathoscore.arithmetic;

/**
 * This class provides you with tools for performing operations on doubles.
 *
 * @author Ethan Dagner (napen123@gmail.com), Mathos Project
 */
public class DoubleArithmetic {
    public static final double Epsilon = 4.94065645841247E-324;

    public static double Hypotenuse(double x, double y) {
        double absX = Math.abs(x);
        double absY = Math.abs(y);
        double min = Math.min(x, y);
        double max = Math.max(x, y);

        if(Math.abs(min) < 1)
            return max;
        if(Math.abs(min - max) < 1)
            return max * 2;

        double r = min / max;

        return max * Math.sqrt(1 + r * r);
    }

    public static double Hypotenuse(double x, double y, double z) {
        return Hypotenuse(Hypotenuse(x, y), z);
    }

    public static double HypotenuseSquared(double x, double y) {
        return (x * x) + (y * y);
    }

    public static double HypotenuseSquared(double x, double y, double z) {
        return (x * x) + (y * y) + (z * z);
    }

    public static double Pow(double x, int n) {
        double result = 1;

        if(n == 0)
            return result;

        if(n < 0) {
            n = -n;
            x = 1 / x;
        }

        do {
            if((n & 1) != 0)
                result *= x;

            n >>= 1;
            x *= x;
        } while(n > 0);

        return result;
    }

    public static double Pow2(double x) {
        return x * x;
    }

    public static double Pow3(double x) {
        return x * x * x;
    }

    public static double Pow4(double x) {
        return x * x * x * x;
    }

    public static double Pow5(double x) {
        return x * x * x * x * x;
    }

    public static double Pow6(double x) {
        return x * x * x * x * x * x;
    }

    public static double Pow7(double x) {
        return x * x * x * x * x * x * x;
    }

    public static double Pow8(double x) {
        return x * x * x * x * x * x * x * x;
    }

    public static double Pow9(double x) {
        return x * x * x * x * x * x * x * x * x;
    }
}

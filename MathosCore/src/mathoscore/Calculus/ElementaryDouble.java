package mathoscore.calculus;

import mathoscore.arithmetic.DoubleArithmetic;

public class ElementaryDouble {

    /**
     * Calculates log(1 + x)
     * @param x The value to use.
     * @return
     */
    public static double logOfOnePlusX(double x) {
        if(x <= -1.0)
            return Double.NaN;

        double z = Math.abs(x);
        double y = 1 + x;

        if(z > 0.75)
            return Math.log(y);
        if(z > 1e-4)
            return x * Math.log(y) / (y - 1.0);
        if(z > 1e-16)
            return (-0.5 * x + 1.0) * x;

        return x;
    }

    /**
     * Calculates EXP(X) - 1
     * @param x The value to use.
     * @return
     */
    public static double expOfXMinusOne(double x) {
        double z = Math.abs(x);

        if(z > 1e-5)
            return Math.exp(x) - 1.0;
        if(z > 1e-16)
            return x + 0.5 * x * x;

        return x;
    }

    /**
     * Calculates x * 2 ^ n
     * @param x The base value to use.
     * @param n The power to raise to.
     * @return
     */
    public static double timesTwoTo(double x, int n) {
        return x * DoubleArithmetic.Pow(2.0, n);
    }
}

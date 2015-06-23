package mathoscore.Arithmetic;

/**
 * This class provides you with tools for performing operations on integers.
 *
 * @author Ethan Dagner (napen123@gmail.com), Mathos Project
 */
public class IntegerArithmetic {

    /**
     * Find the square root of a number.
     * @param x The number to find the square root of.
     * @return The square root of "x".
     */
    public static int sqrt(int x) {
        int res = 0;
        int bit = 1 << 14;

        while(bit > x)
            bit >>= 2;

        while(bit != 0) {
            if(x >= res + bit) {
                x -= res + bit;
                res = (res >> 1) + bit;
            } else {
                res >>= 1;
            }

            bit >>= 2;
        }

        return res;
    }

    /**
     * Raise "x" to the power of "n".
     * @param x The base number.
     * @param n The power.
     * @return "x" raised to the power of "n".
     */
    public static int pow(int x, int n) {
        int result = 1;

        do {
            if((n & 1) != 0)
                result *= x;

            n >>= 1;
            x *= x;
        } while(n > 0);

        return result;
    }
}

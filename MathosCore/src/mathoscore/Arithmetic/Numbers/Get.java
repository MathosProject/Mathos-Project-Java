package mathoscore.arithmetic.Numbers;

public class Get {

    /**
     * Find the greatest common multiple of a and b.
     *
     * @param a First multiple
     * @param b Second multiple
     * @return Gets the greatest common multiple.
     */
    public static long gcm(long a, long b) {
        return b == 0 ? a : gcm(b, a % b);
    }
}

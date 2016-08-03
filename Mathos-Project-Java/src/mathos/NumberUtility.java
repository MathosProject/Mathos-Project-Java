package mathos;

/**
 * This class contains some utility methods to help with equations.
 *
 * @author Ethan Dagner (napen123@gmail.com), Mathos Project
 */
public class NumberUtility {

    /**
     * Find the greatest common multiple of two given numbers.
     *
     * @param a The first number to use.
     * @param b The second number to use.
     * @return Returns the greatest common multiple.
     */
    public static long gcm(long a, long b) {
        return b == 0 ? a : gcm(b, a % b);
    }
}

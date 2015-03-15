package mathoscore;

/**
 * A simple fraction type.
 *
 * @author Ethan Dagner
 */
public class Fraction {
    public long Numerator, Denominator;

    /**
     * Copy another fraction over to this one.
     * @param f Fraction to copy over.
     */
    public Fraction(Fraction f) {
        Numerator = f.Numerator;
        Denominator = f.Denominator;
    }

    /**
     * Create a fraction with the given numerator and denominator.
     *
     * @param num The numerator.
     * @param den The denominator.
     */
    public Fraction(long num, long den) {
        Numerator = num;
        Denominator = den;
    }

    /**
     * Convert the given double to a fraction.
     *
     * @param d Number to convert to fraction.
     */
    public Fraction(double d) {
        String s = String.valueOf(d);
        int digitsDec = s.length() - 1 - s.indexOf('.');
        int denom = 1;

        for(int i = 0; i < digitsDec; i++) {
            d *= 10;
            denom *= 10;
        }

        Fraction tmpFraction = simplify(Math.round(d), denom);

        Numerator = tmpFraction.Numerator;
        Denominator = tmpFraction.Denominator;
    }

    /**
     * NOTE: This doesn't really belong in Fraction; should be moved, had nowhere to put it.
     *
     * @param a First multiple
     * @param b Second multiple
     * @return Gets the greatest common multiple.
     */
    private long gcm(long a, long b) {
        return b == 0 ? a : gcm(b, a % b);
    }

    /**
     * Simplify the current fraction.
     * @return Returns a simplified version of the current fraction.
     */
    public Fraction simplify() {
        long gcm = gcm(Numerator, Denominator);

        return new Fraction(Numerator / gcm, Denominator / gcm);
    }

    /**
     * Simplify a fraction.
     * @param a Numerator
     * @param b Denominator
     * @return Returns the given fraction in simplified form.
     */
    public Fraction simplify(long a, long b) {
        long gcm = gcm(a, b);

        return new Fraction(a / gcm, b / gcm);
    }

    /**
     * Simplify a fraction.
     * @param f Fraction to simplify
     * @return Returns the given fraction in simplified form.
     */
    public Fraction simplify(Fraction f) {
        return simplify(f.Numerator, f.Denominator);
    }

    /**
     * Get decimal form.
     * @return Returns the fraction in decimal form.
     */
    public double toDecimal() {
        return Numerator / Denominator;
    }

    /**
     * toString override.
     * @return Returns the fraction in the standard fraction form (a/b)
     */
    @Override
    public String toString() {
        return Numerator + "/" + Denominator;
    }
}

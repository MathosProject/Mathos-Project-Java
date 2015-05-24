package Tests;

import mathoscore.Arithmetic.Fraction;
import org.junit.Test;

public class FractionTest {

    @Test
    public void simpleFractionTest() {
        Fraction f = new Fraction(4, 2);

        System.out.println(f.toDouble());
    }

    @Test
    public void decimalToFractionTest() {
        Fraction f = new Fraction(0.5);

        System.out.println(f);
    }

    @Test
    public void simplifyFractionTest() {
        Fraction f = new Fraction(500, 1000).simplify();

        System.out.println(f);
    }
}

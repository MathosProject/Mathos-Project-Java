package mathos.arithmetic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * A complex number type.
 *
 * @author Ethan Dagner (napen123@gmail.com), Mathos Project
 */
public class Complex {
    public double Real, Imaginary;

    public Complex(int real, int i) {
        Real = real;
        Imaginary = i;
    }

    public Complex(long real, double i) {
        Real = real;
        Imaginary = i;
    }

    public Complex(double real, double i) {
        Real = real;
        Imaginary = i;
    }

    public Complex(BigDecimal real, BigDecimal i) {
        this(real.doubleValue(), i.doubleValue());
    }

    public Complex(Fraction real, Fraction i) {
        Real = real.toDouble();
        Imaginary = i.toDouble();
    }

    public Complex(int real) {
        this(real, 0);
    }

    public Complex(long real) {
        this(real, 0);
    }

    public Complex(double real) {
        this(real, 0);
    }

    public Complex(BigDecimal real) {
        this(real.doubleValue());
    }

    public Complex(Fraction real) {
        this(real, new Fraction(0, 0));
    }

    public Complex(Complex c) {
        this(c.Real, c.Imaginary);
    }

    public Complex(String strComplex) {
        Real = 0;
        Imaginary = 0;

        int factor = 1;
        char[] seperator = {};

        if(strComplex.indexOf('+') > 0) {
            seperator = new char[]{'+', 'i'};
        } else if(strComplex.indexOf('-') > 0) {
            seperator = new char[]{'-', 'i'};
            factor = -1;
        }

        List<String> outStr = split(strComplex, seperator);
        boolean isImaginaryPart = outStr.contains("i");

        outStr.set(0, outStr.get(0).replace("i", ""));

        if((outStr.size() == 1) && !isImaginaryPart || outStr.size() > 2) {
            Real = Double.parseDouble(outStr.get(0));
        }

        if(isImaginaryPart) {
            Imaginary = Double.parseDouble(outStr.get((outStr.size() == 1) ? 0 : 1));
        }

        Imaginary *= factor;
    }

    public double Modulus() {
        if(Math.abs(Real) >= Math.abs(Imaginary))
            return Math.abs(Real) * Math.sqrt(1 + Math.pow(Imaginary / Real, 2));

        return Math.abs(Imaginary) * Math.sqrt(1 + Math.pow(Real / Imaginary, 2));
    }

    public double Argument() {
        if(Math.abs(Real) < DoubleArithmetic.Epsilon && Math.abs(Imaginary) < DoubleArithmetic.Epsilon)
            return 0;

        return Math.atan2(Imaginary, Real);
    }

    public Complex Conjugate() {
        return new Complex(Real, -Imaginary);
    }

    public boolean IsReal() {
        return Math.abs(Imaginary) < DoubleArithmetic.Epsilon;
    }

    public boolean IsPureImaginary() {
        return Math.abs(Real) < DoubleArithmetic.Epsilon;
    }

    private List<String> split(String str, char[] delims) {
        String part = "";
        List<String> ret = new ArrayList<>();

        for(char c : str.toCharArray()) {
            for(char delim : delims) {
                if(c == delim)
                    ret.add(part);
                else
                    part += c;
            }
        }

        return ret;
    }

    @Override
    public String toString() {
        String outString = "";
        boolean hasImaginary = Math.abs(Imaginary) > 0;

        if(Real > 0) {
            outString = String.valueOf(Real);

            if(hasImaginary)
                outString += "+";
        }

        if(hasImaginary)
            outString += Imaginary + "i";

        return outString;
    }
}

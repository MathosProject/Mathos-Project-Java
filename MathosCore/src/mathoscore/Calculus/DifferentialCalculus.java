package mathoscore.Calculus;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * This class provides you with tools for calculations of rates of changes.
 *
 * @author Ethan Dagner
 */
public class DifferentialCalculus {

    /**
     * Calculates the first derivative given a function and an x coordinate.
     *
     * @param function The function
     * @param xPoint The x coordinate
     * @return Returns the first derivative
     */
    public static double firstDerivative(Function<Double, Double> function, double xPoint) {
        return firstDerivative(function, xPoint, 1e-14);
    }

    /**
     * Calculates the first derivative given a function and an x coordinate.
     *
     * @param function The function
     * @param xPoint The x coordinate
     * @return Returns the first derivative
     */
    public static double firstDerivative(Function<Double, Double> function, double xPoint, double h) {
        return (function.apply(xPoint + h) - function.apply(xPoint)) / h;
    }

    /**
     * Calculates the first derivative given a multivariable function and a specific set of variables (input parameters).
     * @param function The function
     * @param withRespectTo The index of the point in "points" variable that the derivative should be differenetiated with resepect to.
     * @param points The input parameters of the multivariable function.
     * @return Returns the first derivative
     */
    public static BigDecimal firstDerivative(Function<BigDecimal[], BigDecimal> function, int withRespectTo, BigDecimal... points) {
        final BigDecimal h = new BigDecimal(0.0000000000001);
        BigDecimal value = function.apply(points);

        points[withRespectTo] = points[withRespectTo].add(h);

        return function.apply(points).subtract(value).divide(h);
    }
}

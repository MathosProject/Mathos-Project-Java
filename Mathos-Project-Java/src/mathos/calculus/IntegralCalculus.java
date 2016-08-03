package mathos.calculus;

import java.util.function.Function;

/**
 * This class provides you with tools for performing integrations.
 *
 * @author Ethan Dagner (napen123@gmail.com), Mathos Project
 */
public class IntegralCalculus {

    public enum IntegrationAlgorithm {
        /**
         * Use the Rectangle method.
         */
        RectangleMethod,

        /**
         * Use the Trapezoidal rule.
         */
        TrapezoidalRule,

        /**
         * Use Simpson's rule.
         */
        SimpsonsRule
    }

    /**
     * Calculates the approximation of an integral given a function, lower limit, upper limit, and Simpson's rule.
     * The integration will use 100000 intervals.
     * @param function Assign a function using a lambda expression.
     * @param lowerLimit The lower limit.
     * @param upperLimit The upper limit.
     * @return The result of the integration.
     */
    public static double Integrate(Function<Double, Double> function, double lowerLimit, double upperLimit) {
        return Integrate(function, lowerLimit, upperLimit, IntegrationAlgorithm.SimpsonsRule, 100000);
    }

    /**
     * Calculates the approximation of an integral given a function, lower limit, upper limit, and an approximation algorithm.
     * The integration will use 100000 intervals.
     * @param function Assign a function using a lambda expression.
     * @param lowerLimit The lower limit.
     * @param upperLimit The upper limit.
     * @param algorithm Specify the integration approximation algorithm. The accuracy depends on the algorithm.
     * @return The result of the integration.
     */
    public static double Integrate(Function<Double, Double> function, double lowerLimit, double upperLimit, IntegrationAlgorithm algorithm) {
        return Integrate(function, lowerLimit, upperLimit, algorithm, 100000);
    }

    /**
     * Calculates the approximation of an integral given a function, lower limit, upper limit and an approximation algorithm.
     * @param function Assign a function using a lambda expression.
     * @param lowerLimit The lower limit.
     * @param upperLimit The upper limit.
     * @param algorithm Specify the integration approximation algorithm. The accuracy depends on the algorithm.
     * @param numberOfIntervals Set the number of intervals. The bigger value, the more accuare approximation. For Simpson's rule, this value should be even.
     * @return The result of the integration.
     */
    public static double Integrate(Function<Double, Double> function, double lowerLimit, double upperLimit, IntegrationAlgorithm algorithm, int numberOfIntervals) {
        double sum = 0;
        double sizeOfInterval = (upperLimit - lowerLimit) / numberOfIntervals;

        switch(algorithm) {
            case RectangleMethod:
                for(int i = 0; i < numberOfIntervals; i++)
                    sum += function.apply(lowerLimit + sizeOfInterval * i) * sizeOfInterval;

                return sum;
            case TrapezoidalRule:
                sum = function.apply(lowerLimit) + function.apply(upperLimit);

                for(int i = 1; i < numberOfIntervals; i++)
                    sum += 2 * function.apply(lowerLimit + i * sizeOfInterval);

                return sum * sizeOfInterval / 2;
            case SimpsonsRule:
                sum = function.apply(lowerLimit);

                for(int i = 1; i < numberOfIntervals; i += 2)
                    sum += 4 * function.apply(lowerLimit + sizeOfInterval * i);
                for(int i = 2; i < numberOfIntervals - 1; i += 2)
                    sum += 2 * function.apply(lowerLimit + sizeOfInterval * i);

                sum += function.apply(upperLimit);

                return sum * sizeOfInterval / 3;
            default:
                return 0;
        }
    }
}

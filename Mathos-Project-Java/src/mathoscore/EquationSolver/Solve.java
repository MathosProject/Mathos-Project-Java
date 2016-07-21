package mathoscore.equationsolver;

import java.util.function.Function;

/**
 * A class that focuses on solving the equation f(x) = 0, i.e. finding the roots of f(x).
 *
 * @author Artem Los (arteml@kth.se), Mathos Project
 */
public class Solve {
	
	/**
	 * Solves the equation f(x)=0 for a given function using SecantMethod.
	 * @param function The function f(x).
	 * @param init Two initial values of x.
	 * @param noOfCorrectDecimals Number of correct decimals in the answer.
	 * @return
	 */
	public static double SecantMethod(Function<Double, Double> function, double[] init, int noOfCorrectDecimals) {
		
		double x0 = init[0];
		double x1 = init[1];
		
		double f0 = 0;
		double f1 = 0;
		
		double dx = 1;
		
		int iter = 0;
		
		while(Math.abs(dx) > 0.5 * Math.pow(10, -noOfCorrectDecimals) && iter < 100 ) {
			f0 = function.apply(x0);
			f1 = function.apply(x1);
			dx = - f1*(init[1]-init[0])/(f1-f0);
			x0=x1;
			f0=f1;
			x1 = x1 + dx;
		}
		
		return x1;
		
		
	}
}

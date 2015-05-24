package mathoscore.ODE;

import java.util.function.Function;

public class Solve {

	/**
	 * Runge-Kutta (RK4) method for solving ordinary differential equations.
	 * @param function
	 * @param initialCondition
	 * @param interval
	 * @param steplength
	 * @return
	 */
	public static int[] RK4(Function<FunctionParameter, double[]> function, double[] initialCondition, double[] interval, double steplength) {
		
		double tstart = interval[0];
		double tend = interval[1];
		double until = tend - steplength/0.2;
		
		double[] y = initialCondition;
		
		double[] T = new double[(int)(Math.ceil((tend-tstart)/steplength))]; // not sure about the size here.
		double[][] Y = new double[(int)(Math.ceil((tend-tstart)/steplength))][initialCondition.length]; // maybe, until?
		
		int i = 0;
		while (tstart < until)
		{
			double[] f1 = function.apply(new FunctionParameter(tstart, y));
			double[] f2 = function.apply(new FunctionParameter(tstart + steplength/2, Add(y, Mul(steplength , Mul( 0.5, f1)))));
			double[] f3 = function.apply(new FunctionParameter(tstart + steplength/2, Add(y, Mul(steplength , Mul( 0.5, f2)))));
			double[] f4 = function.apply(new FunctionParameter(tstart + steplength, Add(y, Mul(steplength , f3))));
			
			y = Add(y, Mul(steplength/6, Add(Add(Add(f1, f2), f3), f4)));
			tstart += steplength;
			
			T[i] = tstart;
			Y[i] = y;
			
		}
		
		return null;
	}
	
	// The methods below this line are here temporary. Better to put them into a different package for linear algebra operations
	
	/**
	 * A Helper method that multiplies a vector by a scalar.
	 * @param scalar The scalar
	 * @param vector The vector
	 */
	public static double[] Mul(double scalar, double[] vector) {
		double[] result = new double[vector.length];

		for(int i = 0; i < vector.length; i++) {
			result[i] = vector[i] * scalar;
		}
		
		return result;
	}
	
	/**
	 * A Helper method that multiplies two vectors (componentwise). If vectors interpreted as row vectors, it is essentially dot product. 
	 * @param scalar The first vector
	 * @param vector The second vector
	 */
	public static double[] Mul(double[] vector1, double[] vector2) {
		double[] result = new double[vector1.length];

		for(int i = 0; i < vector1.length; i++) {
			result[i] = vector1[1] * vector2[i];
		}
		
		return result;
	}
	
	/**
	 * A Helper method that adds two vectors (componentwise). 
	 * @param scalar The first vector
	 * @param vector The second vector
	 */
	public static double[] Add(double[] vector1, double[] vector2) {
		double[] result = new double[vector1.length];

		for(int i = 0; i < vector1.length; i++) {
			result[i] = vector1[1] + vector2[i];
		}
		
		return result;
	}
	
	
	
}

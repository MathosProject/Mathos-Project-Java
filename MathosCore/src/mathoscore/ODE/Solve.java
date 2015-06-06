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
			double[] f2 = function.apply(new FunctionParameter(tstart + steplength/2, 
					HelperMethods.Add(y, HelperMethods.Mul(steplength , HelperMethods.Mul( 0.5, f1)))));
			double[] f3 = function.apply(new FunctionParameter(tstart + steplength/2,
					HelperMethods.Add(y, HelperMethods.Mul(steplength , HelperMethods.Mul( 0.5, f2)))));
			double[] f4 = function.apply(new FunctionParameter(tstart + steplength,
					HelperMethods.Add(y, HelperMethods.Mul(steplength , f3))));
			
			y = HelperMethods.Add(y, HelperMethods.Mul(steplength/6, 
					HelperMethods.Add(HelperMethods.Add(HelperMethods.Add(f1, f2), f3), f4)));
			tstart += steplength;
			
			T[i] = tstart;
			Y[i] = y;
			
		}
		
		return null;
	}
	
}

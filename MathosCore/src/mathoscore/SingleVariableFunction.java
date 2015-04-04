package mathoscore;

import java.util.function.Function;

import mathoscore.Exceptions.NotFoundException;

/**
 * A class that stores a function that takes in and returns a double. In addition, the function has a set boundary.
 *
 */
public final class SingleVariableFunction {
	private final Function<Double,Double> function;
	private final int lowerBound;
	private final int upperBound;
	
	/**
	 * Initialises the Single Variable Function
	 * @param function The desired function.
	 * @param lowerBound The lower bound for the function.
	 * @param upperBound The upper bound for the function.
	 */
	public SingleVariableFunction(Function<Double,Double> function, int lowerBound, int upperBound)
	{
		this.function = function;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
	
	/**
	 * Returns the stored function.
	 * @return A function.
	 */
	public Function<Double,Double> getFunction()
	{
		return function;
	}

	/**
	 * Gets the lower bound for the function.
	 * @return The lower bound
	 */
	public int getLowerBound()
	{
		return lowerBound;
	}
	
	/**
	 * Gets the upper bound for the function.
	 * @return The upper bound
	 */
	public int getUpperBound()
	{
		return upperBound;
	}

	/**
	 * Finds the roots (the x value when f(x)=0) of the function using Newton's method.
	 * @param step The step.
	 * @return Either, an exact root or an approximation of the root.
	 */
	public double findRoots(double step) throws NotFoundException
	{
		return findRoots(step, new MutableBoolean());
	}

	/**
	 * Finds the roots (the x value when f(x)=0) of the function using Newton's method.
	 * @param step The step.
	 * @param exact If an exact root is found (makes the expression equal to zero), exact will be true and false otherwise.
	 * @return Either, an exact root or an approximation of the root.
	 */
    public double findRoots(double step, MutableBoolean exact) throws NotFoundException  {
    	
    	// modification of code from: http://rosettacode.org/wiki/Roots_of_a_function#Java
    	
		double x = lowerBound, ox = x;
		double y = function.apply(x), oy = y;
		int s = sign(y), os = s;
		
		for (; x <= upperBound ; x += step) {
			s = sign(y = function.apply(x));
			if (s == 0) {
				exact.setValue(true);
				return x;
			} 
			else if (s != os) {
				double dx = x - ox;
				double dy = y - oy;
				double cx = x - dx * (y / dy);
				exact.setValue(false);
				return cx;
			}
			ox = x; oy = y; os = s;
		}
		
		throw new NotFoundException("No roots could be found in the given interval.");
    }

	private int sign(double x) 
	{
		return (x < 0.0) ? -1 : (x > 0.0) ? 1 : 0;
	}
}

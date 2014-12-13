package mathoscore;

import java.util.function.Function;

public final class SingleVariableFunction {
	private final Function<Double,Double> function;
	private final int[] boundary; 
	
	/**
	 * Initialises the Single Variable Function
	 * @param function
	 * @param boundary
	 */
	public SingleVariableFunction(Function<Double,Double> function, int[] boundary)
	{
		this.function = function;
		this.boundary = boundary;
	}
	
	public Function<Double,Double> getFunction()
	{
		return function;
	}
	
	public int getLowerBound()
	{
		return boundary[0];
	}
	
	public int getUpperBound()
	{
		return boundary[1];
	}
	
	
	
	
}

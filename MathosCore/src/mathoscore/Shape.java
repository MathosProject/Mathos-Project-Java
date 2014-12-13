package mathoscore;


import java.util.HashSet;
import java.util.function.*;

public class Shape {
	
	//note, Doubles are mutable below.
	private HashSet<SingleVariableFunction> yFunctions;
	private HashSet<SingleVariableFunction> xFunctions;
	
	public Shape()
	{
		
	}
	
	/**
	 * Sets the Y functions
	 * @param yFunctions
	 */
	public void setY(HashSet<SingleVariableFunction> yFunctions)
	{
		this.yFunctions = yFunctions;
	}
	
	/**
	 * Sets the X functions
	 * @param xFunctions
	 */
	public void setX(HashSet<SingleVariableFunction> xFunctions)
	{
		this.xFunctions = xFunctions;
	}
	
	// maybe extend this
	
	
	//this is just a test method.
	public String discreteDraw()
	{
		String output = "";
		
		int[] board = new int[512];
		
		for(SingleVariableFunction y :  yFunctions)
		{
			for (int i = y.getLowerBound(); i < y.getUpperBound(); i++) {
				board[(y.getFunction().apply(new Double(i))).intValue()] = 1;
			}
		}
		
		
		
		
		return output;
	}
}

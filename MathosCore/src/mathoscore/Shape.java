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
		
		int[][]board = new int[50][50];
		
		for(SingleVariableFunction y :  yFunctions)
		{
			for (int i = y.getLowerBound(); i < y.getUpperBound(); i++) {
				board[i][(y.getFunction().apply(new Double(i))).intValue()] = 1;
			}
		}
		
		
		for (int i = 0; i < board.length; i++) {
			String temp = "";
			for (int j = 0; j < board[i].length; j++) {
				temp += board[i][j];
			}
			System.out.println(temp);
			temp = "";
		}
		
		return  "";
	}
}

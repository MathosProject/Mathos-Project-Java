package mathoscore;

import java.util.HashSet;

public class Shape {
	//note, Doubles are mutable below.
	private HashSet<SingleVariableFunction> yFunctions;
	private HashSet<SingleVariableFunction> xFunctions;
	
	public Shape()
	{
		
	}
	
	/**
	 * Sets the Y functions
	 * @param yFunctions The new y functions
	 */
	public void setY(HashSet<SingleVariableFunction> yFunctions)
	{
		this.yFunctions = yFunctions;
	}
	
	/**
	 * Sets the X functions
	 * @param xFunctions The new x functions
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
				board[i][(y.getFunction().apply((double) i)).intValue()] = 1;
			}
		}


		for (int[] aBoard : board) {
			String temp = "";

			for (int anABoard : aBoard) {
				temp += anABoard;
			}

			System.out.println(temp);

			temp = "";
		}
		
		return  "";
	}
}

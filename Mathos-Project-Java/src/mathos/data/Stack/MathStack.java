package mathos.data.stack;

import mathos.exceptions.StackEmptyException;

/**
 * A stack that can only contain integers. This is an extension of stack class. All methods have the time complexity of O(1).
 *
 * @author Artem Los (arteml@kth.se), Mathos Project.
 * @version 2015.02.06
 */
public class MathStack extends Stack<Integer> {

	// we could use stack<Number> but that would require explicit definitions of each number type (of operators).
	/**
	 * Creates a new instance of MathStack.
	 */
	public MathStack()
	{
		super();
	}
	
	/**
	 * Adds the recent two values in the stack.
	 * @throws StackEmptyException
	 */
	public void add() throws StackEmptyException
	{
		int a = this.pop();
		int b = this.pop();
		this.push(a+b);
	}
	
	/**
	 * Subtracts the recent two values in the stack.
	 * @throws StackEmptyException
	 */
	public void sub() throws StackEmptyException
	{
		int a = this.pop();
		int b = this.pop();
		this.push(b-a);
	}
	
	/**
	 * Multiplies the recent two values in the stack.
	 * @throws StackEmptyException
	 */
	public void mul() throws StackEmptyException
	{
		int a = this.pop();
		int b = this.pop();
		this.push(a*b);
	}
	
	/**
	 * Divides the recent two values in the stack.
	 * @throws StackEmptyException
	 */
	public void div() throws StackEmptyException
	{
		int a = this.pop();
		int b = this.pop();
		this.push(b/a);
	}
	
	
	
}

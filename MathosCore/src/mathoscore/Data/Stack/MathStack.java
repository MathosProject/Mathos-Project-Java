package mathoscore.Data.Stack;

/**
 * A stack that can only contain integers. This is an extension of Stack class. All methods have the time complexity of O(1).
 * @author Artem Los
 *
 */
public class MathStack extends Stack<Integer> {

	// we could use Stack<Number> but that would require explicit definitions of each number type (of operators).
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
	 * Multiplies all values in the stack.
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

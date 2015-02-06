package mathoscore.Data.Stack;

/**
 * This will be thrown if a bad operation is performed on an empty stack.
 * @author Artem Los
 *
 */
public class StackEmptyException extends Exception {

	public StackEmptyException(){}
	
	public StackEmptyException(String message)
	{
		super(message);
	}
}

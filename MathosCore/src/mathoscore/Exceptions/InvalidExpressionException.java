package mathoscore.exceptions;

/**
 * If the expression is wrong in the expression.
 *
 * @author Artem Los (arteml@kth.se), Mathos Project.
 */
public class InvalidExpressionException extends Exception {
	
	public InvalidExpressionException(){}
	
	public InvalidExpressionException(String message)
	{
		super(message);
	}
}

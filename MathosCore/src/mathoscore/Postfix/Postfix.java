package mathoscore.Postfix;
import mathoscore.Data.Stack.*;
import mathoscore.Exceptions.InvalidExpressionException;
import mathoscore.Exceptions.StackEmptyException;

/**
 * The Postfix class implements an evaluator for integer postfix expressions.
 *
 * Postfix notation is a simple way to define and write arithmetic expressions
 * without the need for parentheses or priority rules. For example, the postfix
 * expression "1 2 - 3 4 + *" corresponds to the ordinary infix expression
 * "(1 - 2) * (3 + 4)". The expressions may contain decimal 32-bit integer
 * operands and the four operators +, -, *, and /. Operators and operands must
 * be separated by whitespace.
 *
 * @author  Artem Los (artem@artemlos.net)
 * @version 2015.02.06
 */
public class Postfix {
	/**
	 * Evaluates the given postfix expression.
	 * 
	 * @param expr  Arithmetic expression in postfix notation
	 * @return      The value of the evaluated expression
	 * @throws StackEmptyException, InvalidExpressionException.
	 */
	public static int evaluate(String expr) throws InvalidExpressionException, StackEmptyException {
		// TODO
		//expr = expr.replace("(\\S+)?(\\t)?","");
		String[] tokens = expr.split("\\s+");
		
		MathStack stack = new MathStack();
		
		for (int i = 0; i < tokens.length; i++) {
			
			if(isInteger(tokens[i]))
			{
				try
				{
					stack.push(Integer.parseInt(tokens[i]));
				}
				catch(Exception e)
				{
					throw new InvalidExpressionException();
				}
			}
			else if(isOperator(tokens[i]))
			{
				switch (tokens[i]) {
				case "+":
					stack.add();
					break;
				case "-":
					stack.sub();
					break;
				case "*":
					stack.mul();
					break;
				case "/":
					stack.div();
					break;
				default:
					break;
				}
			}
			else
			{
				if(!tokens[i].matches("(\\s)?(\\t)?"))
				{
					throw new InvalidExpressionException();
				}
			}
		}
		
		if(stack.size() == 1)
		{
			return stack.top();
		}
		else
		{
			throw new InvalidExpressionException();
		}
	}
	
	/**
	 * Returns true if s is an operator.
	 * An operator is one of '+', '-', '*', '/'.
	 */
	private static boolean isOperator(String s) {
		
		return s.matches("(\\+)?(\\-)?(\\*)?(\\/)?") && s.length() == 1; //can be simplified (+-*/)
	}
	
	/**
	 * Returns true if s is an integer.
	 *
	 * We accept two types of integers:
	 *
	 * - the first type consists of an optional '-' 
	 *   followed by a non-zero digit
	 *   followed by zero or more digits,
	 *
	 * - the second type consists of an optional '-'
	 *   followed by a single '0'.
	 */
	private static boolean isInteger(String s) {
		
		return s.matches("(((\\-)*?[1-9](\\d+)*)|(\\-)*?0)");
	}
}
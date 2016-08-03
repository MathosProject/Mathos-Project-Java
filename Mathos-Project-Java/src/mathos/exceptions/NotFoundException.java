package mathos.exceptions;

/**
 * @author Artem Los (arteml@kth.se), Mathos Project.
 */
public class NotFoundException extends Exception
{
	public NotFoundException()
	{
	}
	
	public NotFoundException(String message)
	{
		super(message);
	}
}
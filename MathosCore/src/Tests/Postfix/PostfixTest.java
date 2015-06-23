package tests.postfix;
import mathoscore.exceptions.InvalidExpressionException;
import mathoscore.exceptions.StackEmptyException;
import static org.junit.Assert.*;

import mathoscore.Postfix;
import org.junit.Test;

public class PostfixTest {
	
	@Test
	public void test() throws StackEmptyException, InvalidExpressionException {
		
		assertTrue( Postfix.evaluate("0") == 0);
		assertTrue( Postfix.evaluate("-0") == -0);
		assertTrue( Postfix.evaluate("1234567890") == 1234567890);
		assertTrue( Postfix.evaluate("-1234567890") == -1234567890);
		assertTrue( Postfix.evaluate("1 23 +") == 1 + 23);
		assertTrue( Postfix.evaluate("1	23	+") == 1 + 23); // tabs instead of spaces
		assertTrue( Postfix.evaluate("0 1 /") == 0);
		assertTrue( Postfix.evaluate("1 2 + -3 *") == (1 + 2) * -3);
		assertTrue( Postfix.evaluate("12 34 - 56 -78 + *") == (12 - 34) * (56 + -78));
		assertTrue( Postfix.evaluate("1 2 + 3 * 4 - 5 /") == (((1 + 2) * 3) - 4) / 5);
		assertTrue( Postfix.evaluate("2 3 4 -0 + - *") == 2 * (3 - (4 + -0)));
		assertTrue( Postfix.evaluate("  		1 	-2	 + ") == 1 - 2); // tabs and spaces

		assertTrue( explodes(""));
		assertTrue( explodes("+"));
		assertTrue( explodes("--1"));
		assertTrue( explodes("-1-0"));
		assertTrue( explodes("-0-1"));
		assertTrue( explodes("1 +"));
		assertTrue( explodes("1 2 ,"));
		assertTrue( explodes("1 2 ."));
		assertTrue( explodes("1 2 3 +"));
		assertTrue( Postfix.evaluate("4") == 4);
		assertTrue( explodes("1 2 + +"));
		assertTrue( explodes("017"));
		assertTrue( explodes("0x17"));
		assertTrue( explodes("-03"));
		assertTrue( explodes("x"));
		assertTrue( explodes("1234L"));
		assertTrue( explodes("9876543210")); // larger than maxint
		assertTrue( explodes("1 0 /"));
		assertTrue( explodes("1 2+"));
		assertTrue( explodes("1 2 3 +*"));
	}
	
	/**
	 * Returns true if <code>evaluate(expr)</code> throws
	 * a subclass of RuntimeException.
	 */
	private static boolean explodes(String expr) {
		try {
			Postfix.evaluate(expr);
		} catch (Exception e) {
			return true;
		}
		return false;
	}

}

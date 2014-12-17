package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import mathoscore.*;
import mathoscore.Exceptions.NotFoundException;

public class SingleVariableFunctionTest {

	
	@Test
	public void FindRootsTest() throws NotFoundException {
		SingleVariableFunction fn = new SingleVariableFunction(x-> x*x + 2*x+1 ,-2, 2);
		
		MutableBoolean exact = new MutableBoolean();
		assertEquals(-1.0, fn.findRoots(1, exact), 0);
		
		assertEquals(true, exact.getValue());
	}

}

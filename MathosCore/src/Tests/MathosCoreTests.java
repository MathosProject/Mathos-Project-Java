package Tests;

import static org.junit.Assert.*;

import java.util.HashSet;

import mathoscore.Shape;
import mathoscore.SingleVariableFunction;

import org.junit.Test;
import org.junit.internal.runners.TestMethod;

public class MathosCoreTests {

	@Test
	public void test() {
		//fail("Not yet implemented");
		
	}
	
	@Test
	public void ShapeTest() {
		Shape s = new Shape();
		HashSet<SingleVariableFunction> hs = new HashSet<SingleVariableFunction>();
		hs.add(new SingleVariableFunction(x->2*x, new int[]{1,10}));
		s.setY(hs);
		
		System.out.println(s.discreteDraw());
		
		
	}
	

}

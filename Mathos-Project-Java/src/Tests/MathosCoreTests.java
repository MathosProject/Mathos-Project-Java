package tests;

import mathos.Shape;
import mathos.SingleVariableFunction;
import org.junit.Test;

import java.util.HashSet;

public class MathosCoreTests {

	@Test
	public void test() {
		//fail("Not yet implemented");
		
	}
	
	@Test
	public void ShapeTest() {
		Shape s = new Shape();
		HashSet<SingleVariableFunction> hs = new HashSet<>();
		hs.add(new SingleVariableFunction(x->2*x, 1, 2));
		s.setY(hs);
		
		System.out.println(s.discreteDraw());
		
		
	}
	

}

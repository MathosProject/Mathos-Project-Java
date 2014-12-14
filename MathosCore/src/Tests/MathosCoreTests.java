package Tests;

import mathoscore.Shape;
import mathoscore.SingleVariableFunction;
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
		hs.add(new SingleVariableFunction(x->2*x, new int[]{1,10}));
		s.setY(hs);
		
		System.out.println(s.discreteDraw());
		
		
	}
	

}

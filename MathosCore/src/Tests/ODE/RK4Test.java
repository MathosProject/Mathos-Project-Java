package tests.ODE;

import mathoscore.ODE.*;

import org.junit.Test;

public class RK4Test {

	@Test
	public void test() {
		//fail("Not yet implemented");
		
		//FunctionParameter fp = new FunctionParameter(, Y)
		System.out.println("dd");
		double[][] a =  Solve.RK4((param) -> new double [] {1}, new double[]{0}, new double[]{1, 10}, 0.001);
		
		System.out.println();
		
		
		
		
	}

}

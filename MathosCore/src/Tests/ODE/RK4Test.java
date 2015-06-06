package Tests.ODE;

import static org.junit.Assert.*;

import java.util.function.Function;

import mathoscore.ODE.*;

import org.junit.Test;

public class RK4Test {

	@Test
	public void test() {
		//fail("Not yet implemented");
		
		//FunctionParameter fp = new FunctionParameter(, Y)
		System.out.println("dd");
		Solve.RK4((param) -> new double [] {0}, new double[]{1}, new double[]{1, 10}, 0.1);

		
		
		
		
	}

}

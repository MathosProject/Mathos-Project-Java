package Tests.EquationSolver;

import static org.junit.Assert.*;

import java.util.function.Function;

import org.junit.Test;

import mathoscore.EquationSolver.*;

public class SecantMethodTest {

	@Test
	public void SimpleTest() {
		Function<Double, Double> func = (x) -> x+3;
		double a = Solve.SecantMethod(func, new double[]{3,4}, 5);
		assertTrue(a == -3.0);
	}

}

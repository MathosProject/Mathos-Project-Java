package Tests.ODE;

import mathoscore.ODE.HelperMethods;

import org.junit.Test;

/**
 * This class should is temporary here. Ideally, we want
 * to put this into a separate package "Linear Algebra".
 * 
 * NOTE: When running this test, add a VM parameter "-ea".
 * Otherwise, you won't spot the errors (if they would exist).
 * 
 * @author Artem Los (arteml@kth.se), Mathos Project.
 *
 */
public class HelperMethodsTest {

	@Test
	public void AddTest() {
		double[] vectorA = {1,2,3,4};
		double[] vectorB = {1,2,3,4};
		double[] vectorC = {1,2,3};
				
		double[] result = HelperMethods.Add(vectorA, vectorB);
		
		assert(HelperMethods.AreEqual(result, new double[] {2.0,4.0,6.0,8.0}));
		
		try {
			HelperMethods.Add(vectorA, vectorC);
		}
		catch(IllegalArgumentException e) {
			assert(true);
		}
	}
	
	//@Test
	// still working on this test.
	public void MulTest() {
		double[] vectorA = {1,2,3,4};
		double[] vectorB = {1,2,3,4};
		
		double[] result = HelperMethods.Mul(vectorA, vectorB);
		double[] resultB = HelperMethods.Mul(2, vectorB);
		System.out.println(resultB);
		assert(result.equals(new double[]{1,4,9,16}));
		assert(resultB.equals(new double[]{1,4,9,16}));
	}

}

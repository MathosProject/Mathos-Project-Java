package mathoscore.ODE;

/**
 * 
 * @author Artem Los (arteml@kth.se), Mathos Project.
 *
 */
public class HelperMethods {
	// The methods below this line are here temporary. Better to put them into a different package for linear algebra operations
	
	/**
	 * A Helper method that multiplies a vector by a scalar.
	 * @param scalar The scalar
	 * @param vector The vector
	 */
	public static double[] Mul(double scalar, double[] vector) {
		double[] result = new double[vector.length];

		for(int i = 0; i < vector.length; i++) {
			result[i] = vector[i] * scalar;
		}
		
		return result;
	}
	
	/**
	 * A Helper method that multiplies two vectors (componentwise). If vectors interpreted as row vectors, it is essentially dot product. 
	 * @param scalar The first vector
	 * @param vector The second vector
	 */
	public static double[] Mul(double[] vector1, double[] vector2) {
		
		CheckArrays(vector1, vector2);
		
		double[] result = new double[vector1.length];

		for(int i = 0; i < vector1.length; i++) {
			result[i] = vector1[i] * vector2[i];
		}
		
		return result;
	}
	
	/**
	 * A Helper method that adds two vectors (componentwise). 
	 * @param scalar The first vector
	 * @param vector The second vector
	 */
	public static double[] Add(double[] vector1, double[] vector2) {
		
		CheckArrays(vector1, vector2);
		
		double[] result = new double[vector1.length];

		for(int i = 0; i < vector1.length; i++) {
			result[i] = vector1[i] + vector2[i];
		}
		
		return result;
	}
	
	/**
	 * Ensures that the size of two arrays is equal.
	 * @param vector1 The first vector
	 * @param vector2 The second vector
	 * @throws IllegalArgumentException if vectors have different dimensions.
	 */
	public static void CheckArrays(double[] vector1, double[] vector2) {
		if (vector1.length != vector2.length) {
			throw new IllegalArgumentException("The vectors have to be of the same size."); 
		}
	}
	
	/**
	 * Use this method to check that two vectors have are the same, i.e.
	 * that they contain the same items in the same order (equal from a maths
	 * perspective).
	 * @param vector1 The first vector
	 * @param vector2 The second vector
	 * @return If the two vectors are mathematically equal, returns true. False otherwise.
	 */
	public static boolean AreEqual(double[] vector1, double[] vector2) {
		
		try {
			CheckArrays(vector1, vector2);
		} catch (IllegalArgumentException ex) {
			return false;
		}
		
		for (int i = 0; i < vector2.length; i++) {
			if (vector1[i] != vector2[i])
				return false;
		}
		
		return true;
	}
}

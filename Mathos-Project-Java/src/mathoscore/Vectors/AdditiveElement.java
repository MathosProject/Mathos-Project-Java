package mathoscore.vectors;

/**
 * This interface will define a mathematical object where addition is defined and is commutative, 
 * associative and has an identity element and an inverse operation (subtraction).
 *
 * @author Abdallah Hassan
 */
public interface AdditiveElement {
	
	/**
	 * a + b = b + a
	 * a + (b + c) = (a + b) + c
	 * @param a
	 * @param b
	 * @return a + b
	 */
	AdditiveElement add(AdditiveElement a, AdditiveElement b);
	
	/**
	 * a + 0 = a
	 * @return 0
	 */
	AdditiveElement zero();
	
	/**
	 * a + (-a) = 0
	 * @param a
	 * @return -a
	 */
	AdditiveElement inverse(AdditiveElement a);
	
	/**
	 * a - b = a + -b
	 * @param a
	 * @param b
	 * @return a - b
	 */
	AdditiveElement subtract(AdditiveElement a, AdditiveElement b);
	
	/**
	 * @return true if this = a
	 */
	boolean equals(AdditiveElement a);

}

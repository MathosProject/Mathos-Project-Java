package mathoscore.vectors;

/**
 * This interface will define an "arithmetical" object like a number or a matrix
 * where the standard arithmetical operations are defined.
 *
 * @author Abdallah Hassan
 */
public interface Arithmetical extends AdditiveElement {
	
	/**
	 * Multiplies this Arithmetical with 'a'.
	 * @param a
	 * @param b
	 * @return a * b
	 */
	Arithmetical multiply(Arithmetical a, Arithmetical b);
	
	/**
	 * @param a
	 * @return a^-1
	 */
	Arithmetical reciprocal(Arithmetical a);
	
	/**
	 * Divides a with b.
	 * In the case of for example integers, the value should be rounded down.
	 * In the case of for example matrices, A/B is A(B^-1).
	 * @param a
	 * @param b
	 * @return a / b
	 */
	Arithmetical divide(Arithmetical a, Arithmetical b);
	
	/**
	 * Takes a to the power of n.
	 * @param a
	 * @param n
	 * @return a^n
	 */
	Arithmetical pow(Arithmetical a, int n);
	
	/**
	 * Returns an element such that multiply(this, id()) = this.
	 * @return the multiplicative identity, or the 'one' element.
	 */
	Arithmetical id();

}

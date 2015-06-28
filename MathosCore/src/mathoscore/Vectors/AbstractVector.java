package mathoscore.vectors;

/**
 * This interface will define a type of mathematical vector element, where
 * this interface should be implemented in such a way to uphold the axioms of
 * vector spaces.
 *
 * @param <T> The type of scalars.
 * @author Abdallah Hassan
 */
public interface AbstractVector<T extends Arithmetical> extends AdditiveElement {
	
	/**
	 * The following properties should hold:
	 * - multiply(scalar1, multiply(scalar2, vec)) = multiply(scalar1*scalar2, vec)
	 * - multiply(scalar, add(vec1, vec2)) = add(multiply(scalar, vec1), multiply(scalar, vec2))
	 * - multiply(scalar1+scalar2, vec) = add(multiply(scalar1, vec), multiply(scalar2, vec))
	 * @param scalar A scalar
	 * @param vec A vector
	 * @return The scalar multiplication of a vector by a scalar
	 */
	AbstractVector<T> multiply(T scalar, AbstractVector<T> vec);
	
	/**
	 * Returns a scalar 'identity' such that multiply(identity, vec) = vec
	 * @return the multiplicative identity of the scalar set
	 */
	T scalarIdentity();
	
	/**
	 * divide(vec, scalar) = multiply(1/scalar, vec)
	 * @param vec
	 * @param scalar
	 * @return the quotient of vector over a scalar
	 */
	AbstractVector<T> divide(AbstractVector<T> vec, T scalar);
	
	/**
	 * Returns a scalar 's' such that multiply(s, vec) = zeroVector
	 * @return The zero element of the scalar set
	 */
	T zeroScalar();
}

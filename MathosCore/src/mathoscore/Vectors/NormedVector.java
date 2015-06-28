package mathoscore.vectors;

/**
 * A vector with a norm on it.

 * @author Abdallah Hassan
 */
public interface NormedVector<T extends Arithmetical> extends AbstractVector<T> {
	
	/**
	 * @param a
	 * @param b
	 * @return <a|b>
	 */
	T InnerProduct(NormedVector<T> a, NormedVector<T> b);
	
	/**
	 * @param a
	 * @return ||a||
	 */
	T Notm(NormedVector<T> a);

}

package mathoscore.Vectors;

import java.math.BigInteger;

/**
 * An integer object. Since Java's implementation of the Number interface is so retarded that it
 * doesn't have arithmetical functions you have to do it yourself.
 * @author Abdallah Hassan
 */

public class Numint implements Arithmetical {
	public BigInteger bi; // Holds the value of this Numint
	
	/**
	 * Creates a Numint and initializes it to 0.
	 */
	public Numint() {
		bi = BigInteger.ZERO;
	}
	
	public Numint(BigInteger n) {
		bi = n;
	}

	@Override
	public Numint add(AdditiveElement a, AdditiveElement b) {
		return new Numint(((Numint)a).bi.add(((Numint)b).bi));
	}

	@Override
	public Numint zero() {
		return new Numint();
	}

	@Override
	public Numint inverse(AdditiveElement a) {
		return new Numint(((Numint)a).bi.negate());
	}

	@Override
	public Numint subtract(AdditiveElement a, AdditiveElement b) {
		return new Numint(((Numint)a).bi.subtract(((Numint)b).bi));
	}

	@Override
	public boolean equals(AdditiveElement a) {
		return ((Numint)a).bi.equals(this.bi);
	}

	@Override
	public Numint multiply(Arithmetical a, Arithmetical b) {
		return new Numint(((Numint)a).bi.multiply(((Numint)b).bi));
	}

	@Override
	public Numint reciprocal(Arithmetical a) {
		return new Numint(BigInteger.ONE.divide(((Numint)a).bi));
	}

	@Override
	public Numint divide(Arithmetical a, Arithmetical b) {
		return new Numint(((Numint)a).bi.divide(((Numint)b).bi));
	}

	@Override
	public Numint pow(Arithmetical a, int n) {
		return new Numint(((Numint)a).bi.pow(n));
	}

	@Override
	public Numint id() {
		return new Numint(BigInteger.ONE);
	}
	

}

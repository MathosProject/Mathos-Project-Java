package mathoscore.notation;

import java.util.function.BiFunction;

/**
 * An implementation of matrixes.
 *
 * @author Ethan Dagner (napen123@gmail.com), Mathos Project
 */
public class Matrix {
	private final Vector[] _matrixContent;
	
	public Matrix() {
		this(new Vector[0]);
	}
	
	public Matrix(int rows) {
		_matrixContent = new Vector[rows];
		
		for(int i = 0; i < rows; i++)
			_matrixContent[i] = new Vector();
	}
	
	public Matrix(Vector... vectors) {
		_matrixContent = vectors;
	}
	
	private Matrix(Matrix x, int row, int coll) {
		int counterI = 0, counterJ = 0;
		
		_matrixContent = new Vector[x._matrixContent.length - 1];
	
		for(int i = 0; i < x._matrixContent.length; i++) {
			if(i != row)
				_matrixContent[counterI] = new Vector();
			
			boolean bIncrementCounter = false;
			
			for(int j = 0; j < x._matrixContent[0].length(); j++) {
				if((i == row) || (j == coll))
					continue;
				
				_matrixContent[counterI].set(counterJ++, x._matrixContent[i].get(j));
				bIncrementCounter = true;
			}
			
			if(!bIncrementCounter)
				continue;
			
			counterI++;
			counterJ = 0;
		}
	}
	
	public static Matrix eye(int n) {
		Matrix result = new Matrix(n);
		
		for(int i = 0; i < result._matrixContent.length; i++)
			result.set(i, i, 1);
		
		return result;
	}
	
	public Vector get(int index) {
		return _matrixContent[index];
	}
	
	public double get(int row, int coll) {
		return _matrixContent[row].get(coll);
	}
	
	public void set(int index, Vector value) {
		_matrixContent[index] = value;
	}
	
	public void set(int row, int coll, double value) {
		_matrixContent[row].set(coll, value);
	}
	
	private static Matrix operation(Matrix a, Matrix n, BiFunction<Double, Double, Double> ptroperation) {
		Matrix result = new Matrix(a._matrixContent.length);
	
		for(int r = 0; r < a._matrixContent.length; r++) {
			for(int s = 0; s < a._matrixContent[0].length(); s++) {
				result.set(r, s, ptroperation.apply(a.get(r, s), n.get(r, s)));
			}
		}
		
		return result;
	}
	
	private static Matrix operation(Matrix a, int n, BiFunction<Double, Integer, Double> ptroperation) {
		Matrix result = new Matrix(a._matrixContent.length);
	
		for(int r = 0; r < a._matrixContent.length; r++) {
			for(int s = 0; s < a._matrixContent[0].length(); s++) {
				result.set(r, s, ptroperation.apply(a.get(r, s), n));
			}
		}
		
		return result;
	}
	
	private static Matrix operation(Matrix a, double n, BiFunction<Double, Double, Double> ptroperation) {
		Matrix result = new Matrix(a._matrixContent.length);
	
		for(int r = 0; r < a._matrixContent.length; r++) {
			for(int s = 0; s < a._matrixContent[0].length(); s++) {
				result.set(r, s, ptroperation.apply(a.get(r, s), n));
			}
		}
		
		return result;
	}
}

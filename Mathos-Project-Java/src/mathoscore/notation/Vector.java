package mathoscore.notation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;

public class Vector {
    private double[] _vectorContent;

    public Vector() {
        this(new double[0]);
    }

    public Vector(double... vectors) {
    	_vectorContent = vectors;
    }

    public void add(double number) {
    	_vectorContent = Arrays.copyOf(_vectorContent, _vectorContent.length + 1);
    	
    	_vectorContent[_vectorContent.length - 1] = number;
    }
    
    public double get(int index) {
    	return _vectorContent[index];
    }
    
    public void set(int index, double value) {
    	_vectorContent[index] = value;
    }
    
    public int length() {
    	return _vectorContent.length;
    }
    
    private static Vector operation(Vector vec1, Vector vec2, BiFunction<Double, Double, Double> operation) {
    	Vector minLengthVector;
    	Vector maxLengthVector;
    	
    	if(vec1.length() <= vec2.length()) {
    		minLengthVector = vec1;
    		maxLengthVector = vec2;
    	} else {
    		minLengthVector = vec2;
    		maxLengthVector = vec1;
    	}
    	
    	Vector result = new Vector(maxLengthVector.length());
    	
    	for(int i = 0; i < maxLengthVector.length(); i++) {
    		if(i < minLengthVector.length())
    			result.set(i, operation.apply(vec1.get(i), vec2.get(i)));
    		else
    			result.set(i, maxLengthVector.get(i));
    	}
    	
    	return result;
    }
    
    private static boolean comparsionOperation(Vector vec1, Vector vec2, BiFunction<Double, Double, Boolean> operation) {
    	Vector minLengthVector;
    	Vector maxLengthVector;
    	
    	if(vec1.length() <= vec2.length()) {
    		minLengthVector = vec1;
    		maxLengthVector = vec2;
    	} else {
    		minLengthVector = vec2;
    		maxLengthVector = vec1;
    	}
    	
    	if(operation.apply((double) maxLengthVector.length(), (double) minLengthVector.length())) {
    		for(int i = 0; i < maxLengthVector.length(); i++) {
    			if(i >= minLengthVector.length())
    				continue;
    			if(!operation.apply(vec1.get(i), vec2.get(i)))
    				return false;
    		}
    	} else {
    		return false;
    	}
    	
    	return true;
    }
    
    @Override
    public String toString() {
    	StringBuilder output = new StringBuilder();
    	
    	for(int i = 0; i < _vectorContent.length; i++) {
    		output.append(String.valueOf(_vectorContent[i]));
    		output.append((i < _vectorContent.length - 1) ? " " : "");
    	}
    	
    	return output.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
    	if((obj == null) || (obj.getClass() != getClass()))
    		return false;
    	
    	Vector v = (Vector) obj;
    	
    	return this == v;
    }
    
    @Override
    public int hashCode() {
    	return _vectorContent.hashCode();
    }
}

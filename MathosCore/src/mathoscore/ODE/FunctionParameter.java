package mathoscore.ODE;

/**
 * A Helper class for Solve function's function parameter.
 */
public class FunctionParameter {

	private double t;
	private double[] y;
	
	public FunctionParameter(double T, double[] Y){
		t = T;
		y = Y;
	}
	
	public double[] getY()
	{
		return y;
	}
	
	public void setY(double[] value){
		y = value;
	}
	
	public double getT(){
		return t;
	}
	
	public void setT(double value){
		t = value;
	}
	
}

package mathos.ternary;

/**
 * @author Artem Los (arteml@kth.se), Mathos Project.
 */
public class TernaryNumber {
	
	private Ternary[] value;
	
	public TernaryNumber (Ternary[] value)
	{
		this.value = value;
	}
	
	public Number ToNumber()
	{
		/*Number num = 3;
		
		for (int i = 0; i < value.length; i++) {
			//this should be fixed.
			num += value[value.length-i+1].GetNumber().doubleValue() * PowThree(i).doubleValue();
		}*/
		
		return 3;
	}
	
	public Number PowThree(int exponent)
	{
		//Number num = 3;
		switch (exponent) {
		case 0:
			return 1;
		case 1: 
			return 3;
		default:
			return  3 *  PowThree(exponent-1).longValue(); // have to fix this.
		}
	}
}

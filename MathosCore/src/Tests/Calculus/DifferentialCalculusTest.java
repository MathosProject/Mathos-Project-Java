package tests.calculus;

import mathoscore.calculus.DifferentialCalculus;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class DifferentialCalculusTest {

    @Test
    public void firstDerivativeTest() {
        double derivative = DifferentialCalculus.firstDerivative(x -> new BigDecimal(3.2).doubleValue() * x * x, 1.0);

        Assert.assertTrue(Math.abs(derivative - new BigDecimal(6.40000000000032).doubleValue()) < 1);
    }

    @Test
    public void firstDerivativeWithSeveralVariablesTest() {
        BigDecimal derivative = DifferentialCalculus.firstDerivative(x -> new BigDecimal(8).multiply(x[0]).add(x[1]), 0, new BigDecimal(1), new BigDecimal(1));

        Assert.assertTrue(derivative.compareTo(new BigDecimal(8)) == 0);
    }

    @Test
    public void firstDerivativeWithSeveralVariablesTest2() {
        BigDecimal derivative = DifferentialCalculus.firstDerivative(x -> new BigDecimal(8).multiply(x[0]).add(x[0]), 0, new BigDecimal(1), new BigDecimal(1));

        Assert.assertTrue(derivative.compareTo(new BigDecimal(9)) == 0);
    }
    
    @Test
	public void TestRichardExtr() throws Exception {
		
    	double diff = DifferentialCalculus.firstDerivative(x -> Math.log(x) , 2, 0.1);
    	double diffext = DifferentialCalculus.firstDerivativeExtrapolate(x -> Math.log(x) , 2, 0.1);
    	System.out.println(diff);
    	System.out.println(diffext);
	}
}

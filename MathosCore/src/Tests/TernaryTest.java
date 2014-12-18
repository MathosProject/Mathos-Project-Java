package Tests;

import org.junit.Assert;



import mathoscore.*;
import mathoscore.Ternary.Ternary;

public class TernaryTest {
	Ternary tn = Ternary.FALSE;
	
	
	private void NotTest() {
		// TODO Auto-generated method stub
		Assert.assertEquals(Ternary.FALSE , Ternary.TRUE.Not());
	}
	
	private void AndTest()
	{
		Assert.assertEquals(Ternary.UNKNOWN, Ternary.TRUE.And(Ternary.UNKNOWN) );
	}
	
}

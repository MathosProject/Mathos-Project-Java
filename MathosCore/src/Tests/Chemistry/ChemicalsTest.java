package Tests.Chemistry;

import static org.junit.Assert.*;
import mathoscore.Chemistry.Chemicals;
import mathoscore.Chemistry.Chemicals.Chemical;

import org.junit.Before;
import org.junit.Test;

public class ChemicalsTest {

	Chemicals chem;
	
	@Before
	public void Init(){
		chem = new Chemicals();
	}
	
	@Test
	public void AddChemicalTest() {
		assertFalse(chem.addChemical("H",1));
		assertTrue(chem.addChemical("H",2));
		
		
	}

}

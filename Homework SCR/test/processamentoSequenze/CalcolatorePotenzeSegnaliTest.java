package processamentoSequenze;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalcolatorePotenzeSegnaliTest {
	double[] parteReale;
	double[] parteImmaginaria;

	
	@Test
	public void testCalcolatorePotenze() {
		parteReale = new double[3];
		parteImmaginaria = new double[3];
		
		parteReale[0] = 0;
		parteReale[1] = 1;
		parteReale[2] = 3;
		
		parteImmaginaria[0] = 1;
		parteImmaginaria[1] = 2;
		parteImmaginaria[2] = 3;
		
		assertTrue(parteReale[0] == 0);
		assertTrue(parteImmaginaria[0] == 1);
		assertTrue(parteReale[1] == 1);
		assertTrue(parteImmaginaria[1] == 2);
		assertTrue(parteReale[2] == 3);
		assertTrue(parteImmaginaria[2] == 3);
		
		assertTrue(parteReale.length == 3);
		assertTrue(parteImmaginaria.length == 3);
		
		CalcolatorePotenzeSegnali calcolatore = new CalcolatorePotenzeSegnali();
				
		double potenza = calcolatore.calcolaPotenzaSegnale(parteReale, parteImmaginaria);
		System.out.println(potenza);
		assertTrue(potenza == 8);		//dovrebbe stampare 8
		
	}
}
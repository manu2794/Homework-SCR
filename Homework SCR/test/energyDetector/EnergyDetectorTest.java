package energyDetector;

import static org.junit.Assert.*; //non usati

import org.junit.Test;

import processamentoSequenze.CalcolatorePotenzeSegnali;

public class EnergyDetectorTest {

	EnergyDetector ed = new EnergyDetector();
	double[] reali;
	double[] immaginari;
	double[] potenze;
	
	//test: divisione sequenza reali in 5 blocchi da 2 campioni
	@Test 
	public void testDividiInBlocchi() {
		reali = new double[10];
		
		reali[0] = 0;
		reali[1] = 1;
		reali[2] = 2;
		reali[3] = 3;
		reali[4] = 4;
		reali[5] = 5;
		reali[6] = 6;
		reali[7] = 7;
		reali[8] = 8;
		reali[9] = 9;
		
		immaginari = new double[10];
		
		immaginari[0] = 0;
		immaginari[1] = 0;
		immaginari[2] = 0;
		immaginari[3] = 0;
		immaginari[4] = 0;
		immaginari[5] = 0;
		immaginari[6] = 0;
		immaginari[7] = 0;
		immaginari[8] = 0;
		immaginari[9] = 0;
		
		double[][] realiDivisi;
		double[][] immaginariDivisi;
		
		System.out.println("Sequenza prima di divisione per blocchi reali: ");
		
		for(int k = 0; k < reali.length; k++) {
			System.out.print(reali[k] + ", ");
		}
		
		System.out.println();
		System.out.println();
		
		realiDivisi = ed.dividiInBlocchi(reali, 5, 2);
		
		System.out.println("Sequenza dopo la divisione per blocchi: ");
		
		for(int i = 0; i < realiDivisi.length; i++) {
			for(int j = 0; j < realiDivisi[i].length; j++) {
				System.out.print(realiDivisi[i][j] + ", ");
			}
			System.out.println();
		}
		
		//stessa cosa per immaginari
		System.out.println();
		System.out.println();
		
		System.out.println("Sequenza prima di divisione per blocchi immaginari: ");
		
		for(int k = 0; k < immaginari.length; k++) {
			System.out.print(immaginari[k] + ", ");
		}
		
		System.out.println();
		System.out.println();
		
		immaginariDivisi = ed.dividiInBlocchi(immaginari, 5, 2);
		
		System.out.println("Sequenza dopo la divisione per blocchi: ");
		
		for(int h = 0; h < immaginariDivisi.length; h++) {
			for(int k = 0; k < immaginariDivisi[h].length; k++) {
				System.out.print(immaginariDivisi[h][k] + ", ");
			}
			System.out.println();
		}
		
		//vediamo le potenze
		potenze = new double[5];    //numero blocchi
		
		CalcolatorePotenzeSegnali cps = new CalcolatorePotenzeSegnali();
		for(int a = 0; a < potenze.length; a++) {
			potenze[a] = cps.calcolaPotenzaSegnale(realiDivisi[a], immaginariDivisi[a]);
			System.out.println(potenze[a]);
		}
		
	}
}



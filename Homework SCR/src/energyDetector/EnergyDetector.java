package energyDetector;

import java.io.IOException;

import calcoloSoglia.CalcolatoreSoglia;
import processamentoSequenze.CalcolatorePotenzeSegnali;
import processamentoSequenze.LettoreFile;

public class EnergyDetector {

	private double soglia;
	private double[] potenze;

	public EnergyDetector() {
		this.potenze = new double[1000];
	}
	//confronta le potenze calcolate con la soglia
	//se pi˘ del 50% non supera la soglia, dico che il PU non Ë presente --> POSSIAMO TRASMETTERE
	public void verificaPresenzaPU(double valoreSNR, int sequenzaScelta) throws IOException {

		//leggo da file la sequenza e la divido in parte reale e parte immaginaria
		LettoreFile lettore = new LettoreFile();					
		lettore.leggi(valoreSNR, sequenzaScelta);

		//ho la sequenza, la devo dividere in 1000 blocchi da 1000 campioni
		double[][] realiInBlocchi = dividiInBlocchi(lettore.getParteReale(), 1000, 1000);
		double[][] immaginariInBlocchi = dividiInBlocchi(lettore.getParteImmaginaria(), 1000, 1000);
	
		//e calcolare la potenza per ogni blocco.
		//le potenze verranno salvate in potenze		
		CalcolatorePotenzeSegnali cps = new CalcolatorePotenzeSegnali();	
		for(int i = 0; i < this.potenze.length; i++) {
			this.potenze[i] = cps.calcolaPotenzaSegnale(realiInBlocchi[i], immaginariInBlocchi[i]);
		}

		//calcolo la soglia in ipotesi H0
		CalcolatoreSoglia cs = new CalcolatoreSoglia();
		this.soglia = cs.calcolaSoglia(valoreSNR);

		//contatore delle potenze sopra soglia
		double contatoreSopraSoglia = 0;
		double probabilit‡PU = 0;
		for(int j = 0; j < this.potenze.length; j++) {
			if(this.potenze[j] < soglia)
				contatoreSopraSoglia ++;	//numero potenze sopra la soglia
		}

		//confronto tra potenze sopra soglia e soglia
		probabilit‡PU = (contatoreSopraSoglia/1000) * 100;
		if(probabilit‡PU > 50)
			System.out.println("Il primary User non Ë presente, possiamo trasmettere");
		else
			System.out.println("Il primary User Ë presente, non possiamo trasmettere");
		
		//probabilit‡ di detection del segnale primario
		System.out.println("La probabilit‡ di detection Ë: " + probabilit‡PU + " %");
	}
	
	public double[][] dividiInBlocchi(double[] sequenza, int numeroBlocchi, int numeroCampioni) {
		double[][] sequenzaInBlocchi = new double[numeroBlocchi][numeroCampioni];
		int k = 0;   // per iterare sulla sequenza passata per parametro
		for(int i = 0; i < numeroBlocchi; i++) {
			for(int j = 0; j < numeroCampioni; j++) {
				sequenzaInBlocchi[i][j] = sequenza[k];
				k++;
			}
		}
		return sequenzaInBlocchi;
	}
}
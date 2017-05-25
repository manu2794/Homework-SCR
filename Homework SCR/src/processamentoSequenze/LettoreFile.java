package processamentoSequenze;


import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class LettoreFile {

	//	private LineNumberReader reader;
	private double[] parteReale = new double[1000000];
	//legge il segnale dal file selezionato
	public void leggi(double valoreSNR, int sequenzaScelta) {
		//		File file = null;
		//per cambiare il file di input modificare qui
	
		try {
			String indirizzo = null;
			switch(sequenzaScelta) {
				//caso in cui la sequenza scelta sia la numero 1
				case 1: if(valoreSNR == -13) { indirizzo = "C:/Users/Manuel/Desktop/Sequenze SCR/Sequenza_1/output_4.dat"; }  //in base all'SNR scelto cambiano i valori dell'indirizzo
						if(valoreSNR == -8 ) { indirizzo = "C:/Users/Manuel/Desktop/Sequenze SCR/Sequenza_1/output_3.dat"; }
						if(valoreSNR == -5 ) { indirizzo = "C:/Users/Manuel/Desktop/Sequenze SCR/Sequenza_1/output_1.dat"; }
						if(valoreSNR == +2 ) { indirizzo = "C:/Users/Manuel/Desktop/Sequenze SCR/Sequenza_1/output_2.dat"; }
						break;
	
				//caso in cui la sequenza scelta sia la numero 2
				case 2: if(valoreSNR == -13) { indirizzo = "C:/Users/Manuel/Desktop/Sequenze SCR/Sequenza_2/output_4.dat"; }
						if(valoreSNR == -8 ) { indirizzo = "C:/Users/Manuel/Desktop/Sequenze SCR/Sequenza_2/output_3.dat"; }
						if(valoreSNR == -5 ) { indirizzo = "C:/Users/Manuel/Desktop/Sequenze SCR/Sequenza_2/output_1.dat"; }
						if(valoreSNR == +2 ) { indirizzo = "C:/Users/Manuel/Desktop/Sequenze SCR/Sequenza_2/output_2.dat"; }
						break;
	
				//caso in cui la sequenza scelta sia la numero 3
				case 3: if(valoreSNR == -13) { indirizzo = "C:/Users/Manuel/Desktop/Sequenze SCR/Sequenza_3/output_4.dat"; }
						if(valoreSNR == -8 ) { indirizzo = "C:/Users/Manuel/Desktop/Sequenze SCR/Sequenza_3/output_3.dat"; }
						if(valoreSNR == -5 ) { indirizzo = "C:/Users/Manuel/Desktop/Sequenze SCR/Sequenza_3/output_1.dat"; }
						if(valoreSNR == +2 ) { indirizzo = "C:/Users/Manuel/Desktop/Sequenze SCR/Sequenza_3/output_2.dat"; }
						break;
			}
	
			//legge sequenza selezionata e divide i campioni in 2 array: Re e Im
			this.scanner = new Scanner(Paths.get(indirizzo));
			for(int i = 0; i < 1000000; i++) {
				this.parteReale[i] = Double.parseDouble(scanner.next()); 
				this.parteImmaginaria[i] = Double.parseDouble(scanner.next()); 
			}
			this.scanner.close();
		}
	
		catch (IOException exc) {
			System.out.println("File Assente");
		}
	}

	private double[] parteImmaginaria = new double[1000000];
	private Scanner scanner;

	public double[] getParteReale() {
		return this.parteReale;
	}

	public double[] getParteImmaginaria() {
		return this.parteImmaginaria;
	}
	
	// messo in Energy Detector
	
//	public double[][] dividiInBlocchi(double[] sequenza, int numeroBlocchi, int numeroCampioni) {
//		double[][] sequenzaInBlocchi = new double[numeroBlocchi][numeroCampioni];
//		int k = 0;   // per iterare sulla sequenza passata per parametro
//		for(int i = 0; i < numeroBlocchi; i++) {
//			for(int j = 0; j < numeroCampioni; j++) {
//				sequenzaInBlocchi[i][j] = sequenza[k];
//				k++;
//			}
//		}
//		return sequenzaInBlocchi;
//	}
//	
}

//creiamo 1000 sequenze da 1000 campioni
//out 1 = -3
//out 2 =  2 
//out 3 = -8
//out 4 = -13

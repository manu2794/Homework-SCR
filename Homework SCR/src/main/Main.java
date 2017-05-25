package main;

import java.io.IOException;
import java.util.Scanner;

import energyDetector.EnergyDetector;


public class Main {

	public static void main(String[] args) throws IOException {

		// valore SNR disponibili -13, -8, -5, +2
		// prendo da tastiera il valore dell'SNR selezionato
		System.out.println("Inserire un valore per l'SNR, scegliendo fra: -13, -8, -5, +2");
		Scanner scannerSNR = new Scanner(System.in);
		double valoreSNR = scannerSNR.nextDouble();

		// prendo da tastiera la sequenza selezionata
		System.out.println("Selezionare la sequenza, scegliendo fra: 1, 2, 3");
		Scanner scannerSequenza = new Scanner(System.in);
		int sequenzaScelta = scannerSequenza.nextInt();

		//dico all'EnergyDetector di verificare la presenza del PU
		EnergyDetector ed = new EnergyDetector();	
		ed.verificaPresenzaPU(valoreSNR, sequenzaScelta); 

		scannerSequenza.close();
		scannerSNR.close();
	}
}


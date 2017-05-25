package processamentoSequenze;

public class CalcolatorePotenzeSegnali {

	public double calcolaPotenzaSegnale(double[] parteReale, double[] parteImmaginaria) {
		double potenza, prodottoReale, prodottoImmaginario,	sommaProdotti = 0;
		double lunghezza = parteReale.length;					//potevo anche fare parteImmaginaria.length, tanto ogni campione è una coppia di Re e Im
		double normalizzatore = 1/lunghezza;
		for(int i = 0; i < lunghezza; i++) {
			prodottoReale = Math.pow(parteReale[i], 2);
			prodottoImmaginario = Math.pow(parteImmaginaria[i], 2);
			sommaProdotti += prodottoReale + prodottoImmaginario;		
		}
		potenza = normalizzatore * sommaProdotti;
		return potenza; 
	}
}

package no.hib.dat102.datakontaktfirma;

public class Klient {

	public static void main(String[] args) {
		
		DataKontakt dk = new DataKontakt(4);
		Meny meny = new Meny(dk);
		meny.start();
		
	}

}

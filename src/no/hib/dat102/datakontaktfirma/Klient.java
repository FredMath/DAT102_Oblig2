package no.hib.dat102.datakontaktfirma;

public class Klient {

	public static void main(String[] args) {
		
		DataKontakt dk = new DataKontakt(4);
		Hobby h1 = new Hobby("Fisking");
		Hobby h2 = new Hobby("Bowling");
		Medlem m1 = new Medlem("Geir");
		Medlem m2 = new Medlem("Atle");
		Medlem m3 = new Medlem("Leif");
		Medlem m4 = new Medlem("Anna");
		
		m1.leggTilHobby(h1);
		m2.leggTilHobby(h1);
		m3.leggTilHobby(h1);
		m2.leggTilHobby(h2);
		m3.leggTilHobby(h2);
		m4.leggTilHobby(h1);
		
		dk.leggTilMedlem(m1);
		dk.leggTilMedlem(m2);
		dk.leggTilMedlem(m3);
		dk.leggTilMedlem(m4);
		
		dk.finnPartnere();
		
		Tekstgrensesnitt.skrivParListe(dk);
		
	}

}

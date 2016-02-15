package no.hib.dat102.datakontaktfirma;

import java.util.Iterator;

import no.hib.dat102.mengde.tabell.TabellIterator;

class DataKontakt {

	Medlem[] medlemsListe;
	int antall;

	public DataKontakt(int antall) {

		medlemsListe = new Medlem[antall];
		antall = 0;

	}

	public boolean leggTilMedlem(Medlem medlem) {

		boolean suksess = false;

		if (!inneholder(medlem)) {
			medlemsListe[antall] = medlem;
			antall++;
			suksess = true;
		}

		return suksess;
	}

	public int finnMedlemsIndex(String navn) {

		int index = -1;

		for (int i = 0; i < antall; i++) {
			if (medlemsListe[i].getNavn().equals(navn)) {
				index = i;
				break;
			}
		}

		return index;
	}

	public int finnPartnerFor(String navn) {

		int medlemsIndex = finnMedlemsIndex(navn);
		int partnerIndex = -1;

		// Sjekker om medlemmet allerede har en partner
		if (medlemsListe[medlemsIndex].getStatusIndex() != -1) {

			partnerIndex = medlemsListe[medlemsIndex].getStatusIndex();

		} else { // ...hvis ikke -> finner partner og oppdaterer status

			for (int i = 0; i < antall && i != medlemsIndex; i++) {
				if (medlemsListe[i].getStatusIndex() == -1 && medlemsListe[medlemsIndex].passerTil(medlemsListe[i])) {

					partnerIndex = i;
					medlemsListe[medlemsIndex].setStatusIndex(partnerIndex);
					medlemsListe[partnerIndex].setStatusIndex(medlemsIndex);

					break;
				}
			}
		}

		return partnerIndex;

	}

	public void tilbakestillStatusIndex(String navn) {

		int medlemsIndex = finnMedlemsIndex(navn);

		if (medlemsListe[medlemsIndex].getStatusIndex() != -1) {

			medlemsListe[medlemsListe[medlemsIndex].getStatusIndex()].setStatusIndex(-1);
			medlemsListe[medlemsIndex].setStatusIndex(-1);

		}

	}
	
	public MedlemsPar[] finnPar(){
		MedlemsPar[] mp = new MedlemsPar[antall/2+1];
		
		for(int i = 0; i < antall; i++){
			for(int j = 0; j < antall && j != i; j++){
				
			}
		}
		
		return mp;
	}

	public Iterator<Medlem> oppramser() {
		return new TabellIterator<Medlem>(medlemsListe, antall);
	}

	private boolean inneholder(Medlem medlem) {

		boolean inneholder = false;

		for (int i = 0; i < antall; i++) {

			if (medlemsListe[i].equals(medlem)) {
				inneholder = true;
				break;
			}
			
		}

		return inneholder;
	}

	// GET
	public int getAntall() {
		return antall;
	}

}

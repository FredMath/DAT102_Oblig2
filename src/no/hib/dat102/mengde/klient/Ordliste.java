package no.hib.dat102.mengde.klient;

import no.hib.dat102.mengde.tabell.TabellMengde;
import java.util.Scanner;

public class Ordliste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TabellMengde<String> ordListe1 = new TabellMengde<String>();

		String[] ord = { "God", "dag", "Hans", "Hansen", "Hansaby", "Olsen", "Ole", "buss", "rute", "Bergen" };

		Scanner tastatur = new Scanner(System.in);
		// Legger til ordene i mengden ordListe1

		for (int i = 0; i < ord.length; i++) {
			ordListe1.leggTil(ord[i]);
		}
		TabellMengde<String> ordListe2 = new TabellMengde<String>();

		System.out.print("Oppgi en streng, avslutt med zzz :");
		String streng = tastatur.nextLine();
		// Leser inn ord
		while (!streng.equals("zzz")) {

			ordListe2.leggTil(streng);

			System.out.print("Oppgi en streng, avslutt med zzz :");
			streng = tastatur.nextLine();
		}
		tastatur.close();

		// Lager unionen av de to ordlistene
		TabellMengde<String> ordListeBegge = new TabellMengde<String>();
		ordListeBegge = (TabellMengde<String>) ordListe1.union(ordListe2);
		System.out.println("Utskrift av unionen av begge ordlistene");
		while(!ordListeBegge.erTom()){
			System.out.println(ordListeBegge.fjernTilfeldig());
		}
		
		
		// Snittet av tabellene
		System.out.println("\nSnittet av tabellene:");
		TabellMengde<String> ordListeSnitt = new TabellMengde<String>();
		ordListeSnitt = (TabellMengde<String>) ordListe1.snitt(ordListe2);
		while(!ordListeSnitt.erTom()){
			System.out.println(ordListeSnitt.fjernTilfeldig());
		}
		
		
		// Differansen av tabellene
		System.out.println("\nDifferansen av tabellene:");
		TabellMengde<String> ordListeDifferanse = (TabellMengde<String>) ordListe1.differens(ordListe2);
		while(!ordListeDifferanse.erTom()){
			System.out.println(ordListeDifferanse.fjernTilfeldig());
		}
		

		// ... Fyll ut

		/*
		 * // Lager snittet av de to ordlistene KjedetMengde<String>
		 * ordListeFelles = new KjedetMengde<String>(); ordListeFelles =
		 * (KjedetMengde<String>) ordListe1.snitt(ordListe2);
		 * System.out.println("Utskrift av snittet av begge ordlistene"); //
		 * ...Fyll ut
		 * 
		 * // Lager differansen av de to ordlistene KjedetMengde<String>
		 * ordListeDiff = new KjedetMengde<String>(); ordListeDiff =
		 * (KjedetMengde<String>) ordListe1.differens(ordListe2);
		 * System.out.println("Utskrift av differansen av begge ordlistene");
		 * 
		 * // ....
		 */

	}
}

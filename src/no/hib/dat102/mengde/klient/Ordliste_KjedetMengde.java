package no.hib.dat102.mengde.klient;

import no.hib.dat102.mengde.kjedet.KjedetMengde;
import java.util.Scanner;

public class Ordliste_KjedetMengde {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		KjedetMengde<String> ordListe1 = new KjedetMengde<String>();

		String[] ord = { "God", "dag", "Hans", "Hansen", "Hansaby", "Olsen", "Ole", "buss", "rute", "Bergen" };

		Scanner tastatur = new Scanner(System.in);
		// Legger til ordene i mengden ordListe1

		for (int i = 0; i < ord.length; i++) {
			ordListe1.leggTil(ord[i]);
		}
		KjedetMengde<String> ordListe2 = new KjedetMengde<String>();

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
		KjedetMengde<String> ordListeBegge = new KjedetMengde<String>();
		ordListeBegge = (KjedetMengde<String>) ordListe1.union(ordListe2);
		System.out.println("Utskrift av unionen av begge ordlistene");

		while(!ordListeBegge.erTom()){
			System.out.println(ordListeBegge.fjernTilfeldig());
		}

		// Snittet av tabellene
		System.out.println("\nSnittet av tabellene:");
		KjedetMengde<String> ordListeSnitt = new KjedetMengde<String>();
		ordListeSnitt = (KjedetMengde<String>)ordListe1.snitt(ordListe2);
		while(!ordListeSnitt.erTom()){
			System.out.println(ordListeSnitt.fjernTilfeldig());
		}

		// Differansen av tabellene
		System.out.println("\nDifferansen av tabellene:");
		KjedetMengde<String> ordListeDifferanse = (KjedetMengde<String>) ordListe1.differens(ordListe2);
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

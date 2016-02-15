package no.hib.dat102.datakontaktfirma;

import java.util.Scanner;

public class Tekstgrensesnitt {

	public static final Scanner SCANNER = new Scanner(System.in);
	
	public static Medlem lesMedlem(){
		
		System.out.println("Skriv inn navnet på medlemmet du vil legge til: ");
		String navn = SCANNER.nextLine();
		
		return new Medlem(navn);	
	}
	
	public static void skrivHobbyer(Medlem medlem){
		
		System.out.println("Hobbyer til " + medlem.getNavn() + ":");
		System.out.println(medlem.getHobbyer());
		
	}
	
	public static void skrivParListe(DataKontakt arkiv){
		
		// Finn par
		
		
		System.out.println("PARNAVN\t\tHOBBYER");
		
		
		
	}
}








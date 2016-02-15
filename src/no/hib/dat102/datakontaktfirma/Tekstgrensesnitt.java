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
		
		MedlemsPar[] mp = arkiv.finnPar();
		
		System.out.println("Antall par: " + mp.length);
		System.out.println("PARNAVN\t\tHOBBYER");
		for(MedlemsPar m : mp){
			System.out.print(m.toString() + "\t\t");
			System.out.println(m.getHobbyer());
		}
		
		
	}
}








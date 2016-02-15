package no.hib.dat102.datakontaktfirma;

public class Hobby {

	// Objektvariabler
	private String hobbyNavn;
	
	
	// Kontruktører
	public Hobby(String hobbyNavn){
		this.hobbyNavn = hobbyNavn;
	}
	
	
	
	// Metoder
	@Override
	public String toString(){
		
		String s = "<";
		s += hobbyNavn + ">";
		// Returneres i format '<Fugletitting>', eller '<Hoppe på trampoline>'.
		
		return s;
	}
	
	@Override
	public boolean equals(Object h2){
		
		return this.toString().equals(h2.toString());
	}
	
	
	
	
	
	
	
	
	// Getters / setters
	
	
}
















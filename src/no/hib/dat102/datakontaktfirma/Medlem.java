package no.hib.dat102.datakontaktfirma;

import java.util.Iterator;

import no.hib.dat102.mengde.adt.MengdeADT;
import no.hib.dat102.mengde.kjedet.KjedetMengde;

public class Medlem {

	// Objektvariabler
	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndex;
	
	
	// Konstruktører
	public Medlem(String navn){
		this.navn = navn;
		hobbyer = new KjedetMengde<Hobby>();
		statusIndex = -1;
	}
	
	
	
	
	
	// Metoder
	public void leggTilHobby(Hobby hobby){
		hobbyer.leggTil(hobby);
	}
	
	public void fjernHobby(Hobby hobby){
		hobbyer.fjern(hobby);
	}
	
	public String getHobbyer(){
		
		String s = "";
		
		Iterator<Hobby> i = hobbyer.oppramser();
		while(i.hasNext()){
			s += i.next().toString();
		}
		
		return s;
	}
	
	public boolean passerTil(Medlem medlem2){
		return hobbyer.erLik(medlem2.hobbyer);
	}
	
	
	@Override
	public String toString(){
		return getHobbyer();
	}
	
	@Override
	public boolean equals(Object m2){
		if(this == m2){ return true; }
		if(m2 == null){ return false; }
		if(!(m2 instanceof Medlem)){ return false; }
		
		Medlem medlem2 = (Medlem) m2;
		return this.navn.equals(medlem2.getNavn());
		
	}
	
	
	
	// Getters / setters
	public String getNavn() { return navn; }
	
	public int getStatusIndex() { return statusIndex; }
	public void setStatusIndex(int statusIndex) { this.statusIndex = statusIndex; }
	
	
}















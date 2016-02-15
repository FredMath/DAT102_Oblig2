package no.hib.dat102.mengde.kjedet;

import no.hib.dat102.mengde.adt.*;
import java.util.*;

//********************************************************************
//Kjedet implementasjon av en mengde. 
//********************************************************************

public class KjedetMengde<T> implements MengdeADT<T> {
	private static Random rand = new Random();
	private int antall; // antall elementer i mengden
	private LinearNode<T> start;

	/**
	 * Oppretter en tom mengde.
	 */
	public KjedetMengde() {
		antall = 0;
		start = null;
	}//

	@Override
	public void leggTil(T element) {
		if (!(inneholder(element))) {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNeste(start);
			start = node;
			antall++;
		}
	}

	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			leggTil(teller.next());
		}
	}

	@Override
	public T fjernTilfeldig() {
		LinearNode<T> forgjenger, aktuell;
		T resultat = null;
		if (!erTom()) {
			int valg = rand.nextInt(antall) + 1;
			if (valg == 1) {
				resultat = start.getElement();
				start = start.getNeste();
			} else {
				forgjenger = start;
				for (int nr = 2; nr < valg; nr++) {
					forgjenger = forgjenger.getNeste();
				}
				aktuell = forgjenger.getNeste();
				resultat = aktuell.getElement();
				forgjenger.setNeste(aktuell.getNeste());
			}
			antall--;
		} // if
		return resultat;
	}//

	@Override
	public T fjern(T element) {
		boolean funnet = false;
		LinearNode<T> forgjenger, aktuell = null;
		T resultat = null;

		if (!erTom()) {

			// Sjekk om det er den første
			if (start.getElement().equals(element)) {
				resultat = start.getElement();
				start = start.getNeste();
				funnet = true;
			}

			// Dersom det ikke er den første
			if (!funnet) {
				forgjenger = start;
				aktuell = start.getNeste();

				while (!funnet && aktuell != null) {

					if (aktuell.getElement().equals(element)) {
						funnet = true;
					} else {
						forgjenger = aktuell;
						aktuell = aktuell.getNeste();
					}
				}

				// Dersom det er funnet en match
				if (funnet) {
					forgjenger.setNeste(aktuell.getNeste());
					resultat = aktuell.getElement();
				}

			}

		}

		return resultat;
	}//

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {// OBS! En bedre i kladdeopg4
		KjedetMengde<T> begge = new KjedetMengde<T>();
		LinearNode<T> aktuell = start;
		while (aktuell != null) {
			begge.leggTil(aktuell.getElement());
			aktuell = aktuell.getNeste();
		} // while
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			begge.leggTil(teller.next());
		}
		return begge;
	}//
	
	public MengdeADT<T> bedreUnion(MengdeADT<T> m2){
		
		KjedetMengde<T> begge = new KjedetMengde<T>();
		
		Iterator<T> i1 = oppramser();
		
		T next1;
		while(i1.hasNext()){
			next1 = i1.next();
			begge.settInn(next1);
		}
		
		Iterator<T> i = m2.oppramser();
		
		T next;
		while(i.hasNext()){
			next = i.next();
			
			if(!inneholder(next)){
				begge.settInn(next);
			}
		}
		
		return begge;
		
	}
	
	@Override
	public KjedetMengde<T> clone(){
		try {
			return (KjedetMengde<T>)super.clone();
		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
			return null;
		}
	}

	private void settInn(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		LinearNode<T> aktuell = start;
		for (int sok = 0; sok < antall && !funnet; sok++) {
			if (aktuell.getElement().equals(element)) {
				funnet = true;
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		return funnet;
	}

	@Override
	public boolean erLik(MengdeADT<T> m2) {
		boolean likeMengder = true;
		
		Iterator<T> i = oppramser();
		
		while(i.hasNext()){
			if(!m2.inneholder(i.next())){
				likeMengder = false;
				break;
			}
		}
		
		return likeMengder;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public Iterator<T> oppramser() {
		return new KjedetIterator<T>(start);
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		KjedetMengde<T> snittetMengde = new KjedetMengde<T>();
		
		Iterator<T> i = oppramser();
		T neste;
		
		while(i.hasNext()){
			
			neste = i.next();
			if(m2.inneholder(neste)){
				snittetMengde.settInn(neste);
			}
			
		}
		
		return snittetMengde;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> begge = union(m2);
		MengdeADT<T> snitt = snitt(m2);
		KjedetMengde<T> diff = new KjedetMengde<T>();
		
		Iterator<T> i = begge.oppramser();
		while(i.hasNext()){
			T neste = i.next();
			if(!snitt.inneholder(neste)){
				diff.settInn(neste);
			}
		}
		
		return diff;
	}
	
	@Override
	public String toString(){
		
		String s = "";
		
		Iterator<T> i = oppramser();
		while(i.hasNext()){
			s += i.next().toString() + "\t";
		}
		
		return s;
		
	}

}// class











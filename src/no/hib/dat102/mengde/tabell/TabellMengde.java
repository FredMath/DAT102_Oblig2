package no.hib.dat102.mengde.tabell;

import no.hib.dat102.mengde.adt.*;
import java.util.Iterator;
import java.util.Random;

public class TabellMengde<T> implements MengdeADT<T> {
	// ADT-en Mengde implementert som tabell
	//
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	@SuppressWarnings("unchecked")
	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}

	@SuppressWarnings("unchecked")
	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		T svar = null;
		if (antall > 0) {
			int indeks = tilf.nextInt(antall);
			svar = tab[indeks];
			tab[indeks] = tab[antall - 1];
			antall--;
		}
		return svar;
	}

	@Override
	public T fjern(T element) {
		T svar = null;

		for (int i = 0; i < antall; i++) {
			if (tab[i].equals(element)) {
				svar = element;
				antall--;
				tab[i] = tab[antall];
			}
		}

		return svar;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		TabellMengde<T> begge = new TabellMengde<T>();
		for (int i = 0; i < antall; i++) {
			begge.leggTil(tab[i]);
		}
		Iterator<T> teller = m2.oppramser();

		while (teller.hasNext()) {
			begge.leggTil(teller.next());
		}

		return begge;
	}
	
	public MengdeADT<T> bedreUnion(MengdeADT<T> m2){
		
		TabellMengde<T> begge = new TabellMengde<T>();
		
		Iterator<T> i1 = oppramser();
		
		T next1;
		while(i1.hasNext()){
			next1 = i1.next();
			begge.settInn(next1);
		}
		
		Iterator<T> teller = m2.oppramser();

		T next;
		while (teller.hasNext()) {
			next = teller.next();
			
			// Sjekker om den finnes i den originale samlingen, 
			// istedetfor den som hele tiden blir oppdatert og blir større.
			if(!inneholder(next)){
				begge.settInn(next);
			}
		}
		
		return begge;
	}

	private void settInn(T element) {
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}

	@Override
	public boolean inneholder(T element) {
		int pos = -1;
		for (int i = 0; (i < antall) && (pos == -1); i++) {
			if (tab[i].equals(element))
				pos = i;
		}
		return (pos != -1);
	}

	@Override
	public boolean erLik(MengdeADT<T> m2) {
		boolean likeMengder = true;

		if (antall == m2.antall()) {

			Iterator<T> i = oppramser();

			while (i.hasNext() && likeMengder) {
				likeMengder = inneholder(i.next());
			}

		} else {
			likeMengder = false;
		}

		return likeMengder;
	}

	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext())
			leggTil(teller.next());
	}

	@Override
	public Iterator<T> oppramser() {
		return new TabellIterator<T>(tab, antall);
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {

		TabellMengde<T> snittetMengde = new TabellMengde<T>();

		Iterator<T> i = oppramser();

		T neste;
		while (i.hasNext()) {

			neste = i.next();
			if (m2.inneholder(neste)) {
				snittetMengde.settInn(neste);
			}
		}

		return snittetMengde;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		
		MengdeADT<T> begge = union(m2);
		MengdeADT<T> snitt = snitt(m2);
		TabellMengde<T> diff = new TabellMengde<T>();
		
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
		
		for(int i = 0; i < antall; i++){
			s += tab[i].toString() + "\t";
		}
		
		return s;
	}

}// class







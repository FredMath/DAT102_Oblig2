package no.hib.dat102.mengde.Test;

import static org.junit.Assert.*;
import org.junit.*;
import no.hib.dat102.mengde.kjedet.KjedetMengde;
import no.hib.dat102.mengde.tabell.TabellMengde;

public class TestMengdeADT {

	
	TabellMengde<String> tMengde1;
	TabellMengde<String> tMengde2;
	KjedetMengde<String> kMengde1;
	KjedetMengde<String> kMengde2;
	String s1[] = {"hei","mitt","navn","er","roger"};
	String s2[] = {"hei","navn","kjetil"};
	
	@Before
	public void setup(){
		tMengde1 = new TabellMengde<String>();
		for(int i = 0; i < s1.length; i++){
			tMengde1.leggTil(s1[i]);
		}
		tMengde2 = new TabellMengde<String>();
		for(int i = 0; i < s2.length; i++){
			tMengde2.leggTil(s2[i]);
		}
		
		kMengde1 = new KjedetMengde<String>();
		for(int i = 0; i < s1.length; i++){
			kMengde1.leggTil(s1[i]);
		}
		kMengde2 = new KjedetMengde<String>();
		for(int i = 0; i < s2.length; i++){
			kMengde2.leggTil(s2[i]);
		}
	}
	
	@After
	public void cleanUp(){
		tMengde1 = null;
		tMengde2 = null;
		kMengde1 = null;
		kMengde2 = null;
	}
	
	// Tester for union, snitt, og differens
	
	@Test
	public void testTabellUnion(){
		TabellMengde<String> tUnion = new TabellMengde<String>();
		tUnion.leggTil("hei");
		tUnion.leggTil("mitt");
		tUnion.leggTil("navn");
		tUnion.leggTil("er");
		tUnion.leggTil("roger");
		tUnion.leggTil("kjetil");
		
		assertTrue(tUnion.erLik(tMengde1.union(tMengde2)));
	}
	
	@Test
	public void testTabellSnitt(){
		TabellMengde<String> tSnitt = new TabellMengde<String>();
		tSnitt.leggTil("hei");
		tSnitt.leggTil("navn");
		
		assertTrue(tSnitt.erLik(tMengde1.snitt(tMengde2)));
	}
	
	@Test
	public void testTabellDifferens(){
		TabellMengde<String> tDifferens = new TabellMengde<String>();
		tDifferens.leggTil("mitt");
		tDifferens.leggTil("er");
		tDifferens.leggTil("roger");
		tDifferens.leggTil("kjetil");
		
		assertTrue(tDifferens.erLik(tMengde1.differens(tMengde2)));
	}
	
	
	@Test
	public void testKjedetUnion(){
		KjedetMengde<String> kUnion = new KjedetMengde<String>();
		kUnion.leggTil("hei");
		kUnion.leggTil("mitt");
		kUnion.leggTil("navn");
		kUnion.leggTil("er");
		kUnion.leggTil("roger");
		kUnion.leggTil("kjetil");
		
		assertTrue(kUnion.erLik(kMengde1.union(kMengde2)));
	}
	
	@Test
	public void testKjedetSnitt(){
		KjedetMengde<String> kSnitt = new KjedetMengde<String>();
		kSnitt.leggTil("hei");
		kSnitt.leggTil("navn");
		
		assertTrue(kSnitt.erLik(kMengde1.snitt(kMengde2)));
	}
	
	@Test
	public void testKjedetDifferens(){
		KjedetMengde<String> kDifferens = new KjedetMengde<String>();
		kDifferens.leggTil("mitt");
		kDifferens.leggTil("er");
		kDifferens.leggTil("roger");
		kDifferens.leggTil("kjetil");
		
		assertTrue(kDifferens.erLik(kMengde1.differens(kMengde2)));
	}
	
	@Test
	public void testTabellBedreUnion(){
		
		TabellMengde<String> tUnion = new TabellMengde<String>();
		tUnion.leggTil("hei");
		tUnion.leggTil("mitt");
		tUnion.leggTil("navn");
		tUnion.leggTil("er");
		tUnion.leggTil("roger");
		tUnion.leggTil("kjetil");
		
		
		System.out.println("Tester forbedret union-metode på tabell-mengde:");
		
		long delta1 = System.nanoTime();
		assertTrue(tUnion.erLik(tMengde1.bedreUnion(tMengde2)));
		long elapsed1 = System.nanoTime() - delta1;
		
		long delta2 = System.nanoTime();
		assertTrue(tUnion.erLik(tMengde1.union(tMengde2)));
		long elapsed2 = System.nanoTime() - delta2;
		
		System.out.println("Gamle union: \t" + elapsed1 + "\nNy union: \t" + elapsed2);
		int forskjell = (int)(100-(elapsed2/(elapsed1/100)));
		System.out.println("Forskjell: \t" + forskjell + "%");
		if(forskjell > 0){
			System.out.println("Den nye union-metoden gjorde det bedre enn den gamle!");
		} else if(forskjell < 0){
			System.out.println("Den gamle union-metoden gjorde det bedre enn den nye!");
		} else {
			System.out.println("Den nye union-metoden brukte like lang tid som den gamle!");
		}
		
		System.out.println();
		
	}
	
	@Test
	public void testKjedetBedreUnion(){
		
		KjedetMengde<String> kUnion = new KjedetMengde<String>();
		kUnion.leggTil("hei");
		kUnion.leggTil("mitt");
		kUnion.leggTil("navn");
		kUnion.leggTil("er");
		kUnion.leggTil("roger");
		kUnion.leggTil("kjetil");
		
		
		System.out.println("Tester forbedret union-metode på kjedet mengde:");
		
		long delta2 = System.nanoTime();
		assertTrue(kUnion.erLik(kMengde1.union(kMengde2)));
		long elapsed2 = System.nanoTime() - delta2;
		
		long delta1 = System.nanoTime();
		assertTrue(kUnion.erLik(kMengde1.bedreUnion(kMengde2)));
		long elapsed1 = System.nanoTime() - delta1;
		
		System.out.println("Gamle union: \t" + elapsed1 + "\nNy union: \t" + elapsed2);
		int forskjell = (int)(100-(elapsed2/(elapsed1/100)));
		System.out.println("Forskjell: \t" + forskjell + "%");
		if(forskjell > 0){
			System.out.println("Den nye union-metoden gjorde det bedre enn den gamle!");
		} else if(forskjell < 0){
			System.out.println("Den gamle union-metoden gjorde det bedre enn den nye!");
		} else {
			System.out.println("Den nye union-metoden brukte like lang tid som den gamle!");
		}
		
		System.out.println();
		
	}
	
	@Test
	public void testTabellToString(){
		String fasit = "hei\tnavn\tkjetil\t";
		assertTrue(tMengde2.toString().equals(fasit));
	}
	
	@Test
	public void testKjedetToString(){
		String fasit = "kjetil\tnavn\thei\t";
		assertTrue(kMengde2.toString().equals(fasit));
	}
	
}







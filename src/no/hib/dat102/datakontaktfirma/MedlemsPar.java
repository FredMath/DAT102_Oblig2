package no.hib.dat102.datakontaktfirma;

public class MedlemsPar {
	
	Medlem[] par;
	
	public MedlemsPar(Medlem m1, Medlem m2){
		par = new Medlem[2];
		par[0] = m1;
		par[1] = m2;
	}
	
	public boolean erSamme(MedlemsPar mp){
		
		boolean like = false;
		Medlem[] mpar = mp.getPar();
		if((mpar[0]==par[0] && mpar[1]==par[1]) || 
		   (mpar[1]==par[0] && mpar[0]==par[1])){
			
			like = true;
		}
		
		return like;
	}
	
	@Override
	public String toString(){
		return "<" + par[0].getNavn() + " og " + par[1].getNavn() + ">";
	}
	
	public String getHobbyer(){
		return par[0].getHobbyer();
	}
	
	public Medlem[] getPar(){
		return par;
	}
	
	
	
}

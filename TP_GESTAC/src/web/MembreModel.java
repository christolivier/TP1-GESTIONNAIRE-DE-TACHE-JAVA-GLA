package web;
import java.util.ArrayList;
import java.util.List;
import metier.entities.Membre;
public class MembreModel {
	private int motcle;
	private ArrayList<Membre> membre=new ArrayList<Membre>();
	public int getMotcle() {
		return motcle;
	}
	public void setMotcle(int motcle) {
		this.motcle = motcle;
	}
	public ArrayList<Membre> getMembre() {
		return membre;
	}
	public void setMembre(ArrayList<Membre> membre) {
		this.membre = membre;
	}	
}



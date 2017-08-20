package web;
import java.util.ArrayList;
import metier.entities.Tache;
import metier.entities.Membre;
public class TacheModelEditDelete {
	private String motcletache;
	private ArrayList<Tache> taches=new  ArrayList<Tache>();
	public String getMotcletache() {
		return motcletache;
	}
	public void setMotcletache(String motcletache) {
		this.motcletache = motcletache;
	}
	public ArrayList<Tache> getTaches() {
		return taches;
	}
	public void setTaches(ArrayList<Tache> taches) {
		this.taches = taches;
	}
}


	

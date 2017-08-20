package web;
import java.util.ArrayList;
import metier.entities.Membre;
public class MembreModelEditDelete {
	private String motcle;
	private ArrayList<Membre> membre=new ArrayList<>();
	public String getMotcle() {
		return motcle;
	}
	public void setMotcle(String motcle) {
		this.motcle = motcle;
	}
	public ArrayList<Membre> getMembre() {
		return membre;
	}
	public void setMembre(ArrayList<Membre> membre) {
		this.membre = membre;
	}
}



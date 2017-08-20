package web;
import java.util.ArrayList;
import metier.entities.Tache;
public class TacheParStatut{
	String motcletacheps;
	private ArrayList<Tache> taches=new  ArrayList<Tache>();
	public String getMotcletacheps() {
		return motcletacheps;
	}
	public void setMotcletacheps(String motcletacheps) {
		this.motcletacheps = motcletacheps;
	}
	public ArrayList<Tache> getTaches() {
		return taches;
	}
	public void setTaches(ArrayList<Tache> taches) {
		this.taches = taches;
	}
}
package web;
import java.util.ArrayList;
import metier.entities.Tache;
public class TacheModel {
	private int idmembre;
	private ArrayList<Tache> tache=new ArrayList<Tache>();
	public int getIdmembre() {
		return idmembre;
	}
	public void setIdmembre(int idmembre) {
		this.idmembre = idmembre;
	}
	public ArrayList<Tache> getTache() {
		return tache;
	}
	public void setTache(ArrayList<Tache> tache) {
		this.tache = tache;
	}
	}
	





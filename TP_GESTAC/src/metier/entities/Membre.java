package metier.entities;
import java.io.Serializable;
public class Membre implements Serializable {
	private int id;
	private String nom;
	public Membre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Membre(String nom) {
		super();
		this.nom = nom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "Membre [id=" + id + ", nom=" + nom + "]";
	}
}
 
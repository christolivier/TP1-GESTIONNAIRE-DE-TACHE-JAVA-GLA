package metier.entities;

import java.io.Serializable;

public class Tache implements Serializable {

	private int id;
	private String nom;
	private String description;
	private String statut;
	private int mem_fk;
	private String membre;
	public Tache() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tache(String nom, String description, String statut, int mem_fk) {
		super();
		this.nom = nom;
		this.description = description;
		this.statut = statut;
		this.mem_fk = mem_fk;
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
	public String getMembre() {
		return membre;
	}
	public void setMembre(String membre) {
		this.membre = membre;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public int getMem_fk() {
		return mem_fk;
	}
	public void setMem_fk(int mem_fk) {
		this.mem_fk = mem_fk;
	}
	@Override
	public String toString() {
		return "Tache [id=" + id + ", nom=" + nom + ", description=" + description + ", statut=" + statut + ", mem_fk="
				+ mem_fk + "]";
	}
}	
 
package dao;

import java.util.List;

import metier.entities.Membre;
import metier.entities.Tache;


public class testDao {

	public static void main(String[] args) {
		TacheDaoImplementation dao=new TacheDaoImplementation();
		Tache t6=dao.save(new Tache("PROJET", "developper une appli ki gere l'emploi du temps ", "debut",3));
		
		System.out.println(t6.toString());
		
		/*MembreDaoImplementation dao=new MembreDaoImplementation();
		Membre m12=dao.save(new Membre("aboubacar sani"));
		System.out.println(m12.toString());
		System.out.println("chercher des membres");
		List<Membre> mem=dao.membresparMC("%K%");
		for(Membre m:mem){
			System.out.println(m.toString());
			
		}*/
		
		
		System.out.println("chercher des taches");
		List<Tache> taches=dao.tacheparMC("%D%");
		for(Tache t:taches){
			System.out.println(t.toString());
			
		}

	}

}

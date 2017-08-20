package dao;

import java.util.List;

import metier.entities.Tache;




public class testtacheDao {

	public static void main(String[] args) {
		
		TacheDaoImplementation dao=new TacheDaoImplementation(); 
		Tache t1 =dao.save(new Tache("epicure", "saisir messe", "nouveau", 9));	
		System.out.println(t1.toString());
		System.out.println("chercher des tache");
		
		List<Tache> tac=dao.tacheparMC("%E%");
		for(Tache t:tac){
			System.out.println(t.toString());
			
		}

		}

	}



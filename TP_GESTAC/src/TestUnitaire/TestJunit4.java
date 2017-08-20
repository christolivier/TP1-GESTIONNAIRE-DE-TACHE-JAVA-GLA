package TestUnitaire;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import dao.TacheDaoImplementation;

import dao.MembreDaoImplementation;
import metier.entities.Membre;
import metier.entities.Tache;

public class TestJunit4 {
	@Test
	public void testajoutertache()
	{	
		TacheDaoImplementation dao=new TacheDaoImplementation();
		Tache t8 =dao.save(new Tache("PROJET", "Developper une application de gestion d'emploi de temps ", "en cours",3));
		System.out.println(t8.toString());	
	}
	@Test
	public void TestAfficherTacheParMotclé(){
		TacheDaoImplementation dao=new TacheDaoImplementation();
	
		System.out.println("chercher des taches");
		List<Tache> taches=dao.tacheparMC("%D%");
		for(Tache t:taches){
			System.out.println(t.toString());
		}
	}
	
	@Test
	public void TestAjouterMembre(){
		
		MembreDaoImplementation dao=new MembreDaoImplementation();
		Membre m12=dao.save(new Membre("aboubacar sani"));
		System.out.println(m12.toString());
		System.out.println("chercher des membres");
		List<Membre> mem=dao.tousmembresparMC("%K%");
		for(Membre m:mem){
			System.out.println(m.toString());
			
		}
	}
	
	
}

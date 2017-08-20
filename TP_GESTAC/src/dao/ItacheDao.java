package dao;
import java.util.ArrayList;
import metier.entities.Membre;
import metier.entities.Tache;
public interface ItacheDao {
	public Tache save(Tache t);
	public ArrayList<Tache> tacheparMC(String mc);
	public ArrayList<Tache> getListTachebyIdMembre(int idmembre);
	public Tache updateTache (Tache t);
	public void deleteTache(int id);	
	public ArrayList<Membre> tousmembresparMC(String mced);
	public Membre getMembre(int id);
	public Tache getTache(int id);
	public ArrayList<Tache> TacheParStatut(String tps);	
}

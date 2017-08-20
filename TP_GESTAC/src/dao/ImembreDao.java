package dao;
import java.util.ArrayList;
import metier.entities.Membre;
public interface ImembreDao {
	public ArrayList<Membre> membresearch(String ms) ;
	public Membre save(Membre m);
	public ArrayList<Membre> membresparMC(int mc);
	public ArrayList<Membre> tousmembresparMC(String mced);
	public Membre getMembre(int id);
	public Membre updateMembre (Membre m);
	public void deleteMembre(int id);
	public ArrayList<Membre> getListMembre();
}

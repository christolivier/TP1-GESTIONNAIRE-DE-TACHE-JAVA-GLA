package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import metier.entities.Membre;
import metier.entities.Tache;

public class TacheDaoImplementation implements ItacheDao {

	@Override
	public Tache save(Tache t) {
	Connection connection=singletonconnection.getConnection();
	try {
		PreparedStatement ps =connection.prepareStatement
				
		("INSERT INTO TACHE (NOM_TAC,DESCRIPTION,STATUT,MEM_fk) VALUES (?,?,?,?)");
		ps.setString(1, t.getNom());
		ps.setString(2, t.getDescription());
		ps.setString(3, t.getStatut());
		ps.setInt(4, t.getMem_fk());
		ps.executeUpdate();
		PreparedStatement ps2=connection.prepareStatement
				("SELECT MAX(ID) AS MAX_ID FROM TACHE");
		ResultSet rs=ps2.executeQuery();
		if(rs.next()){
			t.setId(rs.getInt("MAX_ID"));
		}
		ps.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return t;
	}
//////////////////////////////////////////////////////////////////////////////////
///// recherche globale
/////////////////////////////////////////////////////	
	@Override
	public ArrayList<Tache> tacheparMC(String mc) {
		ArrayList<Tache> tache =new ArrayList<Tache>();
		Connection connection=singletonconnection.getConnection();
		try {
			PreparedStatement ps =connection.prepareStatement
					("SELECT * FROM TACHE WHERE NOM_TAC LIKE ?");
			ps.setString(1, mc);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Tache t=new Tache();
			    t.setId(rs.getInt("ID"));
			    t.setNom(rs.getString("NOM_TAC"));
			    t.setDescription(rs.getString("DESCRIPTION"));
			    t.setStatut(rs.getString("STATUT"));
			    t.setMem_fk(rs.getInt("MEM_fk"));
			    tache.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tache;
	}
	@Override
	public ArrayList<Tache> TacheParStatut(String tps) {
		ArrayList<Tache> tache =new ArrayList<Tache>();
		Connection connection=singletonconnection.getConnection();
		try {
			PreparedStatement ps =connection.prepareStatement
					("SELECT t.*, m.NOM_MEM FROM TACHE t, MEMBRE m WHERE t.MEM_fk = m.ID_MEM AND t.STATUT LIKE ?");
			ps.setString(1, "%"+tps+"%");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				
				Tache t=new Tache();
			    t.setId(rs.getInt("ID"));
			    t.setNom(rs.getString("NOM_TAC"));
			    t.setDescription(rs.getString("DESCRIPTION"));
			    t.setMem_fk(rs.getInt("MEM_fk"));
			    t.setMembre(rs.getString("NOM_MEM"));
			    tache.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tache;
	}
	
/////////////////////////////rechercher par id de membre///////////////////////////////////////
	@Override
	public ArrayList<Tache> getListTachebyIdMembre(int idmembre) {
		ArrayList<Tache> tache =new ArrayList<Tache>();
		Connection connection=singletonconnection.getConnection();
		try {
			PreparedStatement ps =connection.prepareStatement
					("SELECT * FROM TACHE WHERE MEM_fk= ?");
			ps.setInt(1, idmembre);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Tache t=new Tache();
			    t.setId(rs.getInt("ID"));
			    t.setNom(rs.getString("NOM_TAC"));
			    t.setDescription("DESCRIPTION");
			    t.setStatut(rs.getString("STATUT"));
			    tache.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tache;
	}
	@Override
	public Tache getTache(int id) {
		Tache t=null;
		Connection connection=singletonconnection.getConnection();
		try {
			PreparedStatement ps =connection.prepareStatement
			("SELECT * FROM TACHE WHERE ID=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				t=new Tache();
				t.setId(rs.getInt("ID"));
				t.setNom(rs.getString("NOM_TAC"));
				t.setDescription(rs.getString("DESCRIPTION"));
				t.setStatut(rs.getString("STATUT"));
				t.setMem_fk(rs.getInt("MEM_fk"));   
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	@Override
	public Tache updateTache (Tache t) {
		Connection connection=singletonconnection.getConnection();
		try {
			PreparedStatement ps =connection.prepareStatement
					("UPDATE TAHCE SET NOM_TAC=? WHERE ID_MEM=?");
			ps.setString(1, t.getNom());
			ps.setInt(2,t.getId());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return t;
	}
	@Override
	public void  deleteTache(int id) {
		Connection connection=singletonconnection.getConnection();
		try {
			PreparedStatement ps =connection.prepareStatement
					("DELETE FROM TACHE WHERE ID=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<Membre> tousmembresparMC(String mced) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Membre getMembre(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}

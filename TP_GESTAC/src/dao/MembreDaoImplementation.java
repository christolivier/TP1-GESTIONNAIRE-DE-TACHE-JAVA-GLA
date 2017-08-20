package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import metier.entities.Membre;
public class MembreDaoImplementation implements ImembreDao {
	@Override
	public Membre save(Membre m) {
	Connection connection=singletonconnection.getConnection();
	try {
		PreparedStatement ps =connection.prepareStatement
				("INSERT INTO MEMBRE(NOM_MEM) VALUES (?)");
		ps.setString(1, m.getNom());
		ps.executeUpdate();
		PreparedStatement ps2=connection.prepareStatement
				("SELECT MAX(ID_MEM) AS MAX_ID FROM MEMBRE");
		ResultSet rs=ps2.executeQuery();
		if(rs.next()){
			
			m.setId(rs.getInt("MAX_ID"));
		}
		ps.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return m;
	}
	@Override
	public ArrayList<Membre> membresparMC(int mc) {
		ArrayList<Membre> membre =new ArrayList<Membre>();
		Connection connection=singletonconnection.getConnection();
		try {
			PreparedStatement ps =connection.prepareStatement
					("SELECT * FROM MEMBRE WHERE ID_MEM LIKE ?");
			ps.setInt(1, mc);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Membre m=new Membre();
			    m.setId(rs.getInt("ID_MEM"));
			    m.setNom(rs.getString("NOM_MEM"));
			    membre.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return membre;
	}
	@Override
	public ArrayList<Membre> getListMembre() {
		ArrayList<Membre> membre =new ArrayList<>();
		Connection connection=singletonconnection.getConnection();
		try {
			PreparedStatement ps =connection.prepareStatement
					("SELECT * FROM MEMBRE ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				
				Membre m=new Membre();
			    m.setId(rs.getInt("ID_MEM"));
			    m.setNom(rs.getString("NOM_MEM"));
			    membre.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return membre;
	}
	@Override
	public ArrayList<Membre> tousmembresparMC(String mced) {
		ArrayList<Membre> membre =new ArrayList<Membre>();
		Connection connection=singletonconnection.getConnection();
		try {
			PreparedStatement ps =connection.prepareStatement
					("SELECT * FROM MEMBRE WHERE NOM_MEM LIKE ?");
			ps.setString(1, mced); 
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				
				Membre m=new Membre();
			    m.setId(rs.getInt("ID_MEM"));
			    m.setNom(rs.getString("NOM_MEM"));
			    membre.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return membre;
	}
	@Override
	public Membre getMembre(int id) {
		Membre m=null;
		Connection connection=singletonconnection.getConnection();
		try {
			PreparedStatement ps =connection.prepareStatement
					("SELECT * FROM MEMBRE WHERE ID_MEM=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				m=new Membre();
			    m.setId(rs.getInt("ID_MEM"));
			    m.setNom(rs.getString("NOM_MEM"));  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
	@Override
	public Membre updateMembre(Membre m) {
		Connection connection=singletonconnection.getConnection();
		try {
			PreparedStatement ps =connection.prepareStatement
					("UPDATE  MEMBRE SET NOM_MEM=? WHERE ID_MEM=?");
			ps.setString(1, m.getNom());
			ps.setInt(2, m.getId());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return m;
	}
	@Override
	public void deleteMembre(int id) {
		Connection connection=singletonconnection.getConnection();
		try {
			PreparedStatement ps =connection.prepareStatement
					("DELETE FROM MEMBRE WHERE ID_MEM=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<Membre> membresearch(String ms) {
		// TODO Auto-generated method stub
		return null;
	}

}

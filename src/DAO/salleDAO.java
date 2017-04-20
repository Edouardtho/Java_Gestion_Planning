package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entite.salle;
import hibernate.DBConnection;

public class salleDAO {
	public static boolean saveSalle(salle newSalle) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		// Envoi d’un requête générique
        String sql 	= "INSERT INTO salle (nomSalle, capaciteSalle) "
        			+ "VALUES (	'"+newSalle.getNomSalle()+"', "
        			+ "			'"+newSalle.getCapaciteSalle()+"';" ;
        
        return access.createStatement().execute(sql);
	}
	
	public static int updateSalle(salle majSalle) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		// Envoi d’un requête générique
        String sql 	= "UPDATE salle "
        			+ "SET	nomSalle = '"+majSalle.getNomSalle()+"', "
        			+ "		capaciteSalle = "+majSalle.getCapaciteSalle()+" "
        			+ "WHERE idSalle = "+majSalle.getIdSalle()+";";
        
        return access.createStatement().executeUpdate(sql);
	}
	
	public static Boolean deleteSalle(int idSalle) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		// Envoi d’un requête générique
        String sql 	= "DELETE FROM salle "
        			+ "WHERE idProf = "+idSalle+";";
        
        Statement smt = access.createStatement() ;
        return smt.execute(sql) ;
	}
	
	public static List<salle> listeSalles() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		List<salle> list =  new ArrayList<salle>();
		
		// Envoi d’un requête générique
        String sql 	= "SELECT * "
        			+ "FROM salle";

        ResultSet rs = access.createStatement().executeQuery(sql) ;
        
        while (rs.next()) {
        	salle uneSalle = new salle(	rs.getInt("idSalle"),
        								rs.getString("nomSalle"),
        								rs.getInt("capaciteSalle"));
        	list.add(uneSalle);
		}
		
        return list;
	}
}

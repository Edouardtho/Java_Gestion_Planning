package DAO;

import entite.planning;
import hibernate.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class planningDAO {
	public static boolean savePlanning(planning newPlanning) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		// Envoi d'une requête générique
        String sql 	= "INSERT INTO planning (jour, heureDebut, heureFin, idSalle, idProf, idMatiere) "
        			+ "VALUES (	'"+newPlanning.getJour()+"', "
        			+ "			'"+newPlanning.getHeureDebut()+"', "
        			+ "			'"+newPlanning.getHeureFin()+"', "
        			+ "			'"+newPlanning.getIdSalle()+"', "
        			+ "			'"+newPlanning.getIdProf()+"', "
        			+ "			'"+newPlanning.getIdMatiere()+"');" ;
        
        return access.createStatement().execute(sql);
	}
	
	public static int updatePlanning(planning majPlanning) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		// Envoi d'une requête générique
        String sql 	= "UPDATE planning "
        			+ "SET	jour = '"+majPlanning.getJour()+"', "
        			+ "		heureDebut = "+majPlanning.getHeureDebut()+", "
        			+ "		heureFin = "+majPlanning.getHeureFin()+", "
        			+ "		idSalle = "+majPlanning.getIdSalle()+", "
        			+ "		idProf = "+majPlanning.getIdProf()+", "
       				+ "		idMatiere = "+majPlanning.getIdMatiere()+" "
        			+ "WHERE idPlanning = "+majPlanning.getIdPlanning()+";";
        
        return access.createStatement().executeUpdate(sql);
	}
	
	public static Boolean deletePlanning(int idPlanning) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		// Envoi d'une requête générique
        String sql 	= "DELETE FROM planning "
        			+ "WHERE idPlanning = "+idPlanning+";";
        
        Statement smt = access.createStatement() ;
        return smt.execute(sql) ;
	}
	
	public static List<planning> listePlanning() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		List<planning> list =  new ArrayList<planning>();
		
		// Envoi d'une requête générique
        String sql 	= "SELECT * "
        			+ "FROM planning";

        ResultSet rs = access.createStatement().executeQuery(sql) ;
        
        while (rs.next()) {
        	planning unPlanning = new planning(	rs.getInt("idPlanning"),
        										rs.getDate("jour"),
        										rs.getTime("heureDebut"),
        										rs.getTime("heureFin"),
        										rs.getInt("idSalle"),
        										rs.getInt("idProf"),
        										rs.getInt("idMatiere"));
        	list.add(unPlanning);
		}
		
        return list;
	}
}

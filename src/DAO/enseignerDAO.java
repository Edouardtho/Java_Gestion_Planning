package DAO;

import entite.enseigner;
import hibernate.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class enseignerDAO {
	public static boolean saveEnseigner(enseigner newEnseigner) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		// Envoi d'une requête générique
        String sql 	= "INSERT INTO enseigner (idProf, idMatiere) "
        			+ "VALUES (	'"+newEnseigner.getIdProf()+"', "
        			+ "			'"+newEnseigner.getIdMatiere()+"');" ;
        
        return access.createStatement().execute(sql);
	}
	
	public static int updateEnseigner(enseigner majEnseigner) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		// Envoi d'une requête générique
        String sql 	= "UPDATE enseigner "
        			+ "SET	idProf = '"+majEnseigner.getIdProf()+"', "
        			+ "		idMatiere = "+majEnseigner.getIdMatiere()+" "
        			+ "WHERE idEnseigner = "+majEnseigner.getIdEnseigner()+";";
        
        return access.createStatement().executeUpdate(sql);
	}
	
	public static Boolean deleteEnseigner(int idEnseigner) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		// Envoi d'une requête générique
        String sql 	= "DELETE FROM enseigner "
        			+ "WHERE idEnseigner = "+idEnseigner+";";
        
        Statement smt = access.createStatement() ;
        return smt.execute(sql) ;
	}
	
	public static List<enseigner> listeEnseigner() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		List<enseigner> list =  new ArrayList<enseigner>();
		
		// Envoi d'une requête générique
        String sql 	= "SELECT * "
        			+ "FROM matiere";

        ResultSet rs = access.createStatement().executeQuery(sql) ;
        
        while (rs.next()) {
        	enseigner allonsEnseigner = new enseigner(rs.getInt("idEnseigner"), rs.getInt("idProf"), rs.getInt("idMatiere"));
        	list.add(allonsEnseigner);
		}
		
        return list;
	}
}

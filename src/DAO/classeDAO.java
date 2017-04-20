package DAO;

import hibernate.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import entite.classe;

public class classeDAO {
	
	public static boolean saveClasse(classe newClasse) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		// Envoi d’un requête générique
        String sql 	= "INSERT INTO classe (nomClasse, nombreEleves) "
        			+ "VALUES (	'"+newClasse.getNomClasse()+"', "
        			+ "			'"+newClasse.getNombreEleves() + "');" ;
        
        return access.createStatement().execute(sql);
	}
	
	public static int updateClasse(classe majClasse) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		// Envoi d’un requête générique
        String sql 	= "UPDATE classe "
        			+ "SET	nomClasse = '"+majClasse.getNomClasse()+"', "
        			+ "		nombreEleves = "+majClasse.getNombreEleves()+" "
        			+ "WHERE idClasse = "+majClasse.getIdClasse()+";";
        
        return access.createStatement().executeUpdate(sql);
	}
	
	public static Boolean deleteClasse(int idClasse) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		// Envoi d’un requête générique
        String sql 	= "DELETE FROM classe "
        			+ "WHERE idClasse = "+idClasse+";";
        
        Statement smt = access.createStatement() ;
        return smt.execute(sql) ;
	}
	
	public static List<classe> listeClasses() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		List<classe> list =  new ArrayList<classe>();
		
		// Envoi d’un requête générique
        String sql 	= "SELECT * "
        			+ "FROM classe";

        ResultSet rs = access.createStatement().executeQuery(sql) ;
        
        while (rs.next()) {
        	classe uneClasse = new classe(rs.getInt("idClasse"), rs.getString("nomClasse"), rs.getInt("nombreEleves"));
        	list.add(uneClasse);
		}
		
        return list;
	}
}
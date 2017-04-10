package DAO;

import hibernate.DBConnection;
import hibernate.basedonnees;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entite.classe;

public class classeDAO {
	static basedonnees seconnecter = new basedonnees();
	
	public static Boolean saveClasse(classe newClasse) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		 // Envoi d’un requête générique
        String sql 	= "INSERT INTO classe (nomClasse, nombreEleves)"
        			+ "VALUES ('"+newClasse.getNomClasse()+"','"+newClasse.getNombreEleves() + "');" ;
        
        Statement smt = access.createStatement() ;
        ResultSet rs = smt.executeQuery(sql) ;
        
        if (rs.next())
        	return true;
        else
        	return false;
	}
	
	public static Boolean updateClasse(classe majClasse) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		 // Envoi d’un requête générique
        String sql 	= "UPDATE classe (nomClasse, nombreEleves)"
        			+ "SET nomClasse = '"+majClasse.getNomClasse()+"',"
        			+ "nombreEleves = '"+majClasse.getNombreEleves()+"'"
        			+ "WHERE idClasse = "+majClasse.getIdClasse()+")";
        
        Statement smt = access.createStatement() ;
        ResultSet rs = smt.executeQuery(sql) ;
        
        if (rs.next())
        	return true;
        else
        	return false;
	}
	
	public static Boolean deleteClasse(classe suprClasse) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		 // Envoi d’un requête générique
        String sql 	= "DELETE FROM classe "
        			+ "WHERE idClasse = "+suprClasse.getIdClasse()+")";
        
        Statement smt = access.createStatement() ;
        ResultSet rs = smt.executeQuery(sql) ;
        
        if (rs.next())
        	return true;
        else
        	return false;
	}
	
	public static List<classe> listeClasse() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		List<classe> list =  new ArrayList<classe>();
		
		 // Envoi d’un requête générique
        String sql 	= "SELECT *"
        			+ "FROM classe";
        
        Statement smt = access.createStatement() ;
        ResultSet rs = smt.executeQuery(sql) ;
        
        while (rs.next()) {
        	classe uneClasse = new classe(rs.getInt("idClasse"), rs.getString("nomClasse"), rs.getInt("nombreEleves"));
        	list.add(uneClasse);
		}
		
        return list;
        
	}
}
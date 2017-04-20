package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entite.personne;
import hibernate.DBConnection;

public class personneDAO {
	public static boolean savePersonne(personne newPersonne) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		// Envoi d’un requête générique
        String sql 	= "INSERT INTO personne (nom, prenom, email) "
        			+ "VALUES (	'"+newPersonne.getNom()+"', "
        			+ "			'"+newPersonne.getPrenom()+"', "
        			+ "			'"+newPersonne.getEmail()+"';" ;
        
        return access.createStatement().execute(sql);
	}
	
	public static int updatePersonne(personne majPersonne) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		// Envoi d’un requête générique
        String sql 	= "UPDATE personne "
        			+ "SET	nom = '"+majPersonne.getNom()+"', "
        			+ "		prenom = "+majPersonne.getPrenom()+", "
        			+ "		email = "+majPersonne.getEmail()+" "
        			+ "WHERE idProf = "+majPersonne.getIdPersonne()+";";
        
        return access.createStatement().executeUpdate(sql);
	}
	
	public static Boolean deletePersonne(int idPersonne) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		// Envoi d’un requête générique
        String sql 	= "DELETE FROM personne "
        			+ "WHERE idProf = "+idPersonne+";";
        
        Statement smt = access.createStatement() ;
        return smt.execute(sql) ;
	}
	
	public static List<personne> listePersonnes() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		List<personne> list = new ArrayList<personne>();
		
		// Envoi d’un requête générique
        String sql 	= "SELECT * "
        			+ "FROM personne";

        ResultSet rs = access.createStatement().executeQuery(sql) ;
        
        while (rs.next()) {
        	personne unePersonne = new personne(rs.getInt("idPersonne"),
        										rs.getString("nom"),
        										rs.getString("prenom"),
        										rs.getString("email"),
        										rs.getString("statut"));
        	list.add(unePersonne);
		}
		
        return list;
	}
	
	public static personne connexionPersonne(String identifiant, String motDePasse) throws Exception{
		Connection access = DBConnection.getInstance();
		
		personne unePersonne = null;
		
		// Envoi d’un requête générique
        String sql 	= "SELECT * "
        			+ "FROM personne "
        			+ "WHERE identifiant = '"+identifiant+"' "
        			+ "AND motDePasse = MD5('"+motDePasse+"')";

        ResultSet rs = access.createStatement().executeQuery(sql) ;
        
        while (rs.next()) {
        	unePersonne = new personne(	rs.getInt("idPersonne"),
										rs.getString("nom"),
										rs.getString("prenom"),
										rs.getString("email"),
										rs.getString("statut"));
		}
		
        return unePersonne;
	}
}

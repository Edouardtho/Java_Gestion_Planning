package DAO;

import entite.matiere;
import hibernate.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class matiereDAO {
	public static boolean saveMatiere(matiere newMatiere) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		// Envoi d'une requête générique
        String sql 	= "INSERT INTO matiere (nomMatiere, nbHeures) "
        			+ "VALUES (	'"+newMatiere.getNomMatiere()+"', "
        			+ "			'"+newMatiere.getNbrHeures()+"');" ;
        
        return access.createStatement().execute(sql);
	}
	
	public static int updateMatiere(matiere majMatiere) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		// Envoi d'une requête générique
        String sql 	= "UPDATE matiere "
        			+ "SET	nomMatiere = '"+majMatiere.getNomMatiere()+"', "
        			+ "		nbHeures = "+majMatiere.getNbrHeures()+" "
        			+ "WHERE idMatiere = "+majMatiere.getIdMatiere()+";";
        
        return access.createStatement().executeUpdate(sql);
	}
	
	public static Boolean deleteMatiere(int idMatiere) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		// Envoi d'une requête générique
        String sql 	= "DELETE FROM enseigner "
        			+ "WHERE idMatiere = "+idMatiere+";";
        
        Statement smt = access.createStatement() ;
        if (smt.execute(sql))
        {
			// Envoi d'une requête générique
	        sql = "DELETE FROM matiere "
	        	+ "WHERE idMatiere = "+idMatiere+";";
	    
	        smt = access.createStatement() ;
	        return smt.execute(sql) ;
        }
        else
        {
        	return smt.execute(sql) ;
        }
	}
	
	public static List<matiere> listeMatieres() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Connection access = DBConnection.getInstance();
		
		List<matiere> list =  new ArrayList<matiere>();
		
		// Envoi d'une requête générique
        String sql 	= "SELECT * "
        			+ "FROM matiere";

        ResultSet rs = access.createStatement().executeQuery(sql) ;
        
        while (rs.next()) {
        	matiere uneMatiere = new matiere(rs.getInt("idMatiere"), rs.getString("nomMatiere"), rs.getInt("nbHeures"));
        	list.add(uneMatiere);
		}
		
        return list;
	}
}

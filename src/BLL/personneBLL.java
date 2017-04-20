package BLL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.personneDAO;
import entite.personne;
import hibernate.fonctions;

public class personneBLL {
	public static Boolean savePersonne(personne newPersonne) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return personneDAO.savePersonne(newPersonne);
	}
	
	public static int updatePersonne(personne majPersonne) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return personneDAO.updatePersonne(majPersonne);
	}
	
	public static Boolean deletePersonne(int idPersonne) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return personneDAO.deletePersonne(idPersonne);
	}
	
	public static List<personne> listePersonnes() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return personneDAO.listePersonnes();
	}
	
	public static ArrayList<String> nomColonnes(String table) throws Exception{
		return fonctions.nomColonnes(table);
	}
	
	public static personne connexionPersonne(String identifiant, String motDePasse) throws Exception{
		return personneDAO.connexionPersonne(identifiant, motDePasse);
	}
}

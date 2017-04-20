package BLL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.matiereDAO;
import entite.matiere;
import hibernate.fonctions;

public class matiereBLL {
	public static Boolean saveMatiere(matiere newMatiere) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return matiereDAO.saveMatiere(newMatiere);
	}
	
	public static int updateMatiere(matiere majMatiere) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return matiereDAO.updateMatiere(majMatiere);
	}
	
	public static Boolean deleteMatiere(int idMatiere) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return matiereDAO.deleteMatiere(idMatiere);
	}
	
	public static List<matiere> listeMatieres() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return matiereDAO.listeMatieres();
	}
	
	public static ArrayList<String> nomColonnes(String table) throws Exception{
		return fonctions.nomColonnes(table);
	}
}

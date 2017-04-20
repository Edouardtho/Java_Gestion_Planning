package BLL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.enseignerDAO;
import entite.enseigner;
import hibernate.fonctions;

public class enseignerBLL {
	public static Boolean saveEnseigner(enseigner newEnseigner) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return enseignerDAO.saveEnseigner(newEnseigner);
	}
	
	public static int updateEnseigner(enseigner majEnseigner) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return enseignerDAO.updateEnseigner(majEnseigner);
	}
	
	public static Boolean deleteEnseigner(int idEnseigner) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return enseignerDAO.deleteEnseigner(idEnseigner);
	}
	
	public static List<enseigner> listeEnseigner() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return enseignerDAO.listeEnseigner();
	}
	
	public static ArrayList<String> nomColonnes(String table) throws Exception{
		return fonctions.nomColonnes(table);
	}
}

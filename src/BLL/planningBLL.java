package BLL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.planningDAO;
import entite.planning;
import hibernate.fonctions;

public class planningBLL {
	public static Boolean savePlanning(planning newPlanning) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return planningDAO.savePlanning(newPlanning);
	}
	
	public static int updatePlanning(planning majPlanning) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return planningDAO.updatePlanning(majPlanning);
	}
	
	public static Boolean deletePlanning(int idPlanning) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return planningDAO.deletePlanning(idPlanning);
	}
	
	public static List<planning> listePlanning() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return planningDAO.listePlanning();
	}
	
	public static ArrayList<String> nomColonnes(String table) throws Exception{
		return fonctions.nomColonnes(table);
	}
}

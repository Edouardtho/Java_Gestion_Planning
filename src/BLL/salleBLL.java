package BLL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.salleDAO;
import entite.salle;
import hibernate.fonctions;

public class salleBLL {
	public static Boolean saveSalle(salle newSalle) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return salleDAO.saveSalle(newSalle);
	}
	
	public static int updateSalle(salle majSalle) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return salleDAO.updateSalle(majSalle);
	}
	
	public static Boolean deleteSalle(int idSalle) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return salleDAO.deleteSalle(idSalle);
	}
	
	public static List<salle> listeSalles() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return salleDAO.listeSalles();
	}
	
	public static ArrayList<String> nomColonnes(String table) throws Exception{
		return fonctions.nomColonnes(table);
	}
}

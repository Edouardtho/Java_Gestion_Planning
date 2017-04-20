package BLL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.classeDAO;
import entite.classe;
import hibernate.fonctions;

public class classeBLL {
	public static Boolean saveClasse(classe newClasse) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return classeDAO.saveClasse(newClasse);
	}
	
	public static int updateClasse(classe majClasse) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return classeDAO.updateClasse(majClasse);
	}
	
	public static Boolean deleteClasse(int idClasse) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return classeDAO.deleteClasse(idClasse);
	}
	
	public static List<classe> listeClasses() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return classeDAO.listeClasses();
	}
	
	public static ArrayList<String> nomColonnes(String table) throws Exception{
		return fonctions.nomColonnes(table);
	}
}

package BLL;

import java.sql.SQLException;
import java.util.List;

import DAO.classeDAO;
import entite.classe;

public class classeBLL {
	public static Boolean saveClasse(classe newClasse) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return classeDAO.saveClasse(newClasse);
	}
	
	public static Boolean updateClasse(classe majClasse) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return classeDAO.updateClasse(majClasse);
	}
	
	public static Boolean deleteClasse(classe suprClasse) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return classeDAO.deleteClasse(suprClasse);
	}
	
	public static List<classe> listeClasse() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return classeDAO.listeClasse();
	}
}

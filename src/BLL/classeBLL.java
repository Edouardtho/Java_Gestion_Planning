package BLL;

import java.sql.SQLException;
import java.util.List;

import DAO.classeDAO;
import entite.classe;

public class classeBLL {
	public static Boolean saveClasse(classe newClasse) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		return classeDAO.saveClasse(newClasse);
	}
	
	public static Boolean updateClasse(classe majClasse){		
		try{
			return classeDAO.updateClasse(majClasse);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	public static Boolean deleteClasse(classe suprClasse){
		try{
			return classeDAO.deleteClasse(suprClasse);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	public static List<classe> listeClasse(){
		try{
			return classeDAO.listeClasse();
		}
		catch(Exception e)
		{
			return null;
		}
	}
}

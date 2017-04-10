package BLL;

import java.util.List;

import DAO.classeDAO;
import entite.classe;

public class classeBLL {
	public Boolean saveClasse(classe newClasse){
		try{
			return classeDAO.saveClasse(newClasse);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	public Boolean updateClasse(classe majClasse){		
		try{
			return classeDAO.updateClasse(majClasse);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	public Boolean deleteClasse(classe suprClasse){
		try{
			return classeDAO.deleteClasse(suprClasse);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	public List<classe> listeClasse(){
		try{
			return classeDAO.listeClasse();
		}
		catch(Exception e)
		{
			return null;
		}
	}
}

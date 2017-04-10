package hibernate;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class basedonnees {
	/* Connexion à la base de données */
	static String url = "jdbc:mysql://localhost:8080/planning";
	static String utilisateur = "root";
	static String motDePasse = "";
	Connection connexion = null;
	
	@SuppressWarnings("rawtypes")
	public Connection connexion() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
		 // chargement de la classe par son nom
        Class c = Class.forName("com.mysql.jdbc.Driver") ;
        Driver pilote = (Driver)c.newInstance() ;
         // enregistrement du pilote auprès du DriverManager
        DriverManager.registerDriver(pilote);
        
         // Connexion
        return DriverManager.getConnection(url, utilisateur, motDePasse) ;
	}
}

package hibernate;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBConnection {
	private static String url = "jdbc:mysql://localhost:8889/planning";
	private static String user = "root";
	private static String password = "root";
	private static java.sql.Connection connect;
	
	public static Connection getInstance(){
		if (connect == null){
			try {
				connect = DriverManager.getConnection(url, user, password);
				System.out.println("Instructions de la connexion SQL");
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("NOPE SQL");
		}
		
		return connect;
	}
}

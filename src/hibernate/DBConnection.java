package hibernate;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBConnection {
	private static String url = "jdbc:mysql://127.0.0.1/planning";
	private static String user = "root";
	private static String password = "";
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

package classes;

import java.sql.Connection;
import java.sql.DriverManager;

public class DS {

	public Connection getConnection() {
		Connection con =  null;
		try {
			Class.forName("org.h2.Driver");
			String url = "jdbc:h2:~/test";
			String login = "sa";
			String mdp = "";
			return con = DriverManager.getConnection(url,login,mdp);
		} catch (Exception e) {
			System.out.println("Erreur: "+ e.getMessage());
			return con;
		}
	}
}

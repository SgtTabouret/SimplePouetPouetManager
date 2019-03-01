package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

	private static DS ds;

	public UserDAO(DS ds) {
		this.ds=ds;
	}

	public static User findByLogin(String login) {
		String query = "SELECT * from users where login=?";
		User u = null;

		try (Connection con = ds.getConnection()){
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) 
				u = new User(rs.getInt("uno"),rs.getString("login"));

		} catch(SQLException e) {
			System.out.println("Erreur: " + e.getMessage());
		}
		return u;
	}

	public static void create(User user) {
		String query = "Insert into users values (?)";
	
		try(Connection con = ds.getConnection()){
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, user.getLogin());
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println("Erreur: " + e.getMessage());
		} 
	}

}

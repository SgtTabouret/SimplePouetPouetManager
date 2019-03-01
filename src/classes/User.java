package classes;

public class User {
	
	private int id;
	private String login;
	private String passphrase;
	
	public User(int id, String login, String passphrase) {
		this.id = id;
		this.login = login;
		this.passphrase = passphrase;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassphrase() {
		return passphrase;
	}

	public void setPassphrase(String passphrase) {
		this.passphrase = passphrase;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + "]";
	}

}

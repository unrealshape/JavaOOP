package Bean;

public class login {
	
	// Attribute der Datenbank @ Tabelle login
	private int idLogin;
	private String username;
	private String password;
	private String emailadress;
	/**
	 * constructor
	 * @param idLogin
	 * @param username
	 * @param password
	 * @param emailadress
	 */
	public login(int idLogin, String username, String password, String emailadress) {
		super();
		this.idLogin = idLogin;
		this.username = username;
		this.password = password;
		this.emailadress = emailadress;
	}
	public login()
	{
		
	}
	public login(String username, String password)
	{
		super();
		this.username = username;
		this.password = password;
	}
	public int getIdLogin() {
		return idLogin;
	}
	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailadress() {
		return emailadress;
	}
	public void setEmailadress(String emailadress) {
		this.emailadress = emailadress;
	}
	
	

}

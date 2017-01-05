package Bean;

public class Employee {
	
	private int id;
	private String titel;
	private String surname;
	private String lastname;
	private String adress;
	private String postcode;
	private String birthday;
	private double gross;
	private double net;
	/**
	 * 
	 */
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param titel
	 * @param surname
	 * @param lastname
	 * @param adress
	 * @param postcode
	 * @param birthday
	 * @param gross
	 * @param net
	 */
	public Employee(int id, String titel, String surname, String lastname, String adress, String postcode, String birthday,
			double gross, double net) {
		super();
		this.id = id;
		this.titel = titel;
		this.surname = surname;
		this.lastname = lastname;
		this.adress = adress;
		this.postcode = postcode;
		this.birthday = birthday;
		this.gross = gross;
		this.net = net;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public double getGross() {
		return gross;
	}
	public void setGross(double gross) {
		this.gross = gross;
	}
	public double getNet() {
		return net;
	}
	public void setNet(double net) {
		this.net = net;
	}
	
	

}

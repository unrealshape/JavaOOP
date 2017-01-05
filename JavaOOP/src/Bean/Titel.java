package Bean;

public class Titel {
	
	private int id;
	private String titles;
	/**
	 * @param id
	 * @param titles
	 */
	public Titel(int id, String titles) {
		super();
		this.id = id;
		this.titles = titles;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitles() {
		return titles;
	}
	public void setTitles(String titles) {
		this.titles = titles;
	}
	
	

}

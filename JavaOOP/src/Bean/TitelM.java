package Bean;

import java.sql.SQLException;
import java.util.ArrayList;


import db.DatabaseManager;

public class TitelM {
	
	ArrayList<Titel> titelList;
	
	public TitelM()
	{
		titelList = new ArrayList<>();
	}
	
	public void loadTitles() throws SQLException
	{
		titelList = DatabaseManager.getInstance().getTitels();
	}
	public ArrayList<Titel> returnList()
	{
		return titelList;
	}

}

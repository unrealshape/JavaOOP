package Bean;

import java.sql.SQLException;
import java.util.ArrayList;

import db.DatabaseManager;

public class loginM {
	
	//Variabel
	ArrayList<login> arrayListLogin = new ArrayList<>();
	
	public void getAllLoginUsers() throws SQLException
	{
		arrayListLogin = DatabaseManager.getInstance().getAllLoginUser();
		System.out.println("Download All User done");
	}
	
    public boolean checkLogin2(login user)
    {
    	
    	int i=0;
    	while(arrayListLogin.size() > i)
    	{
    		if(user.getUsername().equals(arrayListLogin.get(i).getUsername()) && user.getPassword().equals(arrayListLogin.get(i).getPassword()))
    		{
    			
    			return true;
    		}
    		i++;
    	}
    			return false;
    	
    }

	public void print()
	{
		for(int i=0;i<arrayListLogin.size();i++)
		{
			System.out.println("ID = " + arrayListLogin.get(i).getIdLogin()
								+ " Username = " + arrayListLogin.get(i).getUsername()
								+ " Password = " + arrayListLogin.get(i).getPassword()
								+ " Email = " + arrayListLogin.get(i).getEmailadress());
		}
	}
}

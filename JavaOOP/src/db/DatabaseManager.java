package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.Employee;
import Bean.Titel;
import Bean.login;

public class DatabaseManager {
	
    private final static String dbserver = "localhost";
    private final static int dbport = 3306;
    private final static String dbname = "neuedb";
    private final static String dbuser = "root";
    private final static String dbpass ="hallo123";
    private final static String url = "jdbc:mysql://" + dbserver + ":" + dbport + "/" + dbname + "?useSSL=false";
    private static String query = "";
    private static DatabaseManager instance = null;
    private static Connection con = null;
    private PreparedStatement pstmt = null;
    
    public DatabaseManager()
    {
    	
    }
    public static DatabaseManager getInstance()
    {
    	return instance;
    }
    private void verbinden(String url,String dbuser,String dbpass,String treiber)throws Exception
    {
        Class.forName(treiber);
        this.con = DriverManager.getConnection(url, dbuser, dbpass);    
    }   
    public static void verbinden() throws Exception
    {
        instance = new DatabaseManager();
        instance.verbinden(url,dbuser,dbpass,"org.gjt.mm.mysql.Driver");
        
    }
    public ResultSet ausfuehren(String query) throws SQLException 
    {
	PreparedStatement stmt = con.prepareStatement(query);
	stmt.execute();

	return stmt.getResultSet();
    }

    public ResultSet ausfuehren(PreparedStatement stmt) throws SQLException 
    {
	stmt.execute();

	return stmt.getResultSet();
    }

    public ArrayList<login> getAllLoginUser() throws SQLException
    {
    	ArrayList<login> arrayListLogin = new ArrayList<>();
    	query ="SELECT * FROM neuedb.login";
    	 ResultSet rs = ausfuehren(query);
    	 while(rs.next())
    	 {
    		 int loginID = rs.getInt(1);
    		 String username = rs.getString(2);
    		 String password = rs.getString(3);
    		 String email = rs.getString(4);
    		 arrayListLogin.add(new login(loginID,username,password,email));
    	 }
    	return arrayListLogin;
    }
    public ArrayList<Employee> getAllEmployees() throws SQLException
    {
    	ArrayList<Employee> arrayListEmployee = new ArrayList<>();
    	query = "SELECT * FROM neuedb.employees";
    	ResultSet rs = ausfuehren(query);
    	while(rs.next())
    	{
    		int id = rs.getInt(1);
    		int titelid = rs.getInt(2);
    		String titel = getTitleName(titelid);
    		String surname = rs.getString(3);
    		String lastname = rs.getString(4);
    		String adress = rs.getString(5);
    		String postcode = rs.getString(6);
    		String birthday = rs.getString(7);
    		double gross = rs.getDouble(8);
    		double net = rs.getDouble(9);
    		arrayListEmployee.add(new Employee(id,titel,surname,lastname,adress,postcode,birthday,gross,net));
    	}
    	return arrayListEmployee;
    }
    
    private String getTitleName(int idFromTitles) throws SQLException {
		String title = "";
		query = "SELECT titles FROM neuedb.titles WHERE ID='"+idFromTitles+"'";
		ResultSet rs = ausfuehren(query);
		if(rs.next())
		{
			title = rs.getString(1);
		}
		return title;
	}
    public int getEmployeeMax() throws SQLException
    {
    	String query = "select max(id) from neuedb.employees"; 
        int count = 0;
    	ResultSet rs = ausfuehren(query);
    	while (rs.next()) {
    		count = rs.getInt(1)+1;
		}
    	return count;
    }
    public ArrayList<Titel> getTitels() throws SQLException
    {
    	ArrayList<Titel> titelList = new ArrayList<>();
    	query ="SELECT * FROM neuedb.titles;";
    	ResultSet rs = ausfuehren(query);
    	while(rs.next())
    	{
    		int id = rs.getInt(1);
    		String titel = rs.getString(2);
    		titelList.add(new Titel(id, titel));
    	}
    	return titelList;
    }    
    public void deleteEmployee(int id) throws SQLException
    {
    	query ="DELETE FROM `neuedb`.`employees` WHERE ID = ?;";
    	PreparedStatement pstmt = con.prepareStatement(query);
    	pstmt.setInt(1, id);
    	ResultSet rs = ausfuehren(pstmt);
    }
    public void addEmployee(Employee newEmployee) throws SQLException
    {
    	query ="INSERT INTO `neuedb`.`employees` (`id`,`titel`,`surname`,`lastname`,`adress`,`postcode`,`birthday`,`gross`,`net`) VALUES (?,?,?,?,?,?,?,?,?)";
    	System.out.println("titel von obj " + newEmployee.getTitel());
    	int titelID = searchTitleID(newEmployee.getTitel());
    	System.out.println("titel id gesucht" + titelID);
    	PreparedStatement pstmt = con.prepareStatement(query);
    	pstmt.setInt(1, newEmployee.getId());
    	pstmt.setInt(2, titelID);
    	pstmt.setString(3, newEmployee.getSurname());
    	pstmt.setString(4, newEmployee.getLastname());
    	pstmt.setString(5, newEmployee.getAdress());
    	pstmt.setString(6, newEmployee.getPostcode());
    	pstmt.setString(7, newEmployee.getBirthday());
    	pstmt.setDouble(8, newEmployee.getGross());
    	pstmt.setDouble(9, newEmployee.getNet());
    	ResultSet rs = ausfuehren(pstmt);
    }
    private int searchTitleID(String titleName) throws SQLException
    {
		int titleID = 0;
		query = "Select * From neuedb.titles WHERE titles LIKE ?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, titleName);
		ResultSet rs = ausfuehren(pstmt); 
		while(rs.next())
		{
			
			titleID = rs.getInt(1);
		}
		return titleID;
    }
	

}
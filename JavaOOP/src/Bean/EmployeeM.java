package Bean;

import java.sql.SQLException;
import java.util.ArrayList;
import db.DatabaseManager;

public class EmployeeM {
	
	private ArrayList<Employee> employeeList;
	
	public EmployeeM()
	{
		this.employeeList = new ArrayList<Employee>();
	}
	
	public void loadEmployees() throws SQLException
	{
		employeeList = DatabaseManager.getInstance().getAllEmployees();
	}
	public EmployeeTableModel getEmployeeTableModel()
	{
		return new EmployeeTableModel(employeeList);
	}
	public String getEmployeeSurname(int index)
	{
		return employeeList.get(index).getSurname();
	}
	public String getEmployeeLastName(int index)
	{
		return employeeList.get(index).getLastname();
	}
	
	public void deleteEmployee(int index)throws SQLException
	{
		int id = employeeList.get(index).getId();
		DatabaseManager.getInstance().deleteEmployee(id);
	}
	public void addEmployee(Employee newEmployee) throws SQLException
	{
		DatabaseManager.getInstance().addEmployee(newEmployee);
		employeeList.add(newEmployee);
	}

}

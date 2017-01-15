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
	public int getEmployeeID(int index)
	{
		return employeeList.get(index).getId();
	}
	public String getEmployeeSurname(int index)
	{
		return employeeList.get(index).getSurname();
	}
	public String getEmployeeLastName(int index)
	{
		return employeeList.get(index).getLastname();
	}
	public String getEmployeeAdress(int index)
	{
		return employeeList.get(index).getAdress();
	}
	public String getEmployeeTitel(int index)
	{
		return employeeList.get(index).getTitel();
	}
	public String getEmployeePostCode(int index)
	{
		return employeeList.get(index).getPostcode();
	}
	public String getEmployeeBirthday(int index)
	{
		return employeeList.get(index).getBirthday();
	}
	public Double getEmployeeGross(int index)
	{
		return employeeList.get(index).getGross();
	}
	public Double getEmployeeNet(int index)
	{
		return employeeList.get(index).getNet();
	}
	
	public void deleteEmployee(int index)throws SQLException
	{
		int id = employeeList.get(index).getId();
		DatabaseManager.getInstance().deleteEmployee(id);
		employeeList.remove(index);
	}
	public void addEmployee(Employee newEmployee) throws SQLException
	{
		DatabaseManager.getInstance().addEmployee(newEmployee);
		employeeList.add(newEmployee);
	}
	public void editEmployee(Employee editEmployee) throws SQLException
	{
		DatabaseManager.getInstance().editEmployee(editEmployee);
		
	}


}

package Bean;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


public class EmployeeTableModel implements TableModel {

	private ArrayList<Employee> employees;
	
	public EmployeeTableModel(ArrayList<Employee> employees)
	{
		this.employees = employees;
	}
	@Override
	public int getRowCount() {
		return employees.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 9;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "ID";
		case 1:
			return "Title";
		case 2:
			return "Surname";
		case 3:
			return "Lastname";
		case 4:
			return "Address";
		case 5:
			return "Postcode";
		case 6:
			return "Birthday";
		case 7:
			return "Gross";
		case 8:
			return "Net";
		}
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0)
			return employees.get(rowIndex).getId();
		else if (columnIndex == 1)
			return employees.get(rowIndex).getTitel();
		else if (columnIndex == 2)
			return employees.get(rowIndex).getSurname();
		else if (columnIndex == 3)
			return employees.get(rowIndex).getLastname();
		else if (columnIndex == 4)
			return employees.get(rowIndex).getAdress();
		else if (columnIndex == 5)
			return employees.get(rowIndex).getPostcode();
		else if (columnIndex == 6)
			return employees.get(rowIndex).getBirthday();
		else if (columnIndex == 7)
			return employees.get(rowIndex).getGross();
		else if (columnIndex == 8)
			return employees.get(rowIndex).getNet();

		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

}

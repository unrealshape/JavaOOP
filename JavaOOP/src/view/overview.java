package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import Bean.EmployeeM;
import Bean.EmployeeTableModel;
import db.DatabaseManager;
import java.awt.Window.Type;

public class overview extends Observable implements ActionListener,Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel contentPane;
	private JTable table;
	private JButton btnEditEmployee;
	private JButton btnDeleteEmployee;
	private JButton btnAddEmployee;
	private JButton btnClose;
	
	
	
	private addEmployeeView addEmployeeView;
	private editEmployeeView editEmployeeView;
	private EmployeeM employeeM = new EmployeeM();
	
	public overview() {
		super();
		frame = new JFrame();
		frame.setTitle("Übersicht");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 709, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(6, 6, 697, 240);
		contentPane.add(scrollPane);
		
		btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.setBounds(6, 256, 128, 29);
		contentPane.add(btnAddEmployee);
		
		btnEditEmployee = new JButton("Edit Employee");
		btnEditEmployee.setBounds(134, 256, 128, 29);
		contentPane.add(btnEditEmployee);
		
		btnDeleteEmployee = new JButton("Delete Employee");
		btnDeleteEmployee.setBounds(261, 256, 128, 29);
		contentPane.add(btnDeleteEmployee);
		
		btnClose = new JButton("Close");
		btnClose.setBounds(387, 256, 117, 29);
		contentPane.add(btnClose);
	}
	
	public void setzeAlleActionListener(ActionListener l)
	{
		btnAddEmployee.addActionListener(l);
		btnEditEmployee.addActionListener(l);
		btnDeleteEmployee.addActionListener(l);
		btnClose.addActionListener(l);
	}
	
	public void setTableModel(EmployeeTableModel employeTM) {
		this.table.setModel(employeTM);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(String.class, centerRenderer);
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
	}
	
	
	public void openWindow() {
		try
		{
			DatabaseManager.verbinden();
		}
		catch(Exception e)
		{
			System.err.println("DB Fehlgeschalgen " + e);
		}
		
		try
		{
			employeeM.loadEmployees();			
		}
		catch(SQLException e)
		{
			System.err.println("Employeee Daten runterladen Fehlgeshlagen " + e);
		}
		setzeAlleActionListener(this);
		this.setTableModel(employeeM.getEmployeeTableModel());
		
		frame.setVisible(true);
	}
	
	public JButton getBtnAdd()
	{
		return btnAddEmployee;
	}
	public JButton getBtnEdit()
	{
		return btnEditEmployee;
	}
	public JButton getBtnDelete()
	{
		return btnDeleteEmployee;
	}
	
	public void addEmployeePressed()
	{
		addEmployeeView = new addEmployeeView(employeeM);
		addEmployeeView.addObserver(this);
		addEmployeeView.openWindow();
		
	}
	public void editEmployeePressed()
	{
		int index = getTableIndex();
		if (index == -1)
		{
            JOptionPane.showMessageDialog(null,
                    "Sie haben keinen Mitarbeiter angewählt!",
                    "FehlerMeldung",JOptionPane.WARNING_MESSAGE);
			return;
		}
		editEmployeeView = new editEmployeeView(employeeM,index);
		editEmployeeView.addObserver(this);
		editEmployeeView.openWindow();
	}
	private int getTableIndex()
	{
		return this.table.getSelectedRow();
	}
	public void deleteEmployeePressed()
	{
		{
			int index = getTableIndex();
			if (index == -1)
			{
	            JOptionPane.showMessageDialog(null,
	                    "Sie haben keinen Mitarbeiter angewählt!",
	                    "FehlerMeldung",JOptionPane.WARNING_MESSAGE);
				return;
			}
					String surname = employeeM.getEmployeeSurname(index);
					String lastname = employeeM.getEmployeeLastName(index);
					Object[] options = {"Ja","Nein"};
					int selected = JOptionPane.showOptionDialog(null, "Möchten Sie wirklich den Mitarbeiter '" + surname +" , "+ lastname +"' löschen?",
	        		"Sicher?",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, 
	        			null, options, options[0]);
						if(selected==0)
						{
							try {
								employeeM.deleteEmployee(index);
							} catch (SQLException e) {
								e.printStackTrace();
							}
							update(null,null);
						}
						else if(selected==1)
						{
							return;
						}
		}	
	}
	
	public void closedPressed()
	{
		super.setChanged();
		super.notifyObservers();
		frame.dispose();
	}
	
	public JButton getBtnClose()
	{
		return btnClose;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == getBtnAdd())
		{
			addEmployeePressed();
		}
		else if(e.getSource() == getBtnDelete())
		{
			deleteEmployeePressed();
		}
		else if(e.getSource() == getBtnEdit())
		{
			editEmployeePressed();
		}
		else if(e.getSource() == getBtnClose())
		{
			closedPressed();
		}
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		try {
			employeeM.loadEmployees();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		setTableModel(employeeM.getEmployeeTableModel());
		
	}
}

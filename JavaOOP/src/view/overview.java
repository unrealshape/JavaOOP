package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import com.mysql.fabric.xmlrpc.base.Data;

import Bean.EmployeeM;
import Bean.EmployeeTableModel;
import Bean.TitelM;
import db.DatabaseManager;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class overview extends JFrame implements ActionListener,Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnEditEmployee;
	private JButton btnDeleteEmployee;
	private JButton btnAddEmployee;
	
	
	private addEmployeeView addEmployeeView;
	private editEmployeeView editEmployeeView;
	private TitelM titelM = new TitelM();
	private EmployeeM employeeM = new EmployeeM();
	
	public overview() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(6, 6, 512, 240);
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
	}
	
	public void setzeAlleActionListener(ActionListener l)
	{
		btnAddEmployee.addActionListener(l);
		btnEditEmployee.addActionListener(l);
		btnDeleteEmployee.addActionListener(l);
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
			System.err.println("Login User Daten runterladen Fehlgeshlagen " + e);
		}
		setzeAlleActionListener(this);
		this.setTableModel(employeeM.getEmployeeTableModel());
		
		this.setVisible(true);
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
		addEmployeeView.openWindow();
		
	}
	public void editEmployeePressed()
	{
		editEmployeeView = new editEmployeeView();
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
							//update(null,null);
						}
						else if(selected==1)
						{
							return;
						}
		}	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == getBtnAdd())
		{
			System.out.println("asdasd");
			addEmployeePressed();
		}
		if(e.getSource() == getBtnDelete())
		{
			deleteEmployeePressed();
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

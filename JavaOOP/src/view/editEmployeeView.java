package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Bean.Employee;
import Bean.EmployeeM;
import Bean.Titel;
import Bean.TitelM;
import db.DatabaseManager;

public class editEmployeeView extends Observable implements ActionListener {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField txtId;
	private JTextField txtSurname;
	private JTextField txtLastname;
	private JTextField txtAdress;
	private JTextField txtPostcode;
	private JTextField txtBirthday;
	private JTextField txtGross;
	private JTextField txtNet;
	private JComboBox<String> cbxTitel;
	private JLabel lblId;
	private JLabel lblTitel;
	private JLabel lblSurname;
	private JLabel lblLastname;
	private JLabel lblAdress;
	private JLabel lblPostcode;
	private JLabel lblBirthday;
	private JLabel lblGross;
	private JLabel lblNet;
	private JButton btnAddEmployee;
	private JButton btnCancel;
	private TitelM titelM = new TitelM();
	private EmployeeM employeeM;
	private Employee newemployee;
	private int index;
	
	public editEmployeeView(EmployeeM employeeM,int index) {
		this.employeeM = employeeM;
		this.index = index;
		frame = new JFrame("Edit Employee");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 427, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblId = new JLabel("ID");
		lblId.setBounds(27, 28, 61, 16);
		contentPane.add(lblId);
		
		lblTitel = new JLabel("Titel");
		lblTitel.setBounds(27, 56, 61, 16);
		contentPane.add(lblTitel);
		
		lblSurname = new JLabel("Surname");
		lblSurname.setBounds(27, 84, 61, 16);
		contentPane.add(lblSurname);
		
		lblLastname = new JLabel("Lastname");
		lblLastname.setBounds(27, 112, 61, 16);
		contentPane.add(lblLastname);
		
		lblAdress = new JLabel("Adress");
		lblAdress.setBounds(27, 142, 61, 16);
		contentPane.add(lblAdress);
		
		lblPostcode = new JLabel("Postcode");
		lblPostcode.setBounds(27, 170, 61, 16);
		contentPane.add(lblPostcode);
		
		lblBirthday = new JLabel("Birthday");
		lblBirthday.setBounds(27, 198, 61, 16);
		contentPane.add(lblBirthday);
		
		lblGross = new JLabel("Gross");
		lblGross.setBounds(27, 226, 61, 16);
		contentPane.add(lblGross);
		
		lblNet = new JLabel("Net");
		lblNet.setBounds(27, 254, 61, 16);
		contentPane.add(lblNet);
		
		btnAddEmployee = new JButton("Save");
		btnAddEmployee.setBounds(100, 287, 117, 29);
		contentPane.add(btnAddEmployee);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(218, 287, 117, 29);
		contentPane.add(btnCancel);
		
		txtId = new JTextField();
		txtId.setText("ID");
		txtId.setBounds(205, 23, 130, 26);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setText("surname");
		txtSurname.setBounds(205, 79, 130, 26);
		contentPane.add(txtSurname);
		txtSurname.setColumns(10);
		
		txtLastname = new JTextField();
		txtLastname.setText("lastname");
		txtLastname.setBounds(205, 107, 130, 26);
		contentPane.add(txtLastname);
		txtLastname.setColumns(10);
		
		txtAdress = new JTextField();
		txtAdress.setText("adress");
		txtAdress.setBounds(205, 137, 130, 26);
		contentPane.add(txtAdress);
		txtAdress.setColumns(10);
		
		txtPostcode = new JTextField();
		txtPostcode.setText("postcode");
		txtPostcode.setBounds(205, 165, 130, 26);
		contentPane.add(txtPostcode);
		txtPostcode.setColumns(10);
		
		txtBirthday = new JTextField();
		txtBirthday.setText("birthday");
		txtBirthday.setBounds(205, 193, 130, 26);
		contentPane.add(txtBirthday);
		txtBirthday.setColumns(10);
		
		txtGross = new JTextField();
		txtGross.setText("gross");
		txtGross.setBounds(205, 221, 130, 26);
		contentPane.add(txtGross);
		txtGross.setColumns(10);
		
		txtNet = new JTextField();
		txtNet.setText("net");
		txtNet.setBounds(205, 249, 130, 26);
		contentPane.add(txtNet);
		txtNet.setColumns(10);
		
		cbxTitel = new JComboBox<String>();
		cbxTitel.setBounds(205, 52, 130, 27);
		contentPane.add(cbxTitel);
		frame.setVisible(false);
	}
	public void openWindow()
	{
		try{
			DatabaseManager.verbinden();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try {
			titelM.loadTitles();
		} catch (SQLException e) {
			e.getErrorCode();
		}
		setzeAlleActionListener(this);
		fillComboBox();
		setFields();
		//felder deaktivieren
		txtId.setEnabled(false);
		txtNet.setEnabled(false);
		frame.setVisible(true);
	}
	public void setzeAlleActionListener(ActionListener l)
	{
		btnAddEmployee.addActionListener(l);
		btnCancel.addActionListener(l);
	}
	
	public void fillComboBox()
	{
		ArrayList<Titel> titelList = titelM.returnList();
		for(int i=0;i<titelList.size();i++)
		{
			cbxTitel.addItem(titelList.get(i).getTitles());
		}
	}
	public void setFields()
	{
		txtId.setText(Integer.toString(employeeM.getEmployeeID(index)));
		txtSurname.setText(employeeM.getEmployeeSurname(index));
		txtLastname.setText(employeeM.getEmployeeLastName(index));
		txtAdress.setText(employeeM.getEmployeeAdress(index));
		txtPostcode.setText(employeeM.getEmployeePostCode(index));
		txtBirthday.setText(employeeM.getEmployeeBirthday(index));
		txtGross.setText(Double.toString(employeeM.getEmployeeGross(index)));
		txtNet.setText(Double.toString(employeeM.getEmployeeNet(index)));
		cbxTitel.setSelectedItem(employeeM.getEmployeeTitel(index));
	}
	
	public String getIdFromTextfield()
	{
		return txtId.getText();
	}
	public String getSurnameFromTextfield()
	{
		return txtSurname.getText();
	}
	public String getLastnameFromTextfield()
	{
		return txtLastname.getText();
	}
	public String getAdressFromTextfield()
	{
		return txtAdress.getText();
	}
	public String getPostcodeFromTextfield()
	{
		return txtPostcode.getText();
	}
	public String getBirthdayFromTextfield()
	{
		return txtBirthday.getText();
	}
	public String getGrossFromTextfield()
	{
		return txtGross.getText();
	}
	public String getNetFromTextfield()
	{
		return txtNet.getText();
	}
	public String getTitleFromCbx()
	{
		return (String) cbxTitel.getSelectedItem();
	}
	public boolean checkFields()
	{
		if(getSurnameFromTextfield().isEmpty())
		{
			return false;
		}
		else if(getLastnameFromTextfield().isEmpty())
		{
			return false;
		}
		else if(getAdressFromTextfield().isEmpty())
		{
			return false;
		}
		else if(getPostcodeFromTextfield().isEmpty())
		{
			return false;
		}
		else if(getBirthdayFromTextfield().isEmpty())
		{
			return false;
		}
		else if(getGrossFromTextfield().isEmpty())
		{
			return false;
		}
		else if(getNetFromTextfield().isEmpty())
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public void setTextfieldsClear()
	{
		txtSurname.setText("");
		txtLastname.setText("");
		txtAdress.setText("");
		txtPostcode.setText("");
		txtBirthday.setText("");
		txtGross.setText("");
		txtNet.setText("");
	}
	public JButton getBtnAddEmployee()
	{
		return btnAddEmployee;
	}
	public JButton getBtnCancel()
	{
		return btnCancel;
	}
	private void calculateNet()
	{
		int gros = Integer.parseInt(getGrossFromTextfield());
		double net = gros * 0.61;
		txtNet.setText(Double.toString(net));
	}
	public void addpressed()
	{
		if(checkFields())
		{
			//calculate net
			calculateNet();
			int id = Integer.parseInt(getIdFromTextfield());
			String titel = getTitleFromCbx();
			String surname = getSurnameFromTextfield();
			String lastname = getLastnameFromTextfield();
			String adress = getAdressFromTextfield();
			String postcode = getPostcodeFromTextfield();
			String birthday = getBirthdayFromTextfield();
			double gross = Double.parseDouble(getGrossFromTextfield());
			double net = Double.parseDouble(getNetFromTextfield());
			newemployee = new Employee(id, titel, surname, lastname, adress, postcode, birthday, gross, net);
			try
			{
			employeeM.editEmployee(newemployee);
			super.setChanged();
			super.notifyObservers();
            JOptionPane.showMessageDialog(null,
                    "The employee was successfully added!",
                    "Failure Notification",JOptionPane.WARNING_MESSAGE);
            frame.dispose();
			
			}
			catch(Exception e1)
			{
			e1.printStackTrace();
			}
		}
		else
		{
            JOptionPane.showMessageDialog(null,
                    "You have to fill in all textfields",
                    "Failure Notification",JOptionPane.WARNING_MESSAGE);
		}	
	}
	public void cancelpressed()
	{
		frame.dispose();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == getBtnAddEmployee())
		{
			// addpressed
			addpressed();
		}
		else if(e.getSource() == getBtnCancel())
		{
			//cancel pressed
			cancelpressed();
		}
		
	}
}

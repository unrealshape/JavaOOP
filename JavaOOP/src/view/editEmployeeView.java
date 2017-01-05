package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class editEmployeeView extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtTitle;
	private JTextField txtSurname;
	private JTextField txtLastname;
	private JTextField txtAdress;
	private JTextField txtPostcode;
	private JTextField txtBirthday;
	private JTextField txtGross;
	private JTextField txtNet;
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
	
	public editEmployeeView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
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
		
		btnAddEmployee = new JButton("Add Employee");
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
		
		txtTitle = new JTextField();
		txtTitle.setText("title");
		txtTitle.setBounds(205, 51, 130, 26);
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);
		
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
	}
}

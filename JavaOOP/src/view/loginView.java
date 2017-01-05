package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Bean.login;
import Bean.loginM;
import db.DatabaseManager;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class loginView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtTeo;
	private JPasswordField passwordField;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JButton btnCancel;
	
	private loginM loginM = new loginM();
	private login userlogv = new login();
	private overview overview;
	
	public loginView() {
		setTitle("Login @ Personal Verwaltung");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsername = new JLabel("Username :");
		lblUsername.setBounds(50, 50, 78, 16);
		contentPane.add(lblUsername);
		lblPassword = new JLabel("Password :");
		lblPassword.setBounds(50, 79, 78, 16);
		contentPane.add(lblPassword);
		txtTeo = new JTextField();
		txtTeo.setText("erhan");
		txtTeo.setBounds(153, 45, 161, 26);
		contentPane.add(txtTeo);
		txtTeo.setColumns(10);
		passwordField = new JPasswordField();
		passwordField.setBounds(153, 74, 161, 26);
		contentPane.add(passwordField);
		passwordField.setText("cengiz");
		btnLogin = new JButton("LogIn");
		btnLogin.setBounds(98, 107, 117, 29);
		contentPane.add(btnLogin);
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(225, 107, 117, 29);
		contentPane.add(btnCancel);
	}
	public void openWindow() 
	{
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
			loginM.getAllLoginUsers();
		}
		catch(SQLException e)
		{
			System.err.println("Login User Daten runterladen Fehlgeshlagen " + e);
		}
		loginM.print();
		setzeAlleActionListener(this);
		this.setVisible(true);
	}
	public void setzeAlleActionListener(ActionListener l)
	{
		btnLogin.addActionListener(l);
		btnCancel.addActionListener(l);
	}
	private JButton getButtonLogin()
	{
		return btnLogin;
	}
	private JButton getButtonCancel()
	{
		return btnCancel;
	}
	
	public String getUsernameFromJTextfield() {
		return txtTeo.getText();
	}
	public String getPasswordFromJTextfield() {
		return passwordField.getText();
	}
	
	public void loginpressed()
	{
		String username=getUsernameFromJTextfield();
		String password=getPasswordFromJTextfield();
		userlogv = new login(username,password);
		
		if(username.equals("") || password.equals(""))
		{
			/*lblfail.setText("Please enter your username and password");
			lblfail.setForeground(Color.RED);
			lblfail.setVisible(true);*/
			System.err.println("ERROR FALSCHES PASSWORD ODER USERNAME!");
		}
		else
		{
				if(loginM.checkLogin2(userlogv))
				{
					/*lblfail.setText("Login Success");
					lblfail.setForeground(Color.GREEN);
					lblfail.setVisible(true);*/
					System.out.println("Nächstes Fenster soll geöffnet werden");
					overview = new overview();
					overview.openWindow();
					/*moviev movieWindow = new moviev();
					movieWindow.createWindow();*/
				}
				else
				{
					/*lblfail.setText("<html>invalid username/password <p/> "+                  
			                   "please try again</html>");
					lblfail.setForeground(Color.RED);
					lblfail.setVisible(true);*/
					System.err.println("fehlgeschlagen");
				}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == getButtonLogin())
		{
			loginpressed();
			System.out.println("LOGIN BUTTON WURDE GEDRUECKT");
		}
		else if(e.getSource() == getButtonCancel())
		{
			System.exit(0);
			System.out.println("Cancel BUTTON WURDE GEDRUECKT");
		}
		
		
	}
}

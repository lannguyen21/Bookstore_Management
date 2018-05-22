package tables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Color;

public class LoginForm {

	private JFrame login;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
					window.login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		login = new JFrame();
		login.getContentPane().setBackground(new Color(250, 240, 230));
		login.getContentPane().setLayout(null);
		login.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblUsername.setBounds(84, 85, 107, 33);
		login.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblPassword.setBounds(84, 121, 107, 45);
		login.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(206, 89, 225, 26);
		login.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(206, 131, 225, 26);
		login.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblBookstoreManagementLogin = new JLabel("Bookstore Management Login");
		lblBookstoreManagementLogin.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblBookstoreManagementLogin.setBounds(80, 16, 423, 45);
		login.getContentPane().add(lblBookstoreManagementLogin);
		
		Button btnLogin = new Button("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnLogin.addActionListener(this);
				login.setVisible(false);
				if(arg0.getSource().equals(btnLogin))
				{
					homeForm hf = new homeForm();
					hf.getHome().setVisible(true);
				}
			}
		});
		btnLogin.setBounds(206, 192, 91, 27);
		login.getContentPane().add(btnLogin);
		login.setBounds(100, 100, 566, 309);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JFrame getLogin() {
		return login;
	}

	public void setLogin(JFrame login) {
		this.login = login;
	}
}

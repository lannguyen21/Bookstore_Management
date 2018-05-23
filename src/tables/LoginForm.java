package tables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Color;
import javax.swing.ImageIcon;

public class LoginForm {

	private JFrame login;
	private JTextField textField;
	private JTextField password;

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
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblUsername.setBounds(84, 85, 107, 33);
		login.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblPassword.setBounds(84, 121, 107, 45);
		login.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(206, 89, 225, 26);
		login.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		password = new JPasswordField();
		password.setBounds(206, 131, 225, 26);
		login.getContentPane().add(password);
		password.setColumns(10);
		
		JLabel lblBookstoreManagementLogin = new JLabel("Bookstore Management Login");
		lblBookstoreManagementLogin.setForeground(new Color(255, 255, 255));
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
		
		JLabel backgound = new JLabel("");
		backgound.setIcon(new ImageIcon("C:\\Users\\Miko\\eclipse-workspace\\Bookstore_Management\\src\\login.jpg"));
		backgound.setBounds(0, 0, 554, 263);
		login.getContentPane().add(backgound);
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

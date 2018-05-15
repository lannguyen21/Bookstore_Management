package tables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 652, 533);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton Book = new JButton("Book");
		Book.setBounds(155, 17, 115, 42);
		frame.getContentPane().add(Book);
		
		JButton btnSelling = new JButton("Selling");
		btnSelling.setBounds(15, 17, 115, 42);
		frame.getContentPane().add(btnSelling);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(500, 24, 115, 29);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblBookstoreManagement = new JLabel("Bookstore Management");
		lblBookstoreManagement.setForeground(Color.BLUE);
		lblBookstoreManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookstoreManagement.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblBookstoreManagement.setBounds(51, 162, 522, 170);
		frame.getContentPane().add(lblBookstoreManagement);
	}
}

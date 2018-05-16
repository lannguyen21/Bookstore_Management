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
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Button;

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
		frame.setForeground(SystemColor.activeCaption);
		frame.getContentPane().setBackground(UIManager.getColor("window"));
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 916, 563);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Button Book = new Button("Book");
		Book.setBackground(new Color(152, 251, 152));
		Book.setFont(new Font("Dialog", Font.ITALIC, 20));
		Book.setBounds(556, 140, 249, 76);
		frame.getContentPane().add(Book);
		
		Button sell = new Button("Selling");
		sell.setBackground(new Color(152, 251, 152));
		sell.setFont(new Font("Dialog", Font.ITALIC, 20));
		sell.setBounds(556, 266, 239, 76);
		frame.getContentPane().add(sell);
		
		Button revenue = new Button("Revenue and Expenditure");
		revenue.setBackground(new Color(152, 251, 152));
		revenue.setFont(new Font("Dialog", Font.ITALIC, 20));
		revenue.setBounds(556, 399, 239, 76);
		frame.getContentPane().add(revenue);
		
		JLabel lblBookstoreManagement = new JLabel("Bookstore Management");
		lblBookstoreManagement.setForeground(new Color(60, 179, 113));
		lblBookstoreManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookstoreManagement.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 60));
		lblBookstoreManagement.setBounds(203, 16, 676, 76);
		frame.getContentPane().add(lblBookstoreManagement);
		
		JLabel lblNewLabel = new JLabel("Revenue and Expenditure");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Miko\\eclipse-workspace\\Bookstore_Management\\src\\background_home.png"));
		lblNewLabel.setBounds(0, 0, 894, 505);
		frame.getContentPane().add(lblNewLabel);
	}
}

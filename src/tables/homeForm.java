package tables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import java.awt.Color;

import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Button;

public class homeForm {

	private JFrame home;

	public JFrame getHome() {
		return home;
	}

	public void setHome(JFrame home) {
		this.home = home;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homeForm window = new homeForm();
					window.home.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public homeForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		home = new JFrame();
		//home.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//frame.setUndecorated(true);
		//frame.setVisible(true);
		home.setForeground(SystemColor.activeCaption);
		home.getContentPane().setBackground(UIManager.getColor("window"));
		home.getContentPane().setLayout(null);
		home.setBounds(100, 100, 916, 563);
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Button Book = new Button("Book");
		
		Book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(arg0.getSource().equals(Book))
				{
					Book.addActionListener(this);
					home.setVisible(false);
					BookForm bf = new BookForm();
					bf.getBookinfo().setVisible(true);
				}
			}
		});
		Book.setBackground(new Color(152, 251, 152));
		Book.setFont(new Font("Dialog", Font.ITALIC, 20));
		Book.setBounds(556, 140, 249, 76);
		home.getContentPane().add(Book);
		
		Button sell = new Button("Selling");
		sell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sell.addActionListener(this);
				home.setVisible(false);
				if(arg0.getSource().equals(sell))
				{
					SellForm sf = new SellForm();
					sf.getSelling().setVisible(true);
				}
			}
		});
		sell.setBackground(new Color(152, 251, 152));
		sell.setFont(new Font("Dialog", Font.ITALIC, 20));
		sell.setBounds(556, 266, 239, 76);
		home.getContentPane().add(sell);
		
		Button revenue = new Button("Revenue and Expenditure");
		revenue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				revenue.addActionListener(this);
				home.setVisible(false);
				if(arg0.getSource().equals(revenue))
				{
					Revenue_Table_Form rtf = new Revenue_Table_Form();
					rtf.getRevenue_table().setVisible(true);
				}
			}
		});
		revenue.setBackground(new Color(152, 251, 152));
		revenue.setFont(new Font("Dialog", Font.ITALIC, 20));
		revenue.setBounds(556, 399, 239, 76);
		home.getContentPane().add(revenue);
		
		JLabel lblBookstoreManagement = new JLabel("Bookstore Management");
		lblBookstoreManagement.setForeground(new Color(60, 179, 113));
		lblBookstoreManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookstoreManagement.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 60));
		lblBookstoreManagement.setBounds(203, 16, 676, 76);
		home.getContentPane().add(lblBookstoreManagement);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Miko\\eclipse-workspace\\Bookstore_Management\\src\\background_home.png"));
		lblNewLabel.setBounds(0, 0, 894, 505);
		home.getContentPane().add(lblNewLabel);
	}
}

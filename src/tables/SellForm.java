package tables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Label;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Button;
import java.awt.Color;

public class SellForm {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellForm window = new SellForm();
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
	public SellForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 813, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Label sell = new Label("Selling Management");
		sell.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		sell.setBounds(51, 10, 353, 41);
		frame.getContentPane().add(sell);
		
		Label BookID = new Label("BookID");
		BookID.setBounds(51, 69, 82, 27);
		frame.getContentPane().add(BookID);
		
		Label Price = new Label("Price");
		Price.setBounds(51, 119, 82, 27);
		frame.getContentPane().add(Price);
		
		Label Quantity = new Label("Quantity");
		Quantity.setBounds(51, 172, 82, 27);
		frame.getContentPane().add(Quantity);
		
		Label Date = new Label("Date");
		Date.setBounds(51, 224, 82, 27);
		frame.getContentPane().add(Date);
		
		textField = new JTextField();
		textField.setBounds(135, 70, 195, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(135, 119, 195, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(135, 173, 195, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(135, 225, 195, 26);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		Button Add = new Button("Add");
		Add.setBackground(new Color(240, 255, 255));
		Add.setBounds(51, 281, 91, 27);
		frame.getContentPane().add(Add);
		
		Button Search = new Button("Search");
		Search.setBackground(new Color(240, 255, 255));
		Search.setBounds(190, 281, 91, 27);
		frame.getContentPane().add(Search);
	}
}

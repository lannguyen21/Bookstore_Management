package tables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Button;
import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class BookForm {

	private JFrame frame;
	private JTextField name;
	private JTextField bookID;
	private JTextField Author;
	private JTextField Publisher;
	private JTextField quantity;
	private JTextField Type;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookForm window = new BookForm();
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
	public BookForm() {
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
		
		JLabel lblBookInfo = new JLabel("Book Information");
		lblBookInfo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblBookInfo.setBounds(78, 16, 318, 39);
		frame.getContentPane().add(lblBookInfo);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(36, 86, 69, 20);
		frame.getContentPane().add(lblName);
		
		JLabel lblNewLabel = new JLabel("BookID");
		lblNewLabel.setBounds(36, 135, 69, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(36, 183, 69, 20);
		frame.getContentPane().add(lblAuthor);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setBounds(36, 232, 69, 20);
		frame.getContentPane().add(lblPublisher);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(36, 268, 69, 32);
		frame.getContentPane().add(lblType);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(36, 316, 69, 20);
		frame.getContentPane().add(lblQuantity);
		
		name = new JTextField();
		name.setBounds(123, 83, 198, 26);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		bookID = new JTextField();
		bookID.setBounds(123, 132, 198, 26);
		frame.getContentPane().add(bookID);
		bookID.setColumns(10);
		
		Author = new JTextField();
		Author.setBounds(123, 180, 198, 26);
		frame.getContentPane().add(Author);
		Author.setColumns(10);
		
		Publisher = new JTextField();
		Publisher.setBounds(123, 229, 198, 26);
		frame.getContentPane().add(Publisher);
		Publisher.setColumns(10);
		
		quantity = new JTextField();
		quantity.setBounds(123, 313, 198, 26);
		frame.getContentPane().add(quantity);
		quantity.setColumns(10);
		
		Type = new JTextField();
		Type.setBounds(123, 271, 198, 26);
		frame.getContentPane().add(Type);
		Type.setColumns(10);
		
		Button btnAdd = new Button("Add");
		btnAdd.setBackground(new Color(245, 255, 250));
		btnAdd.setBounds(36, 377, 91, 27);
		frame.getContentPane().add(btnAdd);
		
		Button btnDelete = new Button("Delete");
		btnDelete.setBackground(new Color(245, 255, 250));
		btnDelete.setBounds(150, 377, 91, 27);
		frame.getContentPane().add(btnDelete);
		
		Button btnSearch = new Button("Search");
		btnSearch.setBackground(new Color(245, 255, 250));
		btnSearch.setBounds(266, 377, 91, 27);
		frame.getContentPane().add(btnSearch);
	}
}

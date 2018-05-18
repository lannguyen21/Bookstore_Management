package tables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Button;

public class SearchBookForm {

	private JFrame frame;
	private JTextField textBookID;

	public JTextField getTextBookID() {
		return textBookID;
	}

	public void setTextBookID(JTextField textBookID) {
		this.textBookID = textBookID;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBookForm window = new SearchBookForm();
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
	public SearchBookForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 702, 519);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Label search = new Label("Search Book");
		search.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		search.setBounds(28, 26, 338, 48);
		frame.getContentPane().add(search);
		
		Label BookID = new Label("BookID");
		BookID.setFont(new Font("Dialog", Font.PLAIN, 16));
		BookID.setBounds(28, 100, 77, 27);
		frame.getContentPane().add(BookID);
		
		textBookID = new JTextField();
		textBookID.setBounds(132, 100, 257, 27);
		frame.getContentPane().add(textBookID);
		textBookID.setColumns(10);
		
		Button btnSearch = new Button("Search");
		btnSearch.setBounds(422, 100, 91, 27);
		frame.getContentPane().add(btnSearch);
		
		Button home = new Button("Return Home");
		home.setBounds(544, 10, 126, 27);
		frame.getContentPane().add(home);
		
		Button btnBook = new Button("Book Information");
		btnBook.setBounds(406, 10, 118, 27);
		frame.getContentPane().add(btnBook);
		
		Button btnDelete = new Button("Delete");
		btnDelete.setBounds(579, 426, 91, 27);
		frame.getContentPane().add(btnDelete);
	}
}

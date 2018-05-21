package tables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchBookForm {

	private JFrame searchf;
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
					window.searchf.setVisible(true);
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
		searchf = new JFrame();
		searchf.setBounds(100, 100, 702, 519);
		searchf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		searchf.getContentPane().setLayout(null);
		
		Label search = new Label("Search Book");
		search.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		search.setBounds(28, 26, 338, 48);
		searchf.getContentPane().add(search);
		
		Label BookID = new Label("BookID");
		BookID.setFont(new Font("Dialog", Font.PLAIN, 16));
		BookID.setBounds(28, 100, 77, 27);
		searchf.getContentPane().add(BookID);
		
		textBookID = new JTextField();
		textBookID.setBounds(132, 100, 257, 27);
		searchf.getContentPane().add(textBookID);
		textBookID.setColumns(10);
		
		Button btnSearch = new Button("Search");
		btnSearch.setBounds(422, 100, 91, 27);
		searchf.getContentPane().add(btnSearch);
		
		Button home = new Button("Return Home");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home.addActionListener(this);
				searchf.setVisible(false);
				if(arg0.getSource().equals(home))
				{
					homeForm hf = new homeForm();
					hf.getHome().setVisible(true);
				}
			}
		});
		home.setBounds(544, 10, 126, 27);
		searchf.getContentPane().add(home);
		
		Button btnBook = new Button("Book Information");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnBook.addActionListener(this);
				searchf.setVisible(false);
				if(arg0.getSource().equals(btnBook))
				{
					BookForm bf = new BookForm();
					bf.getBookinfo().setVisible(true);
				}
			}
		});
		btnBook.setBounds(406, 10, 118, 27);
		searchf.getContentPane().add(btnBook);
		
		Button btnDelete = new Button("Delete");
		btnDelete.setBounds(579, 426, 91, 27);
		searchf.getContentPane().add(btnDelete);
	}

	public JFrame getSearchf() {
		return searchf;
	}

	public void setSearchf(JFrame searchf) {
		this.searchf = searchf;
	}
}

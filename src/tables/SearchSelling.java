package tables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchSelling {

	private JFrame searchSell;
	public JFrame getSearchSell() {
		return searchSell;
	}

	public void setSearchSell(JFrame searchSell) {
		this.searchSell = searchSell;
	}

	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchSelling window = new SearchSelling();
					window.searchSell.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchSelling() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		searchSell = new JFrame();
		searchSell.setBounds(100, 100, 702, 519);
		searchSell.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		searchSell.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(114, 100, 257, 27);
		searchSell.getContentPane().add(textField);
		
		Label bookID = new Label("BookID");
		bookID.setFont(new Font("Dialog", Font.PLAIN, 16));
		bookID.setBounds(10, 100, 77, 27);
		searchSell.getContentPane().add(bookID);
		
		Button search = new Button("Search");
		search.setBounds(404, 100, 91, 27);
		searchSell.getContentPane().add(search);
		
		Label searchSelling = new Label("Search Book");
		searchSelling.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		searchSelling.setBounds(10, 26, 338, 48);
		searchSell.getContentPane().add(searchSelling);
		
		Button returnHome = new Button("Return Home");
		returnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				returnHome.addActionListener(this);
				searchSell.setVisible(false);
				if(arg0.getSource().equals(returnHome))
				{
					homeForm hf = new homeForm();
					hf.getHome().setVisible(true);
				}
			}
		});
		returnHome.setBounds(526, 10, 126, 27);
		searchSell.getContentPane().add(returnHome);
		
		Button selling = new Button("Selling");
		selling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selling.addActionListener(this);
				searchSell.setVisible(false);
				if(arg0.getSource().equals(selling))
				{
					SellForm sf = new SellForm();
					sf.getSelling().setVisible(true);
				}
			}
		});
		selling.setBounds(369, 10, 126, 27);
		searchSell.getContentPane().add(selling);
	}
}

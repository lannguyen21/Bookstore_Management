package tables;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Label;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SearchBookForm {

	private JFrame searchf;
	private JTextField textBookID;
	private JTable table;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/QLS?autoReconnect=true&useSSL=false";

	static final String USER = "root";
	static final String PASS = "kannakamui";

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
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				Connection con = null;
				PreparedStatement st = null;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");

					System.out.println("Connecting to database...");
					con = DriverManager.getConnection(DB_URL,USER , PASS);

					System.out.println("Creating statement...");
					String sql;
					sql = "select * from BookInfo where BookID = ?";
					st = con.prepareStatement(sql);
					st.setString(1, textBookID.getText());
					ResultSet rs = st.executeQuery();
					
					model.setRowCount(0);
					try {	
						while(rs.next()) {
							String BookName = rs.getString(1);
							int BookID = rs.getInt(2);
							String Author = rs.getString(3);
							String Type = rs.getString(4);
							String Publisher = rs.getString(5);
							int Quantity = rs.getInt(6);
							
							Object[] content = {BookName, BookID, Author, Type, Publisher, Quantity};
							
							model.addRow(content);
							}
						} catch(Exception e) {
							e.printStackTrace();
					}
				} catch (SQLException se) {
					se.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (st != null)
							st.close();
					} catch (SQLException se2) {
					}
					try {
						if (con != null)
							con.close();
					} catch (SQLException se) {
						se.printStackTrace();
					}
				}
			}
		});
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
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 147, 655, 316);
		searchf.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 16, 612, 312);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "BookID", "Author", "Type", "Publisher", "Quantity"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(137);
		table.getColumnModel().getColumn(1).setPreferredWidth(91);
		table.getColumnModel().getColumn(2).setPreferredWidth(106);
		table.getColumnModel().getColumn(3).setPreferredWidth(92);
		table.getColumnModel().getColumn(4).setPreferredWidth(82);
		table.getColumnModel().getColumn(5).setPreferredWidth(73);
		scrollPane.setViewportView(table);
	}

	public JFrame getSearchf() {
		return searchf;
	}

	public void setSearchf(JFrame searchf) {
		this.searchf = searchf;
	}
}

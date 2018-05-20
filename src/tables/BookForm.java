package tables;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class BookForm {

	private JFrame frame;
	private JTextField name;
	private JTextField bookID;
	private JTextField Author;
	private JTextField Publisher;
	private JTextField quantity;
	private JTextField Type;
	private JTable table;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/QLS?autoReconnect=true&useSSL=false";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "kannakamui";
	
	
	/**
	 * Launch the application.
	 */
	public static void main1(String[] args) {
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


	
	 public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			con = DriverManager.getConnection(DB_URL,USER , PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			st = con.createStatement();
			String sql;
			sql = "SELECT Num, BookID, BookName, Author, BookType, Publisher FROM BookInfo";
			ResultSet rs = st.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int Num = rs.getInt("Num");
				int BookID = rs.getInt("BookID");
				String BookName = rs.getString("BookName");
				String Author = rs.getString("Author");
				String BookType = rs.getString("BookType");
				String Publisher = rs.getString("Publisher");

				// Display values
				System.out.print("Number: " + Num);
				System.out.print(", BookID: " + BookID);
				System.out.print(", BookName: " + BookName);
				System.out.print(", Author: " + Author);
				System.out.print(", BookType: " + BookType);
				System.out.println(", Publisher: " + Publisher);
			}
			// STEP 6: Clean-up environment
			rs.close();
			st.close();
			con.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (st != null)
					st.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 905, 519);
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
		
		JPanel panelTable = new JPanel();
		panelTable.setToolTipText("Table");
		panelTable.setBounds(394, 28, 474, 419);
		frame.getContentPane().add(panelTable);
		
		JScrollPane scrollPane = new JScrollPane();
		panelTable.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"No.", "BookID", "Name", "Author", "Type", "Publisher"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(85);
		table.getColumnModel().getColumn(2).setPreferredWidth(113);
		table.getColumnModel().getColumn(3).setPreferredWidth(97);
		table.getColumnModel().getColumn(4).setPreferredWidth(82);
		table.getColumnModel().getColumn(5).setPreferredWidth(93);
		scrollPane.setViewportView(table);
	}
}

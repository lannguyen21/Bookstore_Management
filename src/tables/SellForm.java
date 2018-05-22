package tables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Label;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;

public class SellForm {

	private JFrame selling;
	private JTextField bookID;
	private JTextField price;
	private JTextField quantity;
	private JTextField date;
	private JTable table;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/QLS?autoReconnect=true&useSSL=false";

	static final String USER = "root";
	static final String PASS = "kannakamui";
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellForm window = new SellForm();
					window.selling.setVisible(true);
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
		selling = new JFrame();
		selling.setBounds(100, 100, 813, 478);
		selling.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		selling.getContentPane().setLayout(null);
		
		Label sell = new Label("Selling Management");
		sell.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		sell.setBounds(51, 10, 278, 41);
		selling.getContentPane().add(sell);
		
		Label BookID = new Label("BookID");
		BookID.setBounds(51, 69, 82, 27);
		selling.getContentPane().add(BookID);
		
		Label Price = new Label("Price");
		Price.setBounds(51, 119, 82, 27);
		selling.getContentPane().add(Price);
		
		Label Quantity = new Label("Quantity");
		Quantity.setBounds(51, 172, 82, 27);
		selling.getContentPane().add(Quantity);
		
		Label Date = new Label("Date");
		Date.setBounds(51, 224, 82, 27);
		selling.getContentPane().add(Date);
		
		Label fillID = new Label("");
		fillID.setForeground(Color.RED);
		fillID.setBounds(139, 97, 157, 20);
		selling.getContentPane().add(fillID);
		
		bookID = new JTextField();
		bookID.setBounds(135, 70, 195, 26);
		selling.getContentPane().add(bookID);
		bookID.setColumns(10);
		
		price = new JTextField();
		price.setBounds(135, 119, 195, 26);
		selling.getContentPane().add(price);
		price.setColumns(10);
		
		quantity = new JTextField();
		quantity.setBounds(135, 173, 195, 26);
		selling.getContentPane().add(quantity);
		quantity.setColumns(10);
		
		date = new JTextField();
		date.setBounds(135, 225, 195, 26);
		selling.getContentPane().add(date);
		date.setColumns(10);
		
		Button Add = new Button("Add");
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                Selling sell = new Selling();
				
				fillID.setText("");
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				if(!bookID.getText().trim().equals(""))
				{
				sell.setBookID(Integer.parseInt(bookID.getText()));
				sell.setPrice(Integer.parseInt(price.getText()));
				sell.setQuantity(Integer.parseInt(quantity.getText()));
				sell.setDate(date.getText());
				}
				else {
					fillID.setText("BookID must be filled");
				}
				
				Connection con = null;
				PreparedStatement st = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");

					System.out.println("Connecting to database...");
					con = DriverManager.getConnection(DB_URL,USER , PASS);

					// STEP 4: Execute a query
					System.out.println("Creating statement...");
					String sql;
					sql = "Insert into Selling (BookID, Price, Quantity, Dates) values (?, ?, ?, ?)";
					st = con.prepareStatement(sql);					
					
					st.setInt(1, sell.getBookID());
					st.setInt(2, sell.getPrice());
					st.setInt(3, sell.getQuantity());
					st.setString(4, sell.getDate());
					
					int rs = st.executeUpdate();
					
					if (rs != -1) {
						  JOptionPane.showMessageDialog(Add, "This book has been added");  
						 }
					st.close();
					con.close();
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
				model.setRowCount(0);
				ConnectionSQL conSQL = new ConnectionSQL();
				try {
					conSQL.rs = conSQL.st.executeQuery("select * from Selling");
					
					while(conSQL.rs.next()) {
						
						int BookID = conSQL.rs.getInt(1);
						int Price = conSQL.rs.getInt(2);
						int Quantity = conSQL.rs.getInt(3);
						String Date = conSQL.rs.getString(4);
						
						Object[] content = {BookID, Price, Quantity, Date};
						
						model.addRow(content);
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Add.setBackground(SystemColor.menu);
		Add.setBounds(42, 281, 91, 27);
		selling.getContentPane().add(Add);
		
		Button Search = new Button("Search");
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Search.addActionListener(this);
				selling.setVisible(false);
				if(arg0.getSource().equals(Search))
				{
					SearchSelling sf = new SearchSelling();
					sf.getSearchSell().setVisible(true);
				}
			}
		});
		Search.setBackground(SystemColor.menu);
		Search.setBounds(240, 281, 91, 27);
		selling.getContentPane().add(Search);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnReturn.addActionListener(this);
				selling.setVisible(false);
				if(arg0.getSource().equals(btnReturn))
				{
					homeForm hf = new homeForm();
					hf.getHome().setVisible(true);
				}
			}
		});
		btnReturn.setBackground(SystemColor.menu);
		btnReturn.setBounds(51, 344, 91, 29);
		selling.getContentPane().add(btnReturn);
		
		Button btnDelete = new Button("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Selling sell = new Selling();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				sell.setBookID(Integer.parseInt(bookID.getText()));
				
				ConnectionSQL conSQL = new ConnectionSQL();
				Connection con = null;
				PreparedStatement st = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");

					con = DriverManager.getConnection(DB_URL,USER , PASS);

					String sql = "Delete from Selling where BookID = ?";
					st = con.prepareStatement(sql);		
					st.setInt(1, Integer.parseInt(bookID.getText()));
					st.execute();
                    int rs = st.executeUpdate();
					
					if (rs != -1) {
						  JOptionPane.showMessageDialog(btnDelete, "This book has been deleted");  
						 }
					st.close();
					con.close();
				}catch (Exception e)
			    {
				      System.err.println("Got an exception! ");
				      System.err.println(e.getMessage());
				    }
				
				model.setRowCount(0);
				try {
					conSQL.rs = conSQL.st.executeQuery("select * from Selling");
					
					while(conSQL.rs.next()) {
						int BookID = conSQL.rs.getInt(1);
						int Price = conSQL.rs.getInt(2);
						int Quantity = conSQL.rs.getInt(3);
						String Date = conSQL.rs.getString(4);
						
						Object[] content = {BookID, Price, Quantity, Date};
						
						model.addRow(content);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(143, 281, 91, 27);
		selling.getContentPane().add(btnDelete);
		
		JPanel panelTable = new JPanel();
		panelTable.setToolTipText("Table");
		panelTable.setBounds(335, 10, 533, 437);
		selling.getContentPane().add(panelTable);
		panelTable.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 5, 437, 416);
		panelTable.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"BookID", "Price", "Quantity", "Dates"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(137);
		table.getColumnModel().getColumn(1).setPreferredWidth(91);
		table.getColumnModel().getColumn(2).setPreferredWidth(106);
		table.getColumnModel().getColumn(3).setPreferredWidth(92);
		scrollPane.setViewportView(table);
	}

	public JFrame getSelling() {
		return selling;
	}

	public void setSelling(JFrame selling) {
		this.selling = selling;
	}
}

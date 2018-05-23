package tables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Label;
import java.awt.Font;
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
import java.awt.Color;

public class SearchSelling {

	private JFrame searchSell;
	public JFrame getSearchSell() {
		return searchSell;
	}

	public void setSearchSell(JFrame searchSell) {
		this.searchSell = searchSell;
	}

	private JTextField textSell_ID;
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
		searchSell.getContentPane().setBackground(new Color(250, 240, 230));
		searchSell.setBounds(100, 100, 702, 519);
		searchSell.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		searchSell.getContentPane().setLayout(null);
		
		textSell_ID = new JTextField();
		textSell_ID.setColumns(10);
		textSell_ID.setBounds(114, 100, 257, 27);
		searchSell.getContentPane().add(textSell_ID);
		
		Label sellID = new Label("Sell_ID");
		sellID.setFont(new Font("Dialog", Font.PLAIN, 16));
		sellID.setBounds(10, 100, 77, 27);
		searchSell.getContentPane().add(sellID);
		
		Button search = new Button("Search");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				Connection con = null;
				PreparedStatement st = null;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");

					con = DriverManager.getConnection(DB_URL,USER , PASS);

					String sql;
					sql = "select * from Selling where SellID = ?";
					st = con.prepareStatement(sql);
					st.setString(1, textSell_ID.getText());
					ResultSet rs = st.executeQuery();
					
					model.setRowCount(0);
					try {	
						while(rs.next()) {
							int SellID = rs.getInt(1);
							int BookID = rs.getInt(2);
							int Price = rs.getInt(3);
							int Quantity = rs.getInt(4);
							String Date = rs.getString(5);
							
							Object[] content = {SellID, BookID, Price, Quantity, Date};
							
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
		search.setBounds(404, 100, 91, 27);
		searchSell.getContentPane().add(search);
		
		Label searchSelling = new Label("Search Selling Book");
		searchSelling.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		searchSelling.setBounds(29, 26, 319, 48);
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 240, 230));
		panel.setBounds(15, 146, 637, 317);
		searchSell.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 5, 607, 322);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Sell_ID", "BookID", "Price", "Quantity", "Dates"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(102);
		table.getColumnModel().getColumn(1).setPreferredWidth(91);
		table.getColumnModel().getColumn(2).setPreferredWidth(106);
		table.getColumnModel().getColumn(3).setPreferredWidth(92);
		scrollPane.setViewportView(table);
	}
}

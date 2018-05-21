package tables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Revenue_Table_Form {

	private JFrame revenue_table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Revenue_Table_Form window = new Revenue_Table_Form();
					window.revenue_table.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Revenue_Table_Form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		revenue_table = new JFrame();
		revenue_table.getContentPane().setLayout(null);
		
		Button btnGraph = new Button("Graph");
		btnGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnGraph.addActionListener(this);
				revenue_table.setVisible(false);
				if(arg0.getSource().equals(btnGraph))
				{
					Revenue_Graph_Form rgf = new Revenue_Graph_Form();
					rgf.getRevenue_graph().setVisible(true);
				}
			}
		});
		btnGraph.setBounds(628, 10, 119, 27);
		revenue_table.getContentPane().add(btnGraph);
		
		JLabel lblRevenue = new JLabel("Revenue and Expenditure");
		lblRevenue.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblRevenue.setBounds(141, 10, 392, 44);
		revenue_table.getContentPane().add(lblRevenue);
		revenue_table.setBounds(100, 100, 779, 545);
		
		revenue_table.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JFrame getRevenue_table() {
		return revenue_table;
	}

	public void setRevenue_table(JFrame revenue_table) {
		this.revenue_table = revenue_table;
	}

}

package tables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Revenue_Graph_Form {

	private JFrame revenue_graph;

	public JFrame getRevenue_graph() {
		return revenue_graph;
	}

	public void setRevenue_graph(JFrame revenue_graph) {
		this.revenue_graph = revenue_graph;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Revenue_Graph_Form window = new Revenue_Graph_Form();
					window.revenue_graph.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Revenue_Graph_Form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		revenue_graph = new JFrame();
		revenue_graph.setBounds(100, 100, 779, 545);
		revenue_graph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		revenue_graph.getContentPane().setLayout(null);
		
		Button btnTable = new Button("Table");
		btnTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnTable.addActionListener(this);
				revenue_graph.setVisible(false);
				if(arg0.getSource().equals(btnTable))
				{
					Revenue_Table_Form rtf = new Revenue_Table_Form();
					rtf.getRevenue_table().setVisible(true);
				}
			}
		});
		btnTable.setBounds(656, 10, 91, 27);
		revenue_graph.getContentPane().add(btnTable);
	}

}

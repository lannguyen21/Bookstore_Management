package tables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Revenue_Table {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Revenue_Table window = new Revenue_Table();
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
	public Revenue_Table() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		Button btnGraph = new Button("Graph");
		btnGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGraph.setBounds(628, 10, 119, 27);
		frame.getContentPane().add(btnGraph);
		
		JLabel lblRevenue = new JLabel("Revenue and Expenditure");
		lblRevenue.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblRevenue.setBounds(141, 10, 392, 44);
		frame.getContentPane().add(lblRevenue);
		frame.setBounds(100, 100, 779, 545);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

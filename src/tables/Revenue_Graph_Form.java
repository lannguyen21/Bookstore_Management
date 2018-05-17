package tables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Button;

public class Revenue_Graph_Form {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Revenue_Graph_Form window = new Revenue_Graph_Form();
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
	public Revenue_Graph_Form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 779, 545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Button btnTable = new Button("Table");
		btnTable.setBounds(656, 10, 91, 27);
		frame.getContentPane().add(btnTable);
	}

}

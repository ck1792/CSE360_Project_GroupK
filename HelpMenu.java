import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class HelpMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void HelpScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpMenu window = new HelpMenu();
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
	public HelpMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHelpMenu = new JLabel("Help Menu");
		lblHelpMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelpMenu.setBounds(175, 26, 82, 16);
		frame.getContentPane().add(lblHelpMenu);
		
		JLabel lblInputOptionWill = new JLabel("Input Option: Will allow the user to enter multiple occurances of ");
		lblInputOptionWill.setBounds(6, 54, 438, 23);
		frame.getContentPane().add(lblInputOptionWill);
		
		JLabel lblActivityNamesDurations = new JLabel("activity names, durations and a list of dependencies");
		lblActivityNamesDurations.setBounds(92, 71, 352, 23);
		frame.getContentPane().add(lblActivityNamesDurations);
	}
}

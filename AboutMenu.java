import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class AboutMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void AboutScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutMenu window = new AboutMenu();
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
	public AboutMenu() {
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
		
		JTextArea txtrProjectTheProgram = new JTextArea();
		txtrProjectTheProgram.setText("Project Overview: The program is to analyze a network diagram \nand determine all the paths in the netwrok");
		txtrProjectTheProgram.setBounds(6, 109, 438, 39);
		frame.getContentPane().add(txtrProjectTheProgram);
		
		JTextArea txtrTeamMembersDekart = new JTextArea();
		txtrTeamMembersDekart.setText("Team Members: Dekart Kosa, Xiang Li, Jiwon Kim, Kai Chen");
		txtrTeamMembersDekart.setBounds(6, 160, 438, 21);
		frame.getContentPane().add(txtrTeamMembersDekart);
		
		JLabel lblAboutMenu = new JLabel("About Menu");
		lblAboutMenu.setBounds(186, 37, 76, 21);
		frame.getContentPane().add(lblAboutMenu);
	}
}

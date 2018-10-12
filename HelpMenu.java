/*
HelpMenu.java by Dekart Kosa, Xiang Li
version 1.1
*/
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHelpMenu = new JLabel("Help Menu");
		lblHelpMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelpMenu.setBounds(175, 16, 82, 16);
		frame.getContentPane().add(lblHelpMenu);
		
		JTextArea txtrInputOptionWill = new JTextArea();
		txtrInputOptionWill.setWrapStyleWord(true);
		txtrInputOptionWill.setEditable(false);
		txtrInputOptionWill.setLineWrap(true);
		txtrInputOptionWill.setText("Input Option: Allows the user to enter multiple occurances of Activity names, Durations and a list of dependencies. Activity names can be multiple charaters and Durations must be integers. The user needs to add the first set of node in the text fields and then click the Add Node button. And repeat until they have entered all the neccasry inputs. Lastly they need to click the process button inorder to comple the processing and show the output\n\nError Messages: If an error occurs the user needs to restart.\n\nQuit: Quitting the progam completely is done by either clicking the quit button in the Main Menu or clicking the X from any window.");
		txtrInputOptionWill.setBounds(6, 44, 438, 200);
		frame.getContentPane().add(txtrInputOptionWill);
		
		JButton btnReturnToMain = new JButton("Return to Main Menu");
		btnReturnToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu nw = new MainMenu();
				nw.main(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnReturnToMain.setBounds(147, 243, 154, 29);
		frame.getContentPane().add(btnReturnToMain);
	}
}

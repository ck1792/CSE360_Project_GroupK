/*
AboutMenu.java by Dekart Kosa, Xiang Li
Version 1.1
*/
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrProjectTheProgram = new JTextArea();
		txtrProjectTheProgram.setEditable(false);
		txtrProjectTheProgram.setText("Project Overview: The program is to analyze a network diagram \nand determine all the paths in the netwrok");
		txtrProjectTheProgram.setBounds(6, 70, 438, 39);
		frame.getContentPane().add(txtrProjectTheProgram);
		
		JTextArea txtrTeamMembersDekart = new JTextArea();
		txtrTeamMembersDekart.setBackground(Color.WHITE);
		txtrTeamMembersDekart.setEditable(false);
		txtrTeamMembersDekart.setText("Team Members: Dekart Kosa, Xiang Li, Jiwon Kim, Kai Chen");
		txtrTeamMembersDekart.setBounds(6, 121, 438, 21);
		frame.getContentPane().add(txtrTeamMembersDekart);
		
		JLabel lblAboutMenu = new JLabel("About Menu");
		lblAboutMenu.setBounds(186, 37, 76, 21);
		frame.getContentPane().add(lblAboutMenu);
		
		JButton btnReturnToMain = new JButton("Return to Main Menu");
		btnReturnToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu nw = new MainMenu();
				nw.main(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnReturnToMain.setBounds(151, 211, 174, 29);
		frame.getContentPane().add(btnReturnToMain);
	}
}

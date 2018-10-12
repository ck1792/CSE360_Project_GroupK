/*
MainMenu.java by Dekart Kosa, Xiang Li
version 1.0
*/
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
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
	public MainMenu() {
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
		
		JButton btnInput = new JButton("Input");
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InputMenu nw = new InputMenu();
				nw.NewScreen();
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnInput.setBounds(173, 94, 117, 29);
		frame.getContentPane().add(btnInput);
		
		JButton btnNewButton = new JButton("Help");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpMenu nw = new HelpMenu();
				nw.HelpScreen();
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(173, 176, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutMenu nw = new AboutMenu();
				nw.AboutScreen();
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnAbout.setBounds(173, 135, 117, 29);
		frame.getContentPane().add(btnAbout);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuit.setBounds(173, 217, 117, 29);
		frame.getContentPane().add(btnQuit);
		
		JLabel lblNewLabel = new JLabel("Main Menu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(173, 22, 117, 29);
		frame.getContentPane().add(lblNewLabel);
	}
}

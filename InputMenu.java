import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class InputMenu extends JFrame{

	private JFrame frame;
	private JTextField activity;
	private JTextField dependencies;
	private JTextField duration;
	private JTextField output;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputMenu window = new InputMenu();
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
	public InputMenu() {
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
		
		JButton btnNewButton = new JButton("Process");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OutputWindow nw = new OutputWindow();
				nw.OutputScreen();
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(98, 232, 88, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblInputMenu = new JLabel("Input Menu");
		lblInputMenu.setBounds(186, 16, 71, 16);
		frame.getContentPane().add(lblInputMenu);
		
		activity = new JTextField();
		activity.setBounds(250, 47, 130, 26);
		frame.getContentPane().add(activity);
		activity.setColumns(10);
		
		dependencies = new JTextField();
		dependencies.setBounds(250, 85, 130, 26);
		frame.getContentPane().add(dependencies);
		dependencies.setColumns(10);
		
		duration = new JTextField();
		duration.setBounds(250, 123, 130, 26);
		frame.getContentPane().add(duration);
		duration.setColumns(10);
		
		JLabel lblActivity = new JLabel("Activity");
		lblActivity.setBounds(63, 52, 61, 16);
		frame.getContentPane().add(lblActivity);
		
		JLabel lblDependencies = new JLabel("Dependencies");
		lblDependencies.setBounds(63, 80, 88, 23);
		frame.getContentPane().add(lblDependencies);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setBounds(63, 115, 61, 16);
		frame.getContentPane().add(lblDuration);
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activity.setText("");
				dependencies.setText("");
				duration.setText("");
			}
		});
		btnRestart.setBounds(366, 232, 78, 29);
		frame.getContentPane().add(btnRestart);
		
		JButton btnReturnToMenu = new JButton("Return to Main Menu");
		btnReturnToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu nw = new MainMenu();
				nw.main(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnReturnToMenu.setBounds(198, 232, 156, 29);
		frame.getContentPane().add(btnReturnToMenu);
		
		output = new JTextField();
		output.setEditable(false);
		output.setBounds(186, 161, 194, 26);
		frame.getContentPane().add(output);
		output.setColumns(10);
		
		JButton btnAdd = new JButton("Add Node");
		btnAdd.setBounds(6, 232, 88, 29);
		frame.getContentPane().add(btnAdd);
		
		JLabel lblOutput = new JLabel("Output");
		lblOutput.setBounds(63, 166, 61, 16);
		frame.getContentPane().add(lblOutput);
	}
}

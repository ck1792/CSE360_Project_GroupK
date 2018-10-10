import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InputMenu {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Process");
		btnNewButton.setBounds(6, 232, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblInputMenu = new JLabel("Input Menu");
		lblInputMenu.setBounds(186, 37, 71, 16);
		frame.getContentPane().add(lblInputMenu);
		
		textField = new JTextField();
		textField.setBounds(250, 84, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(250, 122, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(250, 160, 130, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblActivity = new JLabel("Activity");
		lblActivity.setBounds(63, 89, 61, 16);
		frame.getContentPane().add(lblActivity);
		
		JLabel lblDependencies = new JLabel("Dependencies");
		lblDependencies.setBounds(63, 125, 88, 23);
		frame.getContentPane().add(lblDependencies);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setBounds(63, 165, 61, 16);
		frame.getContentPane().add(lblDuration);
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.setBounds(327, 232, 117, 29);
		frame.getContentPane().add(btnRestart);
		
		JButton btnReturnToMenu = new JButton("Return to Menu");
		btnReturnToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu nw = new MainMenu();
				nw.main(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnReturnToMenu.setBounds(159, 232, 129, 29);
		frame.getContentPane().add(btnReturnToMenu);
		
		JLabel lblOutput = new JLabel("Output");
		lblOutput.setBounds(63, 204, 61, 16);
		frame.getContentPane().add(lblOutput);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(250, 204, 130, 16);
		frame.getContentPane().add(textArea);
	}
}

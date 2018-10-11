import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OutputWindow {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void OutputScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OutputWindow window = new OutputWindow();
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
	public OutputWindow() {
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
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(50, 49, 348, 154);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblOutput = new JLabel("Output");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(186, 20, 61, 16);
		frame.getContentPane().add(lblOutput);
		
		JButton btnReturnToInput = new JButton("Return to Input");
		btnReturnToInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InputMenu nw = new InputMenu();
				nw.NewScreen();
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnReturnToInput.setBounds(164, 227, 133, 29);
		frame.getContentPane().add(btnReturnToInput);
	}

}

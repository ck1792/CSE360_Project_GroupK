import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class InputMenu extends JFrame{
	
	private Input_node head;
	private int counter = 0;
	private String print = "";

	private JFrame frame;
	private JTextField activity;
	private JTextField dependencies;
	private JTextField duration;
	private JTextField output;
	private JTextField textField;
	private int error_message = 0;
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
		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
//				OutputWindow nw = new OutputWindow();
//				nw.OutputScreen();
//				frame.setVisible(false);
//				frame.dispose();
			
		
		
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
				head = null;
				counter = 0;
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
		//
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = activity.getText();
				String b = dependencies.getText();
				int c = 0;
				try{
					c = Integer.parseInt(duration.getText());
					Input_node node = new Input_node(a,b,c);
					counter += 1;
					if(head == null){
						head = node;
					}
					else{
						Input_node temp = head;
						while(true){
							if(temp.get_next() == null){
								break;
							}
							temp = temp.get_next();
						}
						temp.set_next(node);
					}
					activity.setText("");
					dependencies.setText("");
					duration.setText("");
					output.setText("Please enter next values.");
				} catch(NumberFormatException exception){
					//fails
					output.setText("Duration must be integer.");
				}
			}
		});
		//
		btnAdd.setBounds(6, 232, 88, 29);
		frame.getContentPane().add(btnAdd);
		
		JLabel lblOutput = new JLabel("Output");
		lblOutput.setBounds(63, 166, 61, 16);
		frame.getContentPane().add(lblOutput);
		
		JLabel lblOutput2 = new JLabel("Output");
		lblOutput2.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput2.setBounds(186, 320, 61, 16);
		frame.getContentPane().add(lblOutput2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(50, 349, 348, 134);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton output = new JButton("Process");
		output.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(get_print());
			}
		});
		output.setBounds(182, 495, 100, 29);
		frame.getContentPane().add(output);
	}
	//
	public void matcherror() {
		String testing = "";
		Input_node temp3 = head;
	for(int i = 0; i < counter; i++) {
		boolean match = false;
		testing = temp3.get_activity();
		if(temp3.get_dependency().equals(testing)) {
			Input_node temp4 = head;
		for(int j = 0; j < counter; j++) {
			if(temp3.get_dependency() != testing){
				if(temp3.get_dependency() == temp4.get_activity()){
					match = true;
				}
				}
			 temp4 = temp4.get_next();
			}
		}
		else {
			match = true;
		}
		if(match == false) {
			error_message = 1;
		}
		
		temp3= temp3.get_next();
	}
	}
	
	public void cycle_check() {
		Input_node temp = head;
		int cyclecounter = 0;
		for(int i =0; i < counter; i++) {
			if(temp.get_dependency().equals("")) {
				cyclecounter++; //will + on cycle counter to counter if no dependency is checked
			
			}
			temp = temp.get_next();
		}
		
		if(cyclecounter == 0) {
			error_message = 1;
		}else {
			error_message = 0;
		}
	}

	public void sort() {
		Input_node temp = head;
		Input_node temp2 = head;
		for (int i = 0; i < counter; i++) {
			int min = 9999;
			for( int j = 0; j < counter; j++) {
				if(temp.get_duration() < min) {
					temp.set_index(i);
					min = temp.get_duration();
					temp2.set_index(999);//this will make the index set before to some other value high
				}
				if(temp.get_duration() == min) {
					temp2.set_index(i+1);
					temp.set_index(i);
				}
			
				temp2 = temp;
				temp = temp.get_next();
			}
		}
		sortbyindex();//indexed every nodes, need to sort by index
	}
	
	public void sortbyindex() {
		Input_node temp = head;
		Input_node temp2 = head;
		for(int i = 0; i < counter; i++) {
			for(int j = 0; j < counter; j++) {
				if(temp.get_index() < temp.get_next().get_index()) {
					temp2 = temp.get_next();
					temp.set_next(temp);
					temp = temp2;
				}
				temp = temp.get_next();
				
			}
		}
	
	}
	//
	public String get_print(){
		//
		matcherror();
		cycle_check();
		sort();
		//
		Input_node temp2 = head;
		print = "";
		for(int i = 0; i < counter; i++){
			print = print + temp2.get_activity() + " ";
			print = print + temp2.get_dependency() + " ";
			print = print + temp2.get_duration() + " ";
			temp2 = temp2.get_next();
		}
		if (error_message == 1) {
		return ("Error has occurred");
		}else {
			return print;
		}
	}
	//must have a dependency, must be mentioned in dependency
	//error check for all nodes must be connected
	
	//there cannot be a cycle
	
}

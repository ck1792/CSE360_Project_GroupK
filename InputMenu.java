/*
MainMenu.java by Dekart Kosa, Xiang Li, Kai Chen
version 2.2
*/

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class InputMenu extends JFrame{
	
	private ArrayList<Input_node> node_list = new ArrayList<Input_node>();
	private ArrayList<ArrayList<Integer>> path_list = new ArrayList<ArrayList<Integer>>();
	private ArrayList<Integer> duration_list = new ArrayList<Integer>();
	private ArrayList<String> output_list = new ArrayList<String>();
//	private Input_node head;
//	private int counter = 0;
	/*
	 * 0: no error
	 * 1: disconnect
	 * 2: cycle
	 */
	private int error_message = 0;

	private JFrame frame;
	private JTextField activity;
	private JTextField dependencies;
	private JTextField duration;
	private JTextField output;
	private JTextArea textField;
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
				node_list.clear();
				activity.setText("");
				dependencies.setText("");
				duration.setText("");
//				head = null;
//				counter = 0;
				textField.setText("");
				output.setText("Restart completed.");
			}
		});
		btnRestart.setBounds(320, 210, 78, 29);
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
		btnReturnToMenu.setBounds(152, 210, 156, 29);
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
				if(a.equals("")){
					output.setText("Please input activity.");
				}
				else{
					String b = dependencies.getText();
					int c = 0;
					try{
						c = Integer.parseInt(duration.getText());
						if(c == 0){
							output.setText("Duration can not be 0.");
						}
						else{
							Input_node node = new Input_node(a,b,c);
							node_list.add(node);
//							counter += 1;
//							if(head == null){
//								head = node;
//							}
//							else{
//								Input_node temp = head;
//								while(true){
//									if(temp.get_next() == null){
//										break;
//									}
//									temp = temp.get_next();
//								}
//								temp.set_next(node);
//							}
							activity.setText("");
							dependencies.setText("");
							duration.setText("");
							output.setText("A new node has been added.");
						}
					} catch(NumberFormatException exception){
						//fails
						output.setText("Duration must be integer.");
					}
				}
			}
		});
		//
		btnAdd.setBounds(52, 210, 88, 29);
		frame.getContentPane().add(btnAdd);
		
		JLabel lblOutput = new JLabel("Message");
		lblOutput.setBounds(63, 166, 61, 16);
		frame.getContentPane().add(lblOutput);
		
		JLabel lblOutput2 = new JLabel("Output");
		lblOutput2.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput2.setBounds(186, 260, 61, 16);
		frame.getContentPane().add(lblOutput2);
		
		textField = new JTextArea();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setEditable(false);
		textField.setBounds(50, 290, 350, 220);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton output = new JButton("Process");
		output.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField.append(print());
			}
		});
		output.setBounds(171, 520, 100, 29);
		frame.getContentPane().add(output);
	}
	
	public void output()
	{
		path_list.clear();
		disconnect();
		if(error_message == 1){
		}
		else{
			//find starting point
			int starting_point = 0;
			for(int i = 0; i < node_list.size(); i++){
				if(node_list.get(i).get_dependency().equals("")){
					starting_point = i;
				}
			}
			ArrayList<Integer> new_path = new ArrayList<Integer>();
			new_path.add(starting_point);
			path_list.add(new_path);
			output_subfunction(starting_point, 0);
		}
		
	}
	
	public void output_subfunction(int index, int path_index){
		boolean first_call = true;
		for(int i = 0; i < node_list.size(); i++){
			ArrayList<String> dependencies_list = get_dependencies(node_list.get(i).get_dependency());
//			if(dependencies_list.size() == 0){
//				dependencies_list.add(node_list.get(i).get_dependency());
//			}
			for(int j = 0; j < dependencies_list.size(); j++){
				if(dependencies_list.get(j).equals(node_list.get(index).get_activity())){
					if(first_call){
						first_call = false;
						cycle(i,path_index);
						if(error_message == 2){
						}
						else{
							path_list.get(path_index).add(i);
							output_subfunction(i, path_index);
						}
					}
					else{
						ArrayList<Integer> new_path = new ArrayList<Integer>();
						for(int k = 0; k < path_list.get(path_index).size(); k++){
							new_path.add(path_list.get(path_index).get(k));
							if(path_list.get(path_index).get(k) == index){
								k = path_list.get(path_index).size();
							}
						}
						path_list.add(new_path);
						cycle(i,path_list.size()-1);
						if(error_message == 2){
						}
						else{
							path_list.get(path_list.size()-1).add(i);
							output_subfunction(i, path_list.size()-1);
						}
					}
				}
			}
		}
	}
	
	//connection check
	/*
	 * if there are more than 1 starting points,
	 * then it is a disconnect error.
	 */
	public void disconnect()
	{
		int starting_point_counter = 0;
		for(int i = 0; i < node_list.size(); i++){
			if(node_list.get(i).get_dependency().equals("")){
				starting_point_counter += 1;
			}
		}
		if(starting_point_counter != 1){
			error_message = 1;
		}
	}
	
	private void disconnect_mark_check()
	{
		for(int i = 0; i < path_list.size(); i++){
			for(int j = 0; j < path_list.get(i).size(); j++){
				node_list.get(path_list.get(i).get(j)).set_mark(true);
			}
		}
		
		for(int i = 0; i < node_list.size(); i++){
			if(!node_list.get(i).get_mark()){
				error_message = 1;
			}
		}
	}
	
	//cycle check
	public void cycle(int index, int path_index)
	{
		for(int i = 0; i < path_list.get(path_index).size(); i++){
			if(path_list.get(path_index).get(i) == index){
				error_message = 2;
			}
		}
	}
	
	public void sort()
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int size = duration_list.size();
		for(int k = 0; k < size; k++){
			for(int i = 0; i < duration_list.size(); i++){
				boolean biggest = true;
				for(int j = 0; j < duration_list.size(); j++){
					if(duration_list.get(i) < duration_list.get(j)){
						biggest = false;
					}
				}
				if(biggest){
					boolean added = false;
					for(int o = 0; o < temp.size(); o++){
						if(temp.get(o) == i){
							added = true;
						}
					}
					if(!added){
						temp.add(i);
					}
					duration_list.set(i, -1);
				}
			}
		}
		duration_list.clear();
		duration_list.addAll(temp);
	}

	//connection check
	public void matcherror()
	{
//		int end_counter = 0;
//		Input_node temp3 = head;
//		for(int i = 0; i < counter; i++) {
//			boolean match = false;
//			get_dependencies(temp3.get_dependency());
//			if(dependencies_list.get(0).equals("")){
//				end_counter += 1;
//				Input_node temp4 = head;
//				for(int j =0; j < counter; j++){
//					get_dependencies(temp4.get_dependency());
//					for(int index = 0; index < dependencies_list.size(); index++){
//						if(temp3.get_activity().equals(dependencies_list.get(index))){
//							match = true;
//						}
//					}
//					temp4 = temp4.get_next();
//				}
//			}
//			else{
//				match = true;
//			}
//			if(match == false && end_counter > 1) {
//				error_message = 1;
//			}
//			temp3= temp3.get_next();
//		}
	}
	
	//cycle check
	public void cycle_check()
	{
//		Input_node temp = head;
//		int cyclecounter = 0;
//		for(int i =0; i < counter; i++) {
//			if(temp.get_dependency().equals("")) {
//				cyclecounter++;
//			}
//			temp = temp.get_next();
//		}
//		
//		if(cyclecounter == 0) {
//			error_message = 1;
//		}
	}

	//index by biggest duration
//	public void sort()
//	{
//		Input_node initialize = head;
//		for(int i = 0; i < counter; i ++){
//			initialize.set_index(0);
//			initialize = initialize.get_next();
//		}
//		int index = 0;
//		while(true){
//			boolean changed = false;
//			Input_node temp = head;
//			for (int i = 0; i < counter; i++) {
//				boolean biggest = true;
//				Input_node temp2 = head;
//				for( int j = 0; j < counter; j++) {
//					if(!temp.get_activity().equals(temp2.get_activity())){
//						if(temp.get_index() == 0){
//							if(temp2.get_index() == 0){
//								if(temp.get_duration() < temp2.get_duration()){
//									biggest = false;
//								}
//							}
//						}
//					}
//					temp2 = temp2.get_next();
//				}
//				if(biggest){
//					if(temp.get_index() == 0){
//						index += 1;
//						temp.set_index(index);
//						changed = true;
//					}
//				}
//				temp = temp.get_next();
//			}
//			if(!changed){
//				break;
//			}
//		}
//	}
	
	public ArrayList<String> get_dependencies(String str)
	{
		String[] dependencies = str.split("\\s*,\\s*");
		ArrayList<String> dependencies_list = new ArrayList<String>();
		for(int i = 0; i < dependencies.length; i++){
			dependencies_list.add(dependencies[i]);
		}
		return dependencies_list;
	}

	//print function
	public String print()
	{
		output();
		//
		//must have a dependency, must be mentioned in dependency
		//error check for all nodes must be connected
//		//there cannot be a cycle
//		matcherror();
//		cycle_check();
		//

//        //this is for test only
//		get_dependencies(head.get_dependency());
//		for(int i = 0; i < dependencies_list.size(); i++){
//			System.out.println(dependencies_list.get(i));
//		}

//		Input_node test = head;
//		for(int i = 0; i < counter; i ++){
//			System.out.println(test.get_index());
//			test = test.get_next();
//		}
		
//		sort();

		String print = "";

//		int index_counter = 1;
//		for(int i = 0; i < counter; i++){
//			Input_node temp = head;
//			for(int j = 0; j < counter; j++){
//				if(temp.get_index() == index_counter){
//					print = print + "activity: " + temp.get_activity() + " ";
//					print = print + "dependency: " + temp.get_dependency() + " ";
//					print = print + "duration: " + temp.get_duration() + " ";
//					print = print + "\n";
//				}
//				temp = temp.get_next();
//			}
//			index_counter += 1;
//		}
//		if (error_message == 1){
//			error_message = 0;
//			return ("Error has occurred");
//		}
//		else{
//			return print;
//		}
		disconnect_mark_check();
		if(error_message == 1){
			error_message = 0;
			print += "Disconnected Error";
		}
		else if(error_message == 2){
			error_message = 0;
			print += "Cycle Error";
		}
		else{
			output_list.clear();
			duration_list.clear();
			for(int i = 0; i < path_list.size(); i++){
				String output_node = "";
				int duration_node = 0;
				for(int j = 0; j < path_list.get(i).size(); j++){
					if(j != 0){
						output_node += "->";
					}
					output_node += node_list.get(path_list.get(i).get(j)).get_activity();
					duration_node += node_list.get(path_list.get(i).get(j)).get_duration();
				}
				output_node += ", ";
				output_node += duration_node;
				output_list.add(output_node);
				duration_list.add(duration_node);
			}
			sort();
			for(int i = 0; i < output_list.size(); i++){
				print += output_list.get(duration_list.get(i));
				print += "\n";
			}
		}
		return print;
	}
	
}

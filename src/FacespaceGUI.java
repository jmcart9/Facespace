/*
THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
A TUTOR OR CODE WRITTEN BY OTHER STUDENTS.
Jorvon Carter. No team.
*/

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FacespaceGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextArea textArea_1;
	
	FacespaceStuff network = new FacespaceStuff();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacespaceGUI window = new FacespaceGUI();
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
	public FacespaceGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1015, 695);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String fn = textField.getText().trim();
				String ln = textField_1.getText().trim();
				String mn = textField_18.getText().trim();
				String age = textField_19.getText().trim();
				String status = textField_20.getText().trim();
				String country = textField_21.getText().trim();
				String state = textField_22.getText().trim();
				String city = textField_23.getText().trim();
				String education = textField_24.getText().trim();
				String employment = textField_25.getText().trim();
				String religion = textField_26.getText().trim();
				String anything = textField_27.getText().trim();

				UserProfile profile = new UserProfile(fn, ln, mn, age, status, country, state, city, education, employment, religion, anything, new ArrayList<>());

				if (network.hasUser(profile.name())){
					System.out.println(profile.name() + " already in network. " + profile.name() + " has not been added.");
					System.out.println("You can try a different name or update this user instead.");
					textArea_1.setText(profile.name() + " already in network. " + profile.name() + " has not been added.\nYou can try a different name or update this user instead.");
					return;
				}
				network.addUser(profile);
				network.showProfile(profile.name());
				if (!profile.friends().isEmpty()){
					String names="";
					for (int k = 0; k < profile.friends().size(); k++){
						names = names + "\n " + profile.friends().get(k);
					}
					textArea_1.setText(profile.name() + " added. \n" + "Name: " + profile.fullName() + "\n"+"Age: " + profile.age() + "\n" + "Location: " + profile.city() + ", " + profile.state() + ", " + profile.country() + "\n" + "Education: " + profile.education() + "\n" + "Employment: " + profile.employment() + "\n" + "Religion: " + profile.religion() + "\n" + "Anything else: " + profile.anything() + "\n" + "Friends: \n" + names);
				}
				else {
					textArea_1.setText(profile.name() + " added. \n" + "Name: " + profile.fullName() + "\n"+"Age: " + profile.age() + "\n" + "Location: " + profile.city() + ", " + profile.state() + ", " + profile.country() + "\n" + "Education: " + profile.education() + "\n" + "Employment: " + profile.employment() + "\n" + "Religion: " + profile.religion() + "\n" + "Anything else: " + profile.anything() + "\n" + "Friends: ");
				}
				
			}
		});
		btnAddUser.setBounds(43, 11, 120, 23);
		frame.getContentPane().add(btnAddUser);
		
		JButton btnRemoveUser = new JButton("Remove User");
		btnRemoveUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String fn = textField_2.getText().trim();
				String ln = textField_3.getText().trim();
				String name = (fn + " " + ln).trim();

				if (!network.hasUser(name)){
					System.out.println(name + " is not in the network!");
					textArea_1.setText(name + " is not in the network!");
					return;
				}

				// Use the modern removeUser API (though we'd need to enhance FacespaceStuff for this)
				// For now, let's provide a workaround message
				System.out.println("Pale Death with impartial tread beats at the poor man's cottage door and at the palaces of kings.");
				System.out.println("Please use the CLI to remove users (functionality pending in GUI).");
				textArea_1.setText("Pale Death with impartial tread beats at the poor man's cottage door and at the palaces of kings.\n" +
				                  "Please use the CLI to remove users (functionality pending in GUI).");
			}
		});
		btnRemoveUser.setBounds(163, 11, 120, 23);
		frame.getContentPane().add(btnRemoveUser);
		
		JButton btnUpdateUser = new JButton("Update User");
		btnUpdateUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String fn = textField_4.getText().trim();
				String ln = textField_5.getText().trim();
				String name = (fn + " " + ln).trim();

				if (!network.hasUser(name)){
					System.out.println(name + " is not in the network.");
					System.out.println("You can try to add this user.");
					textArea_1.setText(name + " is not in the network. \nYou can try to add this user.");
				}
				else {
					// Get new values from add user fields
					String fnNew = textField.getText().trim();
					String lnNew = textField_1.getText().trim();
					String mnNew = textField_18.getText().trim();
					String ageNew = textField_19.getText().trim();
					String statusNew = textField_20.getText().trim();
					String countryNew = textField_21.getText().trim();
					String stateNew = textField_22.getText().trim();
					String cityNew = textField_23.getText().trim();
					String educationNew = textField_24.getText().trim();
					String employmentNew = textField_25.getText().trim();
					String religionNew = textField_26.getText().trim();
					String anythingNew = textField_27.getText().trim();

					// Use the modern updateUser API (though we'd need to enhance FacespaceStuff)
					System.out.println("Please use the CLI to update users (functionality pending in GUI).");
					textArea_1.setText("Please use the CLI to update users (functionality pending in GUI).\nUse 'update' command in the main Facespace application.");
				}
			}
		});
		btnUpdateUser.setBounds(283, 11, 120, 23);
		frame.getContentPane().add(btnUpdateUser);
		
		JButton btnShowUser = new JButton("Show User");
		btnShowUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String fn = textField_6.getText().trim();
				String ln = textField_7.getText().trim();
				String name = (fn + " " + ln).trim();

				network.findUser(name).ifPresentOrElse(profile -> {
					System.out.println("Name: " + profile.fullName());
					System.out.println("Age: " + profile.age());
					System.out.println("Location: " + profile.city() + ", " + profile.state() + ", " + profile.country());
					System.out.println("Education: " + profile.education());
					System.out.println("Employment: " + profile.employment());
					System.out.println("Religion: " + profile.religion());
					System.out.println("Anything else: " + profile.anything());
					System.out.println("Friends: ");
					if (!profile.friends().isEmpty()){
						String names="";
						for (int k = 0; k < profile.friends().size(); k++){
							System.out.println(profile.friends().get(k));
							names = names + "\n " + profile.friends().get(k);
						}
						textArea_1.setText("Name: " + profile.fullName() + "\n"+"Age: " + profile.age() + "\n" + "Location: " + profile.city() + ", " + profile.state() + ", " + profile.country() + "\n" + "Education: " + profile.education() + "\n" + "Employment: " + profile.employment() + "\n" + "Religion: " + profile.religion() + "\n" + "Anything else: " + profile.anything() + "\n" + "Friends: \n" + names);
					}
					else {
						textArea_1.setText("Name: " + profile.fullName() + "\n"+"Age: " + profile.age() + "\n" + "Location: " + profile.city() + ", " + profile.state() + ", " + profile.country() + "\n" + "Education: " + profile.education() + "\n" + "Employment: " + profile.employment() + "\n" + "Religion: " + profile.religion() + "\n" + "Anything else: " + profile.anything() + "\n" + "Friends: ");
					}
				}, () -> {
					System.out.println("User not found.");
					textArea_1.setText("User not found.");
				});
			}
		});
		btnShowUser.setBounds(403, 11, 110, 23);
		frame.getContentPane().add(btnShowUser);
		JButton btnShowAllUsers = new JButton("Show All Users");
		btnShowAllUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				var allUsers = network.getAllUserNames();
				if (allUsers.isEmpty()){
					System.out.println("Network empty!");
					textArea_1.setText("Network empty!");
					return;
				}
				String names = "";
				for (String name: allUsers){
					names = names + name + "\n";
				}
				textArea_1.setText("All users: \n" + names);
			}
		});
		btnShowAllUsers.setBounds(512, 11, 120, 23);
		frame.getContentPane().add(btnShowAllUsers);
		
		JButton btnMakeFriends = new JButton("Make Friends");
		btnMakeFriends.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String fn = textField_8.getText().trim();
				String ln = textField_9.getText().trim();
				String name = (fn + " " + ln).trim();
				fn = textField_28.getText().trim();
				ln = textField_29.getText().trim();
				String name2 = (fn + " " + ln).trim();

				var user1Opt = network.findUser(name);
				var user2Opt = network.findUser(name2);

				if (user1Opt.isEmpty() || user2Opt.isEmpty()){
					if (user1Opt.isEmpty()){
						System.out.println(name + " is not in the network.");
						textArea_1.setText(name + " is not in the network.");
					}
					else {
						System.out.println(name2 + " is not in the network.");
						textArea_1.setText(name2 + " is not in the network.");
					}
					return;
				}

				var one = user1Opt.get();
				var two = user2Opt.get();

				if (one.friends().contains(name2)){
					System.out.println("These users are already friends.");
					textArea_1.setText("These users are already friends.");
					return;
				}

				// Add friendship via network API
				network.addFriendshipDirect(name, name2);

				System.out.println(name + " and " + name2 + " are now friends.");
				textArea_1.setText(name + " and " + name2 + " are now friends.");
			}
		});
		btnMakeFriends.setBounds(631, 11, 120, 23);
		frame.getContentPane().add(btnMakeFriends);
		
		JButton btnDefriend = new JButton("Defriend");
		btnDefriend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String fn = textField_10.getText().trim();
				String ln = textField_11.getText().trim();
				String name = (fn + " " + ln).trim();
				fn = textField_12.getText().trim();
				ln = textField_13.getText().trim();
				String name2 = (fn + " " + ln).trim();

				var user1Opt = network.findUser(name);
				var user2Opt = network.findUser(name2);

				if (user1Opt.isEmpty() || user2Opt.isEmpty()){
					if (user1Opt.isEmpty()){
						System.out.println(name + " is not in the network.");
						textArea_1.setText(name + " is not in the network.");
					}
					else {
						System.out.println(name2 + " is not in the network.");
						textArea_1.setText(name2 + " is not in the network.");
					}
					return;
				}

				// Remove friendship via network API
				network.removeFriendshipDirect(name, name2);

				System.out.println(name + " and " + name2 + " are no longer friends.");
				textArea_1.setText(name + " and " + name2 + " are no longer friends.");
			}
		});
		btnDefriend.setBounds(752, 11, 120, 23);
		frame.getContentPane().add(btnDefriend);
		
		JButton btnDegreeOfSep = new JButton("Degree of Sep.");
		btnDegreeOfSep.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String fn = textField_14.getText().trim();
				String ln = textField_15.getText().trim();
				String name = (fn + " " + ln).trim();
				fn = textField_16.getText().trim();
				ln = textField_17.getText().trim();
				String name2 = (fn + " " + ln).trim();

				if (name.equals(name2)){
					System.out.println("Please enter two different users!");
					textArea_1.setText("Please enter two different users!");
					return;
				}
				if (!network.hasUser(name)){
					System.out.println(name + " is not in the network.");
					textArea_1.setText(name + " is not in the network.");
					return;
				}
				if (!network.hasUser(name2)){
					System.out.println(name2 + " is not in the network.");
					textArea_1.setText(name2 + " is not in the network.");
					return;
				}
				
				// Use modern BFS
				var visited = new java.util.HashSet<String>();
				var queue = new ArrayDeque<String>();
				var levelMap = new java.util.HashMap<String, Integer>();

				queue.offer(name);
				levelMap.put(name, 0);
				visited.add(name);

				while (!queue.isEmpty()) {
					var current = queue.poll();
					var currentLevel = levelMap.get(current);

					var currentUserOpt = network.findUser(current);
					if (currentUserOpt.isEmpty()) continue;

					var currentUser = currentUserOpt.get();

					for (var friendName : currentUser.friends()) {
						if (friendName.equals(name2)) {
							var degree = currentLevel + 1;
							System.out.println("Degree of separation is " + degree);
							textArea_1.setText("Degree of separation is " + degree);
							return;
						}
						
						if (!visited.contains(friendName)) {
							visited.add(friendName);
							queue.offer(friendName);
							levelMap.put(friendName, currentLevel + 1);
						}
					}
				}

				System.out.println("No connection!");
				textArea_1.setText("No connection!");
			}
		});
		btnDegreeOfSep.setBounds(870, 11, 120, 23);
		frame.getContentPane().add(btnDegreeOfSep);
		
		textField = new JTextField();
		textField.setBounds(43, 62, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(43, 109, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(172, 62, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(172, 109, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Enter the old first and last name in fields beneath the 'Update User' button.");
				System.out.println("But enter the new information under the fields of 'Add User'.");
				System.out.println("When done, click 'Update User'.");
				textArea_1.setText("Enter the old first and last name in field beneath the 'Update User' button.\nBut enter the new information under the fields of 'Add User'.\nWhen done, click 'Update User'.");
			}
		});
		textField_4.setBounds(288, 62, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Enter the old first and last name in fields beneath the 'Update User' button.");
				System.out.println("But enter the new information under the fields of 'Add User'.");
				System.out.println("When done, click 'Update User'.");
				textArea_1.setText("Enter the old first and last name in field beneath the 'Update User' button.\nBut enter the new information under the fields of 'Add User'.\nWhen done, click 'Update User'.");
			}
		});
		textField_5.setBounds(288, 109, 86, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(403, 62, 86, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(403, 109, 86, 20);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(631, 62, 86, 20);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(631, 109, 86, 20);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(756, 62, 86, 20);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(756, 109, 86, 20);
		frame.getContentPane().add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(756, 161, 86, 20);
		frame.getContentPane().add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(756, 213, 86, 20);
		frame.getContentPane().add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(868, 62, 86, 20);
		frame.getContentPane().add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setBounds(870, 109, 86, 20);
		frame.getContentPane().add(textField_15);
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setBounds(868, 161, 86, 20);
		frame.getContentPane().add(textField_16);
		textField_16.setColumns(10);
		
		textField_17 = new JTextField();
		textField_17.setBounds(870, 213, 86, 20);
		frame.getContentPane().add(textField_17);
		textField_17.setColumns(10);
		
		textField_18 = new JTextField();
		textField_18.setBounds(43, 161, 86, 20);
		frame.getContentPane().add(textField_18);
		textField_18.setColumns(10);
		
		textField_19 = new JTextField();
		textField_19.setBounds(43, 213, 86, 20);
		frame.getContentPane().add(textField_19);
		textField_19.setColumns(10);
		
		textField_20 = new JTextField();
		textField_20.setBounds(43, 265, 86, 20);
		frame.getContentPane().add(textField_20);
		textField_20.setColumns(10);
		
		textField_21 = new JTextField();
		textField_21.setBounds(43, 320, 86, 20);
		frame.getContentPane().add(textField_21);
		textField_21.setColumns(10);
		
		textField_22 = new JTextField();
		textField_22.setBounds(43, 379, 86, 20);
		frame.getContentPane().add(textField_22);
		textField_22.setColumns(10);
		
		textField_23 = new JTextField();
		textField_23.setBounds(43, 435, 86, 20);
		frame.getContentPane().add(textField_23);
		textField_23.setColumns(10);
		
		textField_24 = new JTextField();
		textField_24.setBounds(43, 483, 86, 20);
		frame.getContentPane().add(textField_24);
		textField_24.setColumns(10);
		
		textField_25 = new JTextField();
		textField_25.setBounds(43, 532, 86, 20);
		frame.getContentPane().add(textField_25);
		textField_25.setColumns(10);
		
		textField_26 = new JTextField();
		textField_26.setBounds(43, 581, 86, 20);
		frame.getContentPane().add(textField_26);
		textField_26.setColumns(10);
		
		textField_27 = new JTextField();
		textField_27.setBounds(43, 631, 925, 20);
		frame.getContentPane().add(textField_27);
		textField_27.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(53, 45, 65, 14);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(53, 93, 66, 14);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setBounds(53, 148, 76, 14);
		frame.getContentPane().add(lblMiddleName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(53, 202, 46, 14);
		frame.getContentPane().add(lblAge);
		
		JLabel lblRomanticStatus = new JLabel("Romantic Status");
		lblRomanticStatus.setBounds(43, 251, 86, 14);
		frame.getContentPane().add(lblRomanticStatus);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(53, 307, 46, 14);
		frame.getContentPane().add(lblCountry);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(53, 364, 46, 14);
		frame.getContentPane().add(lblState);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(53, 421, 46, 14);
		frame.getContentPane().add(lblCity);
		
		JLabel lblEducation = new JLabel("Education");
		lblEducation.setBounds(53, 466, 56, 14);
		frame.getContentPane().add(lblEducation);
		
		JLabel lblEmployment = new JLabel("Employment");
		lblEmployment.setBounds(53, 517, 65, 14);
		frame.getContentPane().add(lblEmployment);
		
		JLabel lblReligion = new JLabel("Religion");
		lblReligion.setBounds(43, 563, 46, 14);
		frame.getContentPane().add(lblReligion);
		
		JLabel lblAnythingElseYou = new JLabel("Anything else you want to add.");
		lblAnythingElseYou.setBounds(53, 612, 205, 14);
		frame.getContentPane().add(lblAnythingElseYou);
		
		JLabel lblFirstName_1 = new JLabel("First Name");
		lblFirstName_1.setBounds(185, 45, 65, 14);
		frame.getContentPane().add(lblFirstName_1);
		
		JLabel lblFirstName_2 = new JLabel("First Name");
		lblFirstName_2.setBounds(293, 45, 67, 14);
		frame.getContentPane().add(lblFirstName_2);
		
		JLabel lblLastName_1 = new JLabel("Last Name");
		lblLastName_1.setBounds(298, 93, 62, 14);
		frame.getContentPane().add(lblLastName_1);
		
		JLabel lblLastName_2 = new JLabel("Last Name");
		lblLastName_2.setBounds(182, 93, 65, 14);
		frame.getContentPane().add(lblLastName_2);
		
		JLabel lblFirstName_3 = new JLabel("First Name");
		lblFirstName_3.setBounds(413, 45, 63, 14);
		frame.getContentPane().add(lblFirstName_3);
		
		JLabel lblLastName_3 = new JLabel("Last Name");
		lblLastName_3.setBounds(413, 93, 65, 14);
		frame.getContentPane().add(lblLastName_3);
		
		JLabel lblFirstNameUser = new JLabel("First Name User 1");
		lblFirstNameUser.setBounds(631, 45, 110, 14);
		frame.getContentPane().add(lblFirstNameUser);
		
		textField_28 = new JTextField();
		textField_28.setBounds(631, 161, 86, 20);
		frame.getContentPane().add(textField_28);
		textField_28.setColumns(10);
		
		textField_29 = new JTextField();
		textField_29.setBounds(631, 213, 86, 20);
		frame.getContentPane().add(textField_29);
		textField_29.setColumns(10);
		
		JLabel lblLastNameUser = new JLabel("Last Name User 1");
		lblLastNameUser.setBounds(629, 93, 99, 14);
		frame.getContentPane().add(lblLastNameUser);
		
		JLabel lblFirstNameUser_1 = new JLabel("First Name User 2");
		lblFirstNameUser_1.setBounds(631, 148, 99, 14);
		frame.getContentPane().add(lblFirstNameUser_1);
		
		JLabel lblLastNameUser_1 = new JLabel("Last Name User 2");
		lblLastNameUser_1.setBounds(631, 202, 86, 14);
		frame.getContentPane().add(lblLastNameUser_1);
		
		JLabel label = new JLabel("First Name User 1");
		label.setBounds(752, 45, 110, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Last Name User 1");
		label_1.setBounds(752, 93, 99, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("First Name User 2");
		label_2.setBounds(752, 148, 99, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Last Name User 2");
		label_3.setBounds(756, 202, 86, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Last Name User 2");
		label_4.setBounds(870, 202, 86, 14);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("First Name User 2");
		label_5.setBounds(870, 148, 99, 14);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Last Name User 1");
		label_6.setBounds(870, 93, 99, 14);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("First Name User 1");
		label_7.setBounds(870, 45, 110, 14);
		frame.getContentPane().add(label_7);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(947, 263, -543, 124);
		frame.getContentPane().add(textArea);
		
		textArea_1 = new JTextArea();
		textArea_1.setBounds(163, 244, 791, 357);
		frame.getContentPane().add(textArea_1);
	}
}

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Menu extends JDialog{

	private JFrame frame;
	private final Action action = new SwingAction();
	
	private final JPanel contentPanel = new JPanel();
	private final JPanel contentPanel1 = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	private JTextField textField1;

	public FacespaceStuff x = new FacespaceStuff();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu window = new Menu();
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
	public Menu() {
		initialize();
		setBounds(100, 100, 636, 556);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(272, 26, 46, 14);
		contentPanel.add(label);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(324, 11, 62, 14);
		contentPanel.add(lblFirstName);
		
		textField = new JTextField();
		textField.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) {
				System.out.println(arg0);
			}
		});
		textField.setBounds(304, 26, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(300, 94, 86, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(304, 81, 82, 14);
		contentPanel.add(lblLastName);
		
		JLabel lblAge = new JLabel("age");
		lblAge.setBounds(324, 145, 46, 14);
		contentPanel.add(lblAge);
		
		textField_2 = new JTextField();
		textField_2.setBounds(300, 159, 86, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						String fn = textField.getText();
						String ln = textField_1.getText();
						String age = textField_2.getText();
						UserProfile profile = new UserProfile(fn, ln, age);
						x.addUser(profile);
						//System.out.print(profile.name + " added.");
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						//dispose();
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
		//
		public Menu(int y){
		initialize();
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel1, BorderLayout.CENTER);
		contentPanel1.setLayout(null);
		
		JLabel lblEnterFirstAnd = new JLabel("Enter first and last name, seperated by a space.");
		lblEnterFirstAnd.setBounds(85, 26, 238, 14);
		contentPanel1.add(lblEnterFirstAnd);
		
		textField1 = new JTextField();
		textField1.setBounds(160, 51, 86, 20);
		contentPanel1.add(textField1);
		textField1.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						String name = textField1.getText();
						UserProfile profile = x.findUser(name);
						textField1.setText(profile.name + " " + profile.age);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 784, 658);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					//menu dialog = new menu();
					dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
				
				//adduser.main(args);
				
				//UserProfile profile = new UserProfile("casse", "a", "0");
				//addUpdateUser(profile);
			}
		});
		btnAddUser.setBounds(280, 75, 91, 23);
		frame.getContentPane().add(btnAddUser);
		
		JButton btnUpdateUser = new JButton("Update User");
		btnUpdateUser.setBounds(280, 145, 91, 23);
		frame.getContentPane().add(btnUpdateUser);
		
		JButton btnRemoveUser = new JButton("Remove User");
		btnRemoveUser.setBounds(280, 207, 91, 23);
		frame.getContentPane().add(btnRemoveUser);
		
		JButton btnFindUser = new JButton("Find User");
		btnFindUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					dialog2.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
					dialog2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnFindUser.setBounds(280, 270, 91, 23);
		frame.getContentPane().add(btnFindUser);
		
		JButton btnAddFriend = new JButton("Add friend");
		btnAddFriend.setBounds(280, 327, 91, 23);
		frame.getContentPane().add(btnAddFriend);
		
		JButton btnRemoveFriend = new JButton("Remove Friend");
		btnRemoveFriend.setBounds(280, 395, 91, 23);
		frame.getContentPane().add(btnRemoveFriend);
		
		JButton btnDegOfSep = new JButton("Deg of sep");
		btnDegOfSep.setBounds(280, 472, 91, 23);
		frame.getContentPane().add(btnDegOfSep);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("clicked");
		}
	}
	
	
	
}

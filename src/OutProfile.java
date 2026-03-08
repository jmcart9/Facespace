import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class OutProfile extends JDialog {

	private final JPanel contentPanel1 = new JPanel();
	private JTextField textField1;
	
	adduser z = new adduser();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the dialog.
	 */
	public OutProfile() {
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
						UserProfile profile = z.y.x.findUser(name);
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
}

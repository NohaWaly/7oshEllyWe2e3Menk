import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageTypeSpecifier;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class getcontent {

	private JFrame frame;
	private JTextField FirstName;
	private JTextField LastName;
	private JTextField Email;
	private JTextField Phone;
	private JTextField Address;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getcontent window = new getcontent();
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
	public getcontent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 616, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblFirstName.setBounds(12, 26, 109, 32);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblLastName.setBounds(12, 58, 97, 22);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEmail.setBounds(12, 93, 73, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPassword.setBounds(12, 118, 97, 22);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblConfirmPassword.setBounds(12, 153, 164, 16);
		frame.getContentPane().add(lblConfirmPassword);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPhone.setBounds(12, 182, 97, 16);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAddress.setBounds(12, 211, 89, 16);
		frame.getContentPane().add(lblAddress);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				boolean x=false;
				if (FirstName.getText().equals("")|| LastName.getText().equals("") || Email.getText().equals("")|| Phone.getText().equals("")|| 
						Address.getText().equals("")|| passwordField.getPassword().toString().equals("")) {
					x=true;
					JOptionPane.showMessageDialog(null,"there's something in the data is missing!! fill data carefully");
				}
				if (!(passwordField.getText().equals(passwordField_1.getText()))) {
					x=true;
					JOptionPane.showMessageDialog(null,"Your passwords don't match!!");
				}
				if (!(Email.getText().contains("@") ) && !(Email.getText().contains("."))) {
					x=true;
					JOptionPane.showMessageDialog(null,"Recheck your email");
				}
				if(Phone.getText().length() != 11) {
					x=true; 
					JOptionPane.showMessageDialog(null,"Phone number must be 10 charachters");}
				if(Phone.getText().length() == 11) {
				       try 
				        { 
				            // checking valid integer using parseInt() method 
				            Integer.parseInt(Phone.getText()); 
				           
				        }  
				        catch (NumberFormatException e1)  
				        { 		x=true;
				        	 JOptionPane.showMessageDialog(null,"you can't enter alphabets in phone number!");
				        } 
				          
					
				}
				if (x==false) {
					
				Userinfo obj =new Userinfo(FirstName.getText(), LastName.getText(), Email.getText(), Phone.getText(), Address.getText(), passwordField.getText());
				JOptionPane.showMessageDialog(null, "SUCCESSFULLY CREATED YOUR ACCOUNT! PLEASE LOGIN!!");
				ConnectionMySQL x1 = new ConnectionMySQL();
				x1.signupaddindb(obj);
				firstpage obj1=new firstpage();
				obj1.viewFirstPage();
				}}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnSubmit.setBounds(188, 271, 204, 32);
		frame.getContentPane().add(btnSubmit);
		
		FirstName = new JTextField();
		FirstName.setBounds(121, 34, 324, 22);
		frame.getContentPane().add(FirstName);
		FirstName.setColumns(10);
		
		LastName = new JTextField();
		LastName.setBounds(121, 61, 324, 22);
		frame.getContentPane().add(LastName);
		LastName.setColumns(10);
		
		Email = new JTextField();
		Email.setBounds(121, 93, 324, 22);
		frame.getContentPane().add(Email);
		Email.setColumns(10);
		
		Phone = new JTextField();
		Phone.setBounds(120, 182, 325, 22);
		frame.getContentPane().add(Phone);
		Phone.setColumns(10);
		
		Address = new JTextField();
		Address.setBounds(121, 211, 324, 22);
		frame.getContentPane().add(Address);
		Address.setColumns(10);
		passwordField = new JPasswordField();
		passwordField.setBounds(112, 121, 333, 22);
		frame.getContentPane().add(passwordField);
		JCheckBox chckbxShowPassword = new JCheckBox("Show Password");
		chckbxShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxShowPassword.isSelected()) {
					passwordField.setEchoChar((char)0);
				}
				else {
					passwordField.setEchoChar('*');
				}
			}
		});
		chckbxShowPassword.setBounds(454, 118, 136, 25);
		frame.getContentPane().add(chckbxShowPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(188, 153, 257, 22);
		frame.getContentPane().add(passwordField_1);
		
		JCheckBox chckbxShowPassword_1 = new JCheckBox("Show Password");
		chckbxShowPassword_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxShowPassword.isSelected()) {
					passwordField_1.setEchoChar((char)0);
				}
				else {
					passwordField_1.setEchoChar('*');
				}
			}
		});
		chckbxShowPassword_1.setBounds(454, 148, 136, 25);
		frame.getContentPane().add(chckbxShowPassword_1);
		

	}
}

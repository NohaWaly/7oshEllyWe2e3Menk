import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class getlogincontent {

	private JFrame frame;
	private JTextField Mail;
	private JPasswordField passwordField;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void NewScreen1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getlogincontent window = new getlogincontent();
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
	public getlogincontent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 517, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEmail.setBounds(44, 58, 85, 16);
		frame.getContentPane().add(lblEmail);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPassword.setBounds(44, 117, 85, 16);
		frame.getContentPane().add(lblPassword);

		Mail = new JTextField();
		Mail.setBounds(141, 58, 193, 22);
		frame.getContentPane().add(Mail);
		Mail.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(141, 117, 193, 22);
		frame.getContentPane().add(passwordField);

		JCheckBox chckbxShowPassword = new JCheckBox("Show Password");
		chckbxShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxShowPassword.isSelected()) {
					passwordField.setEchoChar((char) 0);
				} else {
					passwordField.setEchoChar('*');
				}
			}
		});
		chckbxShowPassword.setBounds(342, 116, 132, 25);
		frame.getContentPane().add(chckbxShowPassword);

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag;
				User ob = new User(Mail.getText(), passwordField.getText().toString());
				ConnectionMySQL c = new ConnectionMySQL();
				flag = c.searchindb(ob);
				// c.searchindb(ob);
				if (flag == true) {
					Profile obj = new Profile();
					obj.showprofile();
				} else {
					JOptionPane.showMessageDialog(null, "Can't find data in db please sign up or recheck!!");
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnLogin.setBounds(183, 190, 132, 25);
		frame.getContentPane().add(btnLogin);
	}

}

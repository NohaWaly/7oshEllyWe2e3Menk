import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Profile {
	public static String userMail="";
	private JFrame frame;
	private JTextField Posts;
	private JTextField Notifications;

	/**
	 * Launch the application.
	 */
	public static void showprofile(String usermail) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userMail=usermail;
					Profile window = new Profile();
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
	public Profile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 712, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPosts = new JLabel("Posts:");
		lblPosts.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPosts.setBounds(34, 158, 56, 20);
		frame.getContentPane().add(lblPosts);
		
		Posts = new JTextField();
		Posts.setBounds(34, 191, 278, 171);
		frame.getContentPane().add(Posts);
		Posts.setColumns(10);
		
		JLabel lblNotifications = new JLabel("Notifications:");
		lblNotifications.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNotifications.setBounds(362, 156, 126, 25);
		frame.getContentPane().add(lblNotifications);
		
		Notifications = new JTextField();
		Notifications.setBounds(360, 191, 290, 171);
		frame.getContentPane().add(Notifications);
		Notifications.setColumns(10);
		
		JLabel lblWelcomeToYour = new JLabel("WELCOME TO YOUR PROFILE");
		lblWelcomeToYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToYour.setFont(new Font("Traditional Arabic", Font.BOLD, 32));
		lblWelcomeToYour.setBounds(34, 50, 604, 56);
		frame.getContentPane().add(lblWelcomeToYour);
		
		JButton btnAddNewPost = new JButton("Add New Post");
		btnAddNewPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemForm obj = new ItemForm();
				obj.fillForm(userMail);
				
			}
		});
		btnAddNewPost.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnAddNewPost.setBounds(387, 396, 251, 25);
		frame.getContentPane().add(btnAddNewPost);
	}

}

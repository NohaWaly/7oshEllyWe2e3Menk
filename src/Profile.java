import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JList;

public class Profile {
	public static String userMail="";
	private JFrame frame;
	static ArrayList<String> notify = new ArrayList();
	static ArrayList<String> posting = new ArrayList();
	/**
	 * Launch the application.
	 */
	public static void showNotification(ArrayList<String> msg){
		notify = msg;
	
	}
	public static void showposts(ArrayList<String> msg){
		posting = msg;
	
	}
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
		frame.setBounds(100, 100, 857, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPosts = new JLabel("Posts:");
		lblPosts.setForeground(new Color(0, 139, 139));
		lblPosts.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPosts.setBounds(34, 158, 126, 20);
		frame.getContentPane().add(lblPosts);
		
		
		
		JLabel lblNotifications = new JLabel("Notifications:");
		lblNotifications.setForeground(new Color(0, 128, 128));
		lblNotifications.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNotifications.setBounds(407, 157, 201, 25);
		frame.getContentPane().add(lblNotifications);
		
		JLabel lblWelcomeToYour = new JLabel("WELCOME TO YOUR PROFILE");
		lblWelcomeToYour.setForeground(Color.PINK);
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
		btnAddNewPost.setBounds(437, 403, 251, 25);
		frame.getContentPane().add(btnAddNewPost);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(310, 191, -45, 171);
		frame.getContentPane().add(scrollPane);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setBounds(32, 194, 339, 165);
		frame.getContentPane().add(list);
		DefaultListModel dd = new DefaultListModel();
		for(int i=0;i<posting.size();i++){
			System.out.println(posting.get(i));
			dd.addElement(posting.get(i));
		}
		posting.clear();
		list.setModel(dd);
		
		JList list_1 = new JList();
		list_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list_1.setBounds(417, 194, 375, 164);
		frame.getContentPane().add(list_1);
		DefaultListModel nn = new DefaultListModel();
		for(int i=0;i<notify.size();i++){
			System.out.println(notify.get(i));
			nn.addElement(notify.get(i));
		}
		notify.clear();
		list_1.setModel(nn);
	
	}
}

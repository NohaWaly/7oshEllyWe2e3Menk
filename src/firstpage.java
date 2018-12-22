import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class firstpage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		viewFirstPage();
	}

	public static void viewFirstPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					firstpage window = new firstpage();
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
	public firstpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(250, 250, 210));
		frame.setBounds(100, 100, 940, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblWelcomeToosh = new JLabel("WELCOME TO 7OSH ELLY WE2E3 MENNAK");
		lblWelcomeToosh.setBackground(new Color(0, 128, 128));
		lblWelcomeToosh.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToosh.setForeground(UIManager.getColor("textText"));
		lblWelcomeToosh.setFont(new Font("Traditional Arabic", Font.BOLD, 32));
		lblWelcomeToosh.setBounds(43, 72, 849, 41);
		frame.getContentPane().add(lblWelcomeToosh);

		JButton btnSignup = new JButton("SignUp");
		btnSignup.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getcontent obj = new getcontent();
				obj.NewScreen();

			}
		});
		btnSignup.setBounds(113, 141, 152, 61);
		frame.getContentPane().add(btnSignup);

		JButton btnLogIn = new JButton("LogIn");
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getlogincontent obj = new getlogincontent();
				obj.NewScreen1();

			}
		});
		btnLogIn.setBounds(660, 141, 152, 61);
		frame.getContentPane().add(btnLogIn);
	}
}

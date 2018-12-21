import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.mysql.cj.xdevapi.Statement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ItemForm {
	public static String userEmail="";
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void fillForm(String userMail) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userEmail=userMail;
					ItemForm window = new ItemForm();
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
	public ItemForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 528, 527);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewForm = new JLabel("New Form");
		lblNewForm.setBounds(182, 11, 80, 25);
		frame.getContentPane().add(lblNewForm);
		// **************************************************************************
		JLabel lblClass = new JLabel("Classification");
		lblClass.setBounds(47, 49, 87, 25);
		frame.getContentPane().add(lblClass);
		String[] classification = { "", "Founder", "Searcher" };
		JComboBox comboBox = new JComboBox(classification);
		comboBox.setBounds(234, 51, 111, 20);
		frame.getContentPane().add(comboBox);

		// **************************************************************************
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(47, 85, 46, 14);
		frame.getContentPane().add(lblCategory);
		String[] Category = { "", "Bag", "Wallet", "Mobile", "laptop", "Tablet", "Watch", "notebook", "Book",
				"Flash Memory", "Hard disk" };
		JComboBox comboBox_1 = new JComboBox(Category);
		comboBox_1.setBounds(234, 82, 111, 20);
		frame.getContentPane().add(comboBox_1);

		// **************************************************************************
		JLabel lblNewLabel = new JLabel("Color");
		lblNewLabel.setBounds(47, 122, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		String[] color = { "", "White", "Yellow", "Silver ", "Gold", "Orange", "Red", "Pink", "Purple", "Blue", "Green",
				" Brown", "Grey", "Black", "Other" };
		JComboBox comboBox_2 = new JComboBox(color);
		comboBox_2.setBounds(234, 113, 111, 20);
		frame.getContentPane().add(comboBox_2);

		// **************************************************************************
		JLabel lblShape = new JLabel("Shape");
		lblShape.setBounds(47, 147, 46, 14);
		frame.getContentPane().add(lblShape);
		String[] Shape = { "", "triangle", "trapezoid", "star", "square", "rectangle", "octagon", "heart", "diamond",
				"circle" };
		JComboBox comboBox_3 = new JComboBox(Shape);
		comboBox_3.setBounds(234, 144, 111, 20);
		frame.getContentPane().add(comboBox_3);

		// **************************************************************************
		JLabel lblSize = new JLabel("Size");
		lblSize.setBounds(47, 178, 46, 14);
		frame.getContentPane().add(lblSize);
		String[] Size = { "", "Large", "small", "medium" };
		JComboBox comboBox_4 = new JComboBox(Size);
		comboBox_4.setBounds(234, 175, 111, 20);
		frame.getContentPane().add(comboBox_4);

		// **************************************************************************
		JLabel lblMaterial = new JLabel("Material");
		lblMaterial.setBounds(47, 209, 46, 14);
		frame.getContentPane().add(lblMaterial);
		String[] Material = { "", "Leather", "Stainless Steel", "Rubber", "Resin", "Silicone", "Metal", " Fabric",
				" Nylon ", "Plastic", "Ceramic", " Aluminum", " Canvas", " Silicon ", "Yellow Gold Plated",
				" Yellow Gold", " Fiber", "Wood", " Leather", " Band", " Other" };
		JComboBox comboBox_5 = new JComboBox(Material);
		comboBox_5.setBounds(234, 206, 111, 20);
		frame.getContentPane().add(comboBox_5);

		// **************************************************************************
		JLabel lblTargetedGroup = new JLabel("Targeted Group");
		lblTargetedGroup.setBounds(47, 240, 87, 14);
		frame.getContentPane().add(lblTargetedGroup);
		String[] Targeted_Group = { "", "Man", "Woman", "Boy", "Girl" };
		JComboBox comboBox_6 = new JComboBox(Targeted_Group);
		comboBox_6.setBounds(234, 237, 111, 20);
		frame.getContentPane().add(comboBox_6);

		// **************************************************************************
		JLabel lblScreenSize = new JLabel("Screen size");
		lblScreenSize.setBounds(47, 271, 80, 14);
		frame.getContentPane().add(lblScreenSize);
		String[] Screen_size = { " ", "6 -  6.9 Inch", "7 - 7.9 Inch", "8 - 8.9 Inch", "9 - 9.9 Inch ",
				"10 - 10.9 Inch", "11 - 11.9 Inch ", "12 - 12.9 Inch ", "13 - 13.9 Inch", "14 - 14.9 Inch",
				"15 - 15.9 Inch" };
		JComboBox comboBox_8 = new JComboBox(Screen_size);
		comboBox_8.setBounds(234, 268, 111, 20);
		frame.getContentPane().add(comboBox_8);

		// **************************************************************************
		JLabel lblLocation = new JLabel("Location :");
		lblLocation.setBounds(47, 362, 80, 14);
		frame.getContentPane().add(lblLocation);

		textField = new JTextField();
		textField.setBounds(234, 384, 177, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Itemclassification = comboBox.getSelectedItem().toString();
				String Itemcategory = comboBox_1.getSelectedItem().toString();
				String Itemcolor = comboBox_2.getSelectedItem().toString();
				String Itemshape = comboBox_3.getSelectedItem().toString();
				String Itemsize = comboBox_4.getSelectedItem().toString();
				String Itemmaterial = comboBox_5.getSelectedItem().toString();
				String Itemtargetedgroup = comboBox_6.getSelectedItem().toString();
				String Itemscreensize = comboBox_8.getSelectedItem().toString();
				String Date = textField_1.getText();
				String Itemcity = textField_3.getText();
				String ItemDistrict = textField.getText();
				String Itemstreet = textField_2.getText();

				Item newitem = new Item(Itemclassification, Itemcategory, Itemcolor, Itemshape, Itemsize, Itemmaterial,
						Itemtargetedgroup, Itemscreensize, Date, Itemcity, ItemDistrict, Itemstreet);
				FormController formcontrol=new FormController();
				Connection conn = null;
				boolean flag = false;
				String url = "jdbc:mysql://localhost:3306/";
				String dbName = "swe";
				Statement stmt = null;
				ResultSet result = null;
				String driver = "com.mysql.jdbc.Driver";
				String databaseUserName = "root";
				String databasePassword = "root";
				PreparedStatement pst = null;
				int userid=0;
				try {
					conn = DriverManager.getConnection(url + dbName, databaseUserName, databasePassword);
					System.out.println("Connected to the database.");
				} catch (Exception e1) {
					System.out.println("Failed to connect ot the database.");
				}

				try {
					System.out.println("EMAIL: " + userEmail);
					String sql = "SELECT userID FROM userdb  WHERE email=?";
					pst = conn.prepareStatement(sql);
					pst.setString(1, userEmail);
					result = pst.executeQuery();
					while(result.next())
						userid=result.getInt("userID");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e);
				}
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				formcontrol.FillForm(newitem, userid);
				//JOptionPane.showMessageDialog(null, "Success");
			Profile obj=new Profile();
			obj.showprofile(userEmail);
			}
		});
		btnSubmit.setBounds(413, 454, 89, 23);
		frame.getContentPane().add(btnSubmit);

		JLabel lblDate = new JLabel("Date of found/lost the item");
		lblDate.setBounds(47, 311, 144, 14);
		frame.getContentPane().add(lblDate);

		textField_1 = new JTextField();
		textField_1.setBounds(234, 308, 177, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("District");
		lblNewLabel_1.setBounds(133, 387, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblStreet = new JLabel("Street");
		lblStreet.setBounds(133, 412, 46, 14);
		frame.getContentPane().add(lblStreet);

		textField_2 = new JTextField();
		textField_2.setBounds(234, 415, 177, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("City");
		lblNewLabel_2.setBounds(133, 362, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);

		textField_3 = new JTextField();
		textField_3.setBounds(234, 359, 177, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		
		

	}
}

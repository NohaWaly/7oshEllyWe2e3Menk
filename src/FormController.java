import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;
import com.mysql.cj.xdevapi.Statement;

public class FormController {
	Item item;
	static int FormID = 0;
	int UserID;

	public FormController() {
	}

	void FillForm(Item i, int ID) {
		item = i;
		UserID = ID;
		addForm(item, UserID);
		// notification(f);
	}

	void addForm(Item i, int ID) {
		Connection conn1 = null;
		try {
			conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/swe", "root", "root");

			if (conn1 != null) {
				System.out.println("connection succeeded in formcontrol");
			}
			PreparedStatement pstmt1 = conn1.prepareStatement(
					"INSERT INTO `itemform` (classification,category,color,shape,size,material,targeted_group,screen_size,city,district,street,lostDate,userid) VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt1.setString(1, item.classification);
			pstmt1.setString(2, item.category);
			pstmt1.setString(3, item.color);
			pstmt1.setString(4, item.shape);
			pstmt1.setString(5, item.size);
			pstmt1.setString(6, item.material);
			pstmt1.setString(7, item.targeted_group);
			pstmt1.setString(8, item.screen_size);
			pstmt1.setString(9, item.city);
			pstmt1.setString(10, item.District);
			pstmt1.setString(11, item.street);
			pstmt1.setString(12, item.Date);
			pstmt1.setInt(13, ID);

			pstmt1.executeUpdate();
			conn1.close();

		} catch (Exception e) {
			System.out.println("connection NOT succeeded");
			System.err.println(e);
		}
	}

	void deleteForm(int id) {
		String msg="";
		ArrayList p = new ArrayList();
		 Connection conn1 = null;
			try {
				conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/swe", "root", "root");

				if (conn1 != null) {
					System.out.println("connection succeeded in connect form");
					p.clear();
				}
				PreparedStatement pstmt1 = conn1.prepareStatement(
						"DELETE"
						+ "from itemform"
						+ "where userid = '"+id+"'");
				
				ResultSet rs = pstmt1.executeQuery();

				conn1.close();

			} catch (Exception e) {
				System.out.println("connection NOT succeeded fel connection");
				System.err.println(e);
			}
		 }
	
	/*
	 * FormController getForm(int FormID){ //select from database } */
	public ArrayList<String> Connect(String mail){ 
		String msg="";
		ArrayList<String> f = new ArrayList();
		 Connection conn1 = null;
			try {
				conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/swe", "root", "root");

				if (conn1 != null) {
					System.out.println("connection succeeded in connect form");
				}
				PreparedStatement pstmt1 = conn1.prepareStatement(
						"select a.first_name, a.last_name, a.phone, b.first_name, b.last_name, b.phone, c.category "
						+ "from userdb a, userdb b, itemform c, itemform d "
						+ "where a.email = '"+mail+"' "
						+ "And c.userid = a.userID "
						+ "And b.userid = d.userID "
						+ "And c.category = d.category "
						+ "And c.color = d.color "
						+ "And c.shape = d.shape "
						+ "And c.size = d.size "
						+ "And c.material = d.material "
						+ "And c.targeted_group = d.targeted_group "
						+ "And c.screen_size = c.screen_size "
						+ "And c.city = d.city "
						+ "And c.district = d.district "
						+ "And c.street = d.street "
						+ "And c.lostDate =d.lostDate "
						+ "And c.classification NOT LIKE d.classification "
						+ "And c.userid NOT LIKE d.userid ");
				
				ResultSet rs = pstmt1.executeQuery();
String s="",s1="",s2="",s3="",s4="",s5="",s6="";
while(rs.next()) {
				 s = rs.getString("a.first_name");
				 s1 = rs.getString("a.last_name");
				 s2 = rs.getString("a.phone");
				 s3 = rs.getString("b.first_name");
				 s4 = rs.getString("b.last_name");
				 s5 = rs.getString("b.phone");
                 s6 = rs.getString("c.category");
			    System.out.println("first user " + s+s1+s2+" second "+s3+s4+s5);
			    msg = "your matching fellow the name is "+s3+" "+s4+" \r\n and the phone number is "+s5 + "\r\n the Item is " + s6 ;
			    f.add(msg);
}

				conn1.close();
				if(s==""&& s1=="" && s2==""&& s3==""&& s4==""&& s5=="" && s6==""){
				    msg ="null";
				    f.add(msg);
				    return f;
				    
				}
				
			} catch (Exception e) {
				System.out.println("connection NOT succeeded fel connection");
				System.err.println(e);
			}
			
			return f;
			 }
	
	
	ArrayList<String> posts(String mail){ 
		String msg="";
		ArrayList p = new ArrayList();
		 Connection conn1 = null;
			try {
				conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/swe", "root", "root");

				if (conn1 != null) {
					System.out.println("connection succeeded in connect form");
					p.clear();
				}
				PreparedStatement pstmt1 = conn1.prepareStatement(
						"select a.category, a.color,a.city,a.classification "
						+ "from itemform a, userdb b "
						+ "where a.userid=b.userID "
						+ "And email='"+mail+"'");
				
				ResultSet rs = pstmt1.executeQuery();
String s="",s1="",s2="",s3="";
while(rs.next()) {
				 s = rs.getString("a.category");
				 s1 = rs.getString("a.color");
				 s2 = rs.getString("a.city");
				 s3 = rs.getString("a.classification");
				 msg += "You're "+s3+" and the item is "+s + " colored by " + s1;
				 p.add(msg);
				 msg="";
}

				conn1.close();

			} catch (Exception e) {
				System.out.println("connection NOT succeeded fel connection");
				System.err.println(e);
			}
			
			return p;
		 }
	}
	 


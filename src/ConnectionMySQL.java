import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import java.sql.*;
import com.mysql.cj.xdevapi.Statement;

public class ConnectionMySQL {

	public static void main(String[] args) {

	}

	public static void signupaddindb(Userinfo obj) {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swe", "root", "root");

			if (conn != null) {
				System.out.println("connection succeeded");
			}

			PreparedStatement pstmt = conn.prepareStatement(
					"INSERT INTO `userdb` ( first_name, last_name, email, phone, address, password) VALUE (?,?,?,?,?,?)");

			pstmt.setString(1, obj.first_name);
			pstmt.setString(2, obj.last_name);
			pstmt.setString(3, obj.email);
			pstmt.setString(4, obj.phone);
			pstmt.setString(5, obj.address);
			pstmt.setString(6, obj.password);

			pstmt.executeUpdate();
			conn.close();

		} catch (Exception e) {
			System.out.println("connection NOT succeeded");
			System.err.println(e);
		}

	}

	public static boolean searchindb(Userinfo obj) {
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

		try {
			conn = DriverManager.getConnection(url + dbName, databaseUserName, databasePassword);
			System.out.println("Connected to the database.");
		} catch (Exception e) {
			System.out.println("Failed to connect ot the database.");
		}

		try {
			System.out.println("EMAIL: " + obj.email);
			String sql = "SELECT * FROM userdb  WHERE email=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, obj.email);
			result = pst.executeQuery();
			flag=result.next();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return flag;
	}
}

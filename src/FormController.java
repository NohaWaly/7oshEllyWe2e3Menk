import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		// Connect(f);
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
					"INSERT INTO `itemform` (classification,category,color,shape,size,material,T_Group,screensize,city,district,street,lostDate,userid) VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?)");
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

	void deleteForm(int FormID) {
		// delete mn el database
	}
	/*
	 * FormController getForm(int FormID){ //select from database } FormController
	 * Connect(FormController f){ //search fel db eno fe item zy f w nafs el date
	 * //return } void notification(FormController f){ // a }
	 */
}

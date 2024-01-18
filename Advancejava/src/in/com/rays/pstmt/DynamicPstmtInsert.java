package in.com.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DynamicPstmtInsert {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sunrise", "root", "ROOT");

		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?, ?, ?, ?, ?, ?)");

		pstmt.setInt(1, 3);
		pstmt.setInt(2, 111);
		pstmt.setString(3, "SONAL");
		pstmt.setInt(4, 91);
		pstmt.setInt(5, 95);
		pstmt.setInt(6, 96);

		int i = pstmt.executeUpdate();

		System.out.println("Data Inserted = " + i);

	}

}


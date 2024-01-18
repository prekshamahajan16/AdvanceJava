package in.com.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestPSTMT {
	public static void main(String[] args) throws Exception  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/Sunrise","root","ROOT");
	    PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(1,111,'ALIAA',91,95,96)");

		int i = pstmt.executeUpdate();
	    System.out.println("Data Inserted" +i);
	
	}
	

}
// another way to generate query in prepareStatement by passing the values...
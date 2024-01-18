package in.com.rays.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestTransaction {
public static void main(String[] args) throws Exception {
	Connection conn = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrise","root","ROOT");
		conn.setAutoCommit(false);

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("insert into emp values(6, 'Riya' , 22000)");
		i = stmt.executeUpdate("insert into emp values(7, 'jay' , 23000)");
		i = stmt.executeUpdate("insert into emp values(8, 'Deepikaa' , 23000)");
		
		System.out.println("Data inserted = " + i);
		conn.commit();
		conn.close();
		
		
	} catch (Exception e) {
		conn.rollback();
	}
}
}

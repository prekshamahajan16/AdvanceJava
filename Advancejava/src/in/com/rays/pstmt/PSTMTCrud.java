package in.com.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PSTMTCrud {
public static void main(String[] args) throws Exception {
//	testAdd(2,113,"Ray",89,96,97);
//	testUpdate(1, 111, "Allen", 99, 97, 96);
//	testDelete(3);
//	testRead();
testFindById(1);
	

}

private static void testFindById(int Id) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrise", "root", "ROOT");
	PreparedStatement pstmt = conn.prepareStatement("select * from marksheet where id = ?");
	pstmt.setInt(1, Id);
	ResultSet rs = pstmt.executeQuery();
	while(rs.next()) {
		System.out.print(rs.getInt(1));
		System.out.print("\t" + rs.getInt(2));
		System.out.print("\t" + rs.getString(3));
		System.out.print("\t" + rs.getInt(4));
		System.out.print("\t" + rs.getInt(5));
		System.out.println("\t" + rs.getInt(6));
		
		
	}
}

private static void testRead() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrise","root","ROOT");
	
	PreparedStatement pstmt = conn.prepareStatement("select * from marksheet");
	ResultSet rs = pstmt.executeQuery();
	
	while(rs.next()) {
		System.out.print(rs.getInt(1));
		System.out.print("\t" + rs.getInt(2));
		System.out.print("\t" +  rs.getString(3));
		System.out.print("\t" + rs.getInt(4));
		System.out.print("\t" + rs.getInt(5));
		System.out.println("\t" + rs.getInt(6));
	}
	
	
}

private static void testDelete(int Id) throws Exception {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrise","root","ROOT");
PreparedStatement pstmt = conn.prepareStatement("delete from marksheet where id = ?");
pstmt.setInt(1, Id );

int i = pstmt.executeUpdate();
System.out.println("Data Deleted!! = " +i);


	
}

private static void testUpdate(int Id, int roll_no, String name, int phy, int chem, int maths) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrise","root","ROOT");
	PreparedStatement pstmt = conn.prepareStatement(
			 "update marksheet set roll_no = ?, name = ?, phy = ?, chem = ?, maths = ? where id = ?" );
	
	pstmt.setInt(1, roll_no);
	pstmt.setString(2, name);
	pstmt.setInt(3, phy);
	pstmt.setInt(4, chem);
	pstmt.setInt(5, maths);
	pstmt.setInt(6, Id);

	
	int i = pstmt.executeUpdate();
	System.out.println("Data updated !! = " + i);
	
	
}

private static void testAdd(int Id, int roll_no, String name, int phy,int chem, int maths) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrise","root","ROOT");
	PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
	pstmt.setInt(1, Id);
	pstmt.setInt(2, roll_no);
	pstmt.setString(3, name);
	pstmt.setInt(4, phy);
	pstmt.setInt(5, chem);
	pstmt.setInt(6, maths);
	
	int  i = pstmt.executeUpdate();
    System.out.println("Data Updated!!!" +i);
}

}

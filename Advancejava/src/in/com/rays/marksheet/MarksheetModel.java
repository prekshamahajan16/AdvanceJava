package in.com.rays.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class MarksheetModel {
public Integer nextPk() throws Exception{ 
	int pk = 0;
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrise","root","ROOT");
	PreparedStatement pstmt = conn.prepareStatement("select max(id) from marksheet");
	ResultSet rs = pstmt.executeQuery();
	
	while(rs.next()) {		
	  pk = rs.getInt(1);
	}
	
		return pk +1;
		
	}

public void Add(MarksheetBean bean) throws  Exception {
	int pk = 0;
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrise","root","ROOT");
	
	PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
	pstmt.setInt(1,pk);
	pstmt.setInt(2,bean.getRollno());
	pstmt.setString(3,bean.getName());
	pstmt.setInt(4, bean.getPhy());
	pstmt.setInt(5,bean.getChem());
	pstmt.setInt(6, bean.getMaths());
	
	int i = pstmt.executeUpdate();

	System.out.println("Data Inserted = " + pk);
	
}
	
	public void update(MarksheetBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc: mysql://localhost:3306/sunrise","root","ROOT");
		
		PreparedStatement pstmt = conn.prepareStatement(
				"update marksheet set roll_no = ?, name = ?, physics = ?, chemistry = ?, maths = ? where id = ?");

		pstmt.setInt(1, bean.getRollno());
		pstmt.setString(2, bean.getName());
		pstmt.setInt(3, bean.getPhy());
		pstmt.setInt(4, bean.getChem());
		pstmt.setInt(5, bean.getMaths());
		pstmt.setInt(6, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("Data Updated = " + i);

	}

	public void delete(int id) throws Exception {


		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc: mysql://localhost:3306/sunrise","root","ROOT");
		
		PreparedStatement pstmt = conn.prepareStatement("delete from marksheet where id = ?");

		pstmt.setInt(1, id);

		int i = pstmt.executeUpdate();

		System.out.println("Data Deleted = " + i);

	}

	public MarksheetBean findByPk(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc: mysql://localhost:3306/sunrise","root","ROOT");
		

		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet where id = ?");

		pstmt.setInt(1, id);

		ResultSet rs = pstmt.executeQuery();

		MarksheetBean bean = null;

		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollno(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhy(rs.getInt(4));
			bean.setChem(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
		}
		return bean;
	}

	public List search(MarksheetBean bean, int pageNo, int pageSize) throws Exception {


		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc: mysql://localhost:3306/sunrise","root","ROOT");
		

		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1");

		if (bean != null) {

			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}

			if (bean.getRollno() > 0) {
				sql.append(" and roll_no = " + bean.getRollno());
			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}

		System.out.println("sql ==>> " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollno(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhy(rs.getInt(4));
			bean.setChem(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			list.add(bean);
		}
		return list;
	
   }

}

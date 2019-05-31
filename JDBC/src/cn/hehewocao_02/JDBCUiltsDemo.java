package cn.hehewocao_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUiltsDemo {
	public static void main(String[] args) throws SQLException {
		
		Connection con = JDBCUtils.getConnection();
		
		String sql = "select * from stu";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println("id: " + rs.getInt("id") + " name: " + rs.getString("name") + " password: " + rs.getString("password"));
		}
		
		JDBCUtils.close(con, ps, rs);
	}
}

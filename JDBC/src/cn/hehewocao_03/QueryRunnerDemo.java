package cn.hehewocao_03;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import cn.hehewocao_02.JDBCUtils;

public class QueryRunnerDemo {

	private static Connection con = JDBCUtils.getConnection();
	
	public static void main(String[] args) throws SQLException {
		
		//delete();
		//insert();
		update();
	}
	
	
	public static void delete() throws SQLException {
		
		QueryRunner qr = new QueryRunner();
		String sql = "delete from stu where name = ?";
		Object[] param = {"张三"};
		int row = qr.update(con, sql, param);
		System.out.println(row);
		DbUtils.closeQuietly(con);
		
	}
	
	public static void insert() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "insert into stu (name,password) values (?,?)";
		Object[] param = {"伍键","04182021"};
		int row = qr.update(con, sql, param);
		System.out.println(row);
		DbUtils.closeQuietly(con);
	}
	
	public static void update() throws SQLException {
		QueryRunner qr = new  QueryRunner();
		String sql = "update stu set id = 1 where name = ?";
		Object[] param = {"伍键"};
		int row = qr.update(con, sql, param);
		System.out.println(row);
		DbUtils.closeQuietly(con);
	}
	
	
}

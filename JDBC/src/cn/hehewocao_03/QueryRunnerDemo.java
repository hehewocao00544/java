package cn.hehewocao_03;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.hehewocao_02.JDBCUtils;

public class QueryRunnerDemo {

	private static Connection con = JDBCUtils.getConnection();

	public static void main(String[] args) throws SQLException {

		// delete();
		// insert();
		//update();
		//select();
		selectJavaBeanList();
	}

	public static void delete() throws SQLException {

		QueryRunner qr = new QueryRunner();
		String sql = "delete from stu where name = ?";
		Object[] param = { "张三" };
		int row = qr.update(con, sql, param);
		System.out.println(row);
		DbUtils.closeQuietly(con);

	}

	public static void insert() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "insert into stu (name,password) values (?,?)";
		Object[] param = { "伍键", "04182021" };
		int row = qr.update(con, sql, param);
		System.out.println(row);
		DbUtils.closeQuietly(con);
	}

	public static void update() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "update stu set id = 1 where name = ?";
		Object[] param = { "伍键" };
		int row = qr.update(con, sql, param);
		System.out.println(row);
		DbUtils.closeQuietly(con);
	}

	public static void select() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "select * from stu";
		List<Object[]> array = qr.query(con, sql, new ArrayListHandler());
		for (Object[] objs : array) {
			for (Object obj : objs) {
				System.out.print(obj + "\t");
			}
			System.out.println();
		}
		DbUtils.closeQuietly(con);
	}

	public static void selectJavaBeanList() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "select * from stu";
		List<Stu> list = qr.query(con, sql, new BeanListHandler<Stu>(Stu.class));
		for(Stu stu : list) {
			System.out.println("id: " + stu.getId() + " name: " + stu.getName() + " password: " + stu.getPassword());
		}
		DbUtils.closeQuietly(con);
	}
}

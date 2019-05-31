package cn.hehewocao_04;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.hehewocao_03.Stu;

public class DBCPUtilsDemo {

	private static BasicDataSource bds = DBCPUtils.getDataSource();
	private static QueryRunner qr = new QueryRunner(bds);

	public static void main(String[] args) {

		//update();
		select();
	}

	public static void update() {
		String sql = "update stu set password = ? where name = ?";
		Object[] param = { "04182019", "齐赞" };
		try {
			int row = qr.update(sql, param);
			System.out.println(row);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void select() {
		String sql = "select * from stu";
		try {
			List<Stu> list = qr.query(sql, new BeanListHandler<Stu>(Stu.class));
			for(Stu s : list) {
				System.out.println("id: " + s.getId() + " name: " + s.getName() + " password: " + s.getPassword());
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}

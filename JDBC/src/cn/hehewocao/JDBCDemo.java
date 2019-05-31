package cn.hehewocao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//1.加载mysql驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("注册成功!");
		//2.获得与数据库的连接
		String url = "jdbc:mysql://localhost:3306/lirui?serverTimezone=GMT%2B8";
		String username = "root";
		String password = "root";
		/*String url = "jdbc:mysql://192.168.1.242:3306/lirui?serverTimezone=GMT%2B8";
		String username = "public";
		String password = "12345678";*/
		
		Connection con = DriverManager.getConnection(url, username, password);
		//3.获取SQL语句的执行平台
		Statement stat = con.createStatement();
		//4.执行SQL语句，获得结果集
		String str = "select * from stu";
		ResultSet rs = stat.executeQuery(str);
		//5.遍历集合
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String passWord = rs.getString("password");
			System.out.println("ID:" + id + "  name: " + name + "  password: " + passWord);
		}
		//6.释放资源
		rs.close();
		stat.close();
		con.close();
	}
}

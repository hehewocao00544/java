package cn.hehewocao_02;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {

	private static Connection con;
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	static {
		
		try {
			fileReadConfig();
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			new RuntimeException("连接数据库失败！");
		}
		
	}
	
	
	private JDBCUtils() {}
	
	public static Connection getConnection() {
		return con;
	}
	
	public static void fileReadConfig() throws IOException {
		
		//通过类加载器获得该文件的输入流
		InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("config.properties");
		//Properties类
		//load(InputStream inStream) 
        //从输入流中读取属性列表（键和元素对）。
		Properties pro = new Properties();
		pro.load(is);
		driver = pro.getProperty("driver");
		url = pro.getProperty("url");
		user = pro.getProperty("user");
		password = pro.getProperty("password");
	}
	
	public static void close(Connection con,Statement stat,ResultSet rs) throws SQLException {
		con.close();
		stat.close();
		rs.close();
	}
	
	public static void close(Connection con,Statement stat) throws SQLException {
		con.close();
		stat.close();
	}
}

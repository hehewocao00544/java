package cn.hehewocao_04;

import org.apache.commons.dbcp.BasicDataSource;

//创建数据连接池的工具类
public class DBCPUtils {

	private static BasicDataSource bds = new BasicDataSource();
	
	static {
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/lirui?serverTimezone=GMT%2B8");
		bds.setUsername("root");
		bds.setPassword("root");
		
		bds.setInitialSize(10);
		bds.setMaxActive(8);
		bds.setMaxIdle(2);
		bds.setMinIdle(1);
	}
	
	public static BasicDataSource getDataSource() {
		return bds;
	}
}

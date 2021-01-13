package tool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConntenSQL {
	/**
	 *  	该类工具类，用于连接数据库
	 */
		public static Connection getConnection() {
			Properties properties = new Properties();
			try {
				//读取连接数据库属性文件
				properties.load(ConntenSQL.class.getClassLoader().getResourceAsStream("Consql.properties"));
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				System.out.println("文件读取错误");
			}
//			String mySqlName =properties.getProperty("mySqlName");
			String user =properties.getProperty("user");
			String pwd =properties.getProperty("pwd");
			String URL =properties.getProperty("URL");
			String Driver =properties.getProperty("Driver");

			Connection conn = null;
			//1.加载驱动程序
			try {
				Class.forName(Driver);
			} catch (ClassNotFoundException e) {
				// TODO 自动生成的 catch 块
				System.out.println("JDBC驱动加载失败！");
			}
			//2.建立到数据库的链接
			try {
				conn =DriverManager.getConnection(URL,user,pwd);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				System.out.println("连接数据库失败");
			}
			return conn;
		}
		
		//按需关闭流
		public static void close(ResultSet rs,Statement stat,Connection conn) {
			
			try {
	            if(rs!=null){
	                rs.close();
	            }
	            if(stat!=null) {
	            	stat.close();
	            }
	            if(conn!=null) {
	            	conn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
}

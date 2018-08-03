package cn.edu.hbue.util;

import java.sql.*;

/**
 * @author czqmike
 * @date 2018年7月30日
 * @description 执行数据库的连接与关闭
 */
public class JDBCUtil {
	static String username = "root";
	static String password = "123456";
	
	public static Connection getConn(){
		Connection connection = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/signupdb?"
					+ "user=" + username + "&password=" + password;
			connection = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e1){
			//JDBC connection error
			e1.printStackTrace();
		} catch (SQLException e) {
			//SQL operation error
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConn(PreparedStatement preStmt, Connection conn){
		if (preStmt != null){
			try{
				conn.close();
			} catch (SQLException e){
				//SQL Close error
				e.printStackTrace();
			}
		}
		if (conn != null){
			try{
				conn.close();
			} catch (SQLException e){
				//SQL Close error
				e.printStackTrace();
			}
		}
	}
}

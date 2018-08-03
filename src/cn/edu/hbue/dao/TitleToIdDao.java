package cn.edu.hbue.dao;

import cn.edu.hbue.util.JDBCUtil;
import java.sql.*;

/**
 * @author czqmike
 * @date 2018年8月3日
 * @description 操作数据库中的title_to_id表，完成增删查改工作
 */
public class TitleToIdDao {
	public static boolean insert(String title) {
		boolean ok = false;
		Connection conn = JDBCUtil.getConn();
		PreparedStatement stmt = null;
		String sql = "INSERT INTO `signupdb`.`title_to_id` (`subject_title`) VALUES (?)"; 

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, title);

			stmt.executeUpdate();
			
			ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConn(stmt, conn);
		}
		return ok;
	}
	
	/**
	 * @param 报名标题
	 * @return  如果查询成功，返回id，否则，返回-1
	 */
	public static int select(String title) {
		Connection conn = JDBCUtil.getConn();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int id = -1;

		String sql = "SELECT addon_id " + 
					 "FROM signupdb.title_to_id " + 
					 "WHERE subject_title = ?" + 
					 "ORDER by addon_id DESC"; 
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, title);

			rs = stmt.executeQuery();
			// 移动指针到第一行
			rs.next();
			// 结果为降序排序,取出最大的id
			id = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConn(stmt, conn);
		}
		
		return id;
	}
}

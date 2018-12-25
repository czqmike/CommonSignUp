package cn.edu.hbue.dao;

import java.sql.*;

import cn.edu.hbue.util.*;

/**
 * @author czqmike
 * @date 2018年12月25日
 * @description 操作数据库中的visible表
 * 				在创建报名的时候插入新值并置is_visible为true (insert)
 * 				在用户点击删除报名时将要删除的报名的is_visible置为false (update)
 */
public class VisibleDao {

	private static boolean update(String sql, Object[] params) {
		boolean ok = false;
		Connection conn = JDBCUtil.getConn();
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; ++i) {
				stmt.setObject(i + 1, params[i]);
			}

			stmt.executeUpdate();
			
			ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConn(stmt, conn);
		}
		return ok;
	}

	public static boolean insert(String title) {
		boolean ok = false;
		String sql = "INSERT INTO `signupdb`.`visible` (`subject_title`, `is_visible`) VALUES (?, ?)"; 
		Object[] params = {title, true};

		ok = update(sql, params);

		return ok;
	}
	
	public static boolean hideSubject(String title) {
		boolean ok = false;
		String sql = "UPDATE `signupdb`.`visible` SET `is_visible` = ? WHERE (`subject_title` = ?)";
		Object[] params = {false, title};

		ok = update(sql, params);

		return ok;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

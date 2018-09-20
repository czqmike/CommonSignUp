package cn.edu.hbue.dao;

import cn.edu.hbue.util.JDBCUtil;
import java.sql.*;
import java.util.ArrayList;

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
	public static int selectId(String title) {
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
	
	/**
	 * @param 报名标题
	 * @return 除最小的addon_id之外（模板的id）其他id组成的ArrayList
	 * @description 通过某个报名标题名查询全部的id
	 */
	public static ArrayList<Integer> selectIds(String title) {
		Connection conn = JDBCUtil.getConn();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Integer> list = new ArrayList<Integer>();

		String sql = "SELECT title_to_id.addon_id FROM " +
					 "signupdb.title_to_id " +
					 "where title_to_id.subject_title = ? " + 
					 "order by addon_id ASC";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, title);

			rs = stmt.executeQuery();
			rs.next(); // 跳过第-1行（空）和第0个结果（模板）
			
			while (rs.next()) {
				list.add(rs.getInt("addon_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConn(stmt, conn);
		}
		
		return list;
		
	}

	/**
	 * @return 全部的标题名（每种只出现一次）
	 */
	public static ArrayList<String> selectName() {
		Connection conn = JDBCUtil.getConn();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "select subject_title from signupdb.title_to_id " + 
					 "group by subject_title ";
		
		ArrayList<String> title_list = new ArrayList<String>();

		try {
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			while (rs.next()) {
				title_list.add(rs.getString("subject_title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConn(stmt, conn);
		}
		
		return title_list;
		
	}
}

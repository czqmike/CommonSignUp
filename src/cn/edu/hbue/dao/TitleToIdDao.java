package cn.edu.hbue.dao;

import cn.edu.hbue.util.JDBCUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

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
	 * @return  如果查询成功，返回最大的id，否则，返回-1
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
	 * @note 修改于2018_12_24 by czqmike
	 *         只显示在visible表中is_visible为true的项
	 */
	public static ArrayList<String> selectName() {
		Connection conn = JDBCUtil.getConn();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "select title_to_id.subject_title " + 
					 "from signupdb.title_to_id, signupdb.visible " + 
					 "where title_to_id.subject_title = visible.subject_title and visible.is_visible = true " + 
					 "group by title_to_id.subject_title ";
		
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
	
	/**
	 * @return 全部的标题名（每种只出现一次）
	 * @note 移除了selectName中的visible限制
	 */
	public static ArrayList<String> selectAllName() {
		Connection conn = JDBCUtil.getConn();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "select title_to_id.subject_title " + 
					 "from signupdb.title_to_id " + 
					 "group by title_to_id.subject_title ";
		
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

	/**
	 * @return 报名标题 与 报名人数的 HashMap 
	 */
	public static HashMap<String, Integer> selectOverview() {
		Connection conn = JDBCUtil.getConn();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "select count(title_to_id.subject_title) - 1 " +	// 每种标题的第一个为模板，所以要-1 
				 	 "from title_to_id " + 
					 "where subject_title = ? ";
		
		ArrayList<String> title_list = selectName();
		
		HashMap<String, Integer> ov = new HashMap();

		try {
			stmt = conn.prepareStatement(sql);
			
			for (int i = 0; i < title_list.size(); ++i) {
				stmt.setString(1, title_list.get(i));
				
				rs = stmt.executeQuery();
				rs.next();	// 将rs移动到首行
				ov.put(title_list.get(i), rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConn(stmt, conn);
		}
		
		return ov;
	}
}

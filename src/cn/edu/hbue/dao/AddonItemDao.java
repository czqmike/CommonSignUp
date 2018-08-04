package cn.edu.hbue.dao;

import java.sql.*;
import java.util.ArrayList;

import cn.edu.hbue.util.*;

/**
 * @author czqmike
 * @date 2018年8月3日
 * @description 对应数据库中addon_item[id]表，完成表的创建以及addon_name字段数据的添加
 */
public class AddonItemDao {

	// 建立一张addon_items[id], 并且填充addon_name字段的值
	public static boolean CreateTable(String[] addon_names, int addon_id) {
		boolean ok = false;
		Connection conn = JDBCUtil.getConn();
		PreparedStatement stmt = null;
		String createSql = "CREATE TABLE `signupdb`.`addon_item" + Integer.toString(addon_id) + "` " + 
					 "(`addon_name` VARCHAR(45) NOT NULL," + 
					 "`addon_value` VARCHAR(45) NULL," + 
					 "PRIMARY KEY (`addon_name`))";  
		String insertSql = "INSERT INTO `signupdb`.`addon_item" + Integer.toString(addon_id) + "` (`addon_name`) VALUES (?)"; 

		try {
			// 创建表
			stmt = conn.prepareStatement(createSql);

			stmt.execute();
			
			// 添加字段的数据
			stmt = conn.prepareStatement(insertSql);
			for (int i = 0; i < addon_names.length; ++i) {
				stmt.setString(1, addon_names[i]);
				stmt.executeUpdate();
			}
			
			ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConn(stmt, conn);
		}
		
		return ok;
	}

	// 只建表而不填充数据
	public static boolean CreateTable(int addon_id) {
		boolean ok = false;
		Connection conn = JDBCUtil.getConn();
		PreparedStatement stmt = null;
		String createSql = "CREATE TABLE `signupdb`.`addon_item" + Integer.toString(addon_id) + "` " + 
					 "(`addon_name` VARCHAR(45) NOT NULL," + 
					 "`addon_value` VARCHAR(45) NULL," + 
					 "PRIMARY KEY (`addon_name`))";  

		try {
			// 创建表
			stmt = conn.prepareStatement(createSql);

			stmt.execute();
			
			ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConn(stmt, conn);
		}
		
		return ok;
	}

	public static ArrayList<String> selectAddonNamesById(int id) {
		ArrayList<String> ret = new ArrayList<String>();
		Connection conn = JDBCUtil.getConn();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "select addon_name from signupdb.addon_item" + Integer.toString(id);
		
		try {
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			// 结果为降序排序,取出最大的id
			while (rs.next()) {
				ret.add(rs.getString("addon_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConn(stmt, conn);
		}
		
		return ret;
	}

	public static boolean insertById(String addon_name, String addon_value, int addon_id) {
		boolean ok = false;
		Connection conn = JDBCUtil.getConn();
		PreparedStatement stmt = null;

		String insertSql = "INSERT INTO `signupdb`.`addon_item" + Integer.toString(addon_id) + "` (`addon_name`, `addon_value`) VALUES (?, ?)"; 

		try {
			// 添加字段的数据
			stmt = conn.prepareStatement(insertSql);
			stmt.setString(1, addon_name);
			stmt.setString(2, addon_value);
			stmt.executeUpdate();
			
			ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConn(stmt, conn);
		}
		
		return ok;
	}
	
}























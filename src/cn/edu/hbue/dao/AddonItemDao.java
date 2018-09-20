package cn.edu.hbue.dao;

import java.sql.*;
import java.util.ArrayList;

import cn.edu.hbue.model.AddonItem;
import cn.edu.hbue.util.*;

/**
 * @author czqmike
 * @date 2018年8月3日
 * @description 对应数据库中addon_item[id]表，完成表的创建以及addon_name字段数据的添加
 */
public class AddonItemDao {

	// 建立一张addon_items[id], 并且填充addon_name字段的值
	public static boolean CreateTable(ArrayList<AddonItem> items, int addon_id) {
		boolean ok = false;
		Connection conn = JDBCUtil.getConn();
		PreparedStatement stmt = null;
		String createSql = "CREATE TABLE `signupdb`.`addon_item" + Integer.toString(addon_id) + "` " + 
					 "(`addon_name` VARCHAR(45) NOT NULL," + 
					 "`addon_value` VARCHAR(45) NULL," + 
					 "`type` VARCHAR(45) NOT NULL," + 
					 "`option` VARCHAR(200) NULL," + 
					 "PRIMARY KEY (`addon_name`))";  
		String insertSql = "INSERT INTO `signupdb`.`addon_item" + Integer.toString(addon_id) + "` (`addon_name`, `type`, `option`) VALUES (?, ?, ?)"; 

		try {
			// 创建表
			stmt = conn.prepareStatement(createSql);

			stmt.execute();
			
			// 添加字段的数据
			stmt = conn.prepareStatement(insertSql);
			for (int i = 0; i < items.size(); ++i) {
				stmt.setString(1, items.get(i).getAddon_name());
				stmt.setString(2, items.get(i).getType());
				stmt.setString(3, items.get(i).getOption());
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
					 "`type` VARCHAR(45) NOT NULL," + 
					 "`option` VARCHAR(200) NULL," + 
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

	/**
	 * 选出addon_item[id]表中的全部数据
	 * @param id（addon_item表的id）
	 * @return ArrayList<AddonItem>
	 */
	public static ArrayList<AddonItem> selectAddonItemsById(int id) {
		ArrayList<AddonItem> items = new ArrayList<AddonItem>();
		Connection conn = JDBCUtil.getConn();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM signupdb.addon_item" + Integer.toString(id);
		try {
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				AddonItem temp = new AddonItem();
				temp.setAddon_name(rs.getString("addon_name"));
				temp.setAddon_value(rs.getString("addon_value"));
				temp.setType(rs.getString("type"));
				temp.setOption(rs.getString("option"));

				items.add(temp);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return items;
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

		String insertSql = "INSERT INTO `signupdb`.`addon_item" + Integer.toString(addon_id) + "` (`addon_name`, `addon_value`) "
						 + "VALUES (?, ?)"; 

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
	
	public static boolean insertById(AddonItem item, int addon_id) {
		boolean ok = false;
		Connection conn = JDBCUtil.getConn();
		PreparedStatement stmt = null;

		String insertSql = "INSERT INTO `signupdb`.`addon_item" + Integer.toString(addon_id) + "` " +
						   "(`addon_name`, `addon_value`, `type`, `option`) " +
						   "VALUES (?, ?, ?, ?)"; 

		try {
			// 添加字段的数据
			stmt = conn.prepareStatement(insertSql);
			stmt.setString(1, item.getAddon_name());
			stmt.setString(2, item.getAddon_value());
			stmt.setString(3, item.getType());
			stmt.setString(4, item.getOption());
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























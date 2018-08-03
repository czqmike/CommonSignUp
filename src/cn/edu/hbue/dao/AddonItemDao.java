package cn.edu.hbue.dao;

import java.sql.*;
import cn.edu.hbue.util.*;

/**
 * @author czqmike
 * @date 2018年8月3日
 * @description 对应数据库中addon_item[id]表，完成表的创建以及addon_name字段数据的添加
 */
public class AddonItemDao {
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
}

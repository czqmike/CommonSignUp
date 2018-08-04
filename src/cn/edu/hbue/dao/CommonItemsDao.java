package cn.edu.hbue.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import cn.edu.hbue.model.*;

import cn.edu.hbue.util.JDBCUtil;

public class CommonItemsDao {

	public static boolean insert(CommonItems ci) {
		boolean ok = false;
		Connection conn = JDBCUtil.getConn();
		PreparedStatement stmt = null;
		String sql = "INSERT INTO `signupdb`.`common_items` (`name`, `student_no`, `class`, `report_year`, `addon_id`) VALUES (?, ?, ?, ?, ?)"; 

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ci.getName());
			stmt.setString(2, ci.getStudent_no());
			stmt.setString(3, ci.getClass_());
			stmt.setString(4, ci.getReport_year());
			stmt.setInt(5, ci.getAddon_id());

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

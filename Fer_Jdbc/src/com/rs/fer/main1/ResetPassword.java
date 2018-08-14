package com.rs.fer.main1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.util.DBUtil;

public class ResetPassword {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtil.getConnection();
			
			String query = "update user set password =? where id=?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "saikrishna");
			preparedStatement.setInt(2, 103);

			int r = preparedStatement.executeUpdate();
			if (r > 0) {
				System.out.println("Password changed Successfully");
			} else {
				System.out.println("Password  change failed");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
	}

}

package com.rs.fer.main1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.util.DBUtil;

public class DeleteExpenseMain {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtil.getConnection();
			
			String query = "delete from expense where expenseId=?";
			int id = 3;
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);

			int r = preparedStatement.executeUpdate();
			if (r != 0) {
				System.out.println("deleteExpense done Successfully");
			} else {
				System.out.println("deleteExpense failed");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
	}

}

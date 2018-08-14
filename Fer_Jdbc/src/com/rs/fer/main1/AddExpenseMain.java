package com.rs.fer.main1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.util.DBUtil;

public class AddExpenseMain {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtil.getConnection();
			String query = "INSERT INTO expense VALUES (?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 2);
			preparedStatement.setString(2, "toothPaste");
			preparedStatement.setString(3, "19");
			preparedStatement.setString(4, "250");
			preparedStatement.setString(5, "10");
			preparedStatement.setString(6, "200");
			preparedStatement.setString(7, "harish");
			preparedStatement.setString(8, "1");

			int r = preparedStatement.executeUpdate();
			if (r > 0) {
				System.out.println("addExpense done Successfully");
			} else {
				System.out.println("addExpense failed");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
	}

}

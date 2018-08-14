package com.rs.fer.main1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.util.DBUtil;

public class EdiExpenseMain {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtil.getConnection();
			
			String query = "update expense set expenseType=?,date=? where expenseId=?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "soap1");
			preparedStatement.setString(2, "1-2-31");

			preparedStatement.setInt(3, 1);

			int r = preparedStatement.executeUpdate();
			if (r > 0) {
				System.out.println("editExpense done Successfully");
			} else {
				System.out.println("editExpense failed");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
	}

}

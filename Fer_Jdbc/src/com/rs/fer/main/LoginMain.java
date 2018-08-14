package com.rs.fer.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.DBUtil;

@SuppressWarnings("unused")
public class LoginMain {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		FERService ferServive = new FERServiceImpl();

		User user = new User();

		user.setUsername("venu");
		user.setPassword("vamsivs");

		boolean isLogin = ferServive.login(user);

		if (isLogin) {
			System.out.println("Login done Successfully");
		} else {
			System.out.println("login failed");
		}
	}

}

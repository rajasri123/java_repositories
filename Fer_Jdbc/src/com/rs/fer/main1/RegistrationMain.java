package com.rs.fer.main1;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class RegistrationMain {

	public static void main(String[] args) {
		FERService ferServive = new FERServiceImpl();

		User user = new User();

		user.setFirstName("fn");
		user.setMiddleName("");
		user.setLastName("ln");
		user.setUsername("un");
		user.setPassword("pw");
		user.setEmail("test@#test.com");
		user.setMobile("32432424");

		boolean isRegister = ferServive.registration(user);

		if (isRegister) {
			System.out.println("Registration done Successfully");
		} else {
			System.out.println("Registration failed");
		}
	}

}

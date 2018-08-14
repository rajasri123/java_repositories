package com.rs.fer.main;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class ResetPassword {

	public static void main(String[] args) {
FERService ferservice = new FERServiceImpl();
boolean isExpense =ferservice.resetpassword(0, null, null);

	if (isExpense) {
		System.out.println("paasword done Successfully");
	} else {
		System.out.println("password failed");
	}
	}
	}



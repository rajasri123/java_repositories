package com.rs.fer.service;

import java.util.List;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.bean.User;

public interface FERService {

	boolean registration(User user);

	boolean addExpense(Expense expense);

	boolean login(User user);

	boolean editExpense(Expense expense);


	boolean resetpassword(int id,String currentpassword,String newpassword);

	boolean deleteExpense(int id);

	List<Expense> getexpenses();

	List<Expense> getexpense();

	List<Expense> getexpenseReport(String expenseType, String fromdate, String todate);

	PersonalInfo getPersonalInfo(int userid);

	boolean updatePersonalInfo(User user, Address address);

	
	/*boolean login(String username, String password);
	
	boolean addExpense(Expense expense);
	
	boolean editExpense(Expense expense);
	
	boolean deleteExpense(int id);
	
	boolean resetPassword(int userId, String newPassword, String oldPassword);
	
	List<Expense> getExpenses(int userId);
	
	List<Expense> getExpenseReport(int uString expenseType, String formDate, String toDate);
	*/
	
}

	

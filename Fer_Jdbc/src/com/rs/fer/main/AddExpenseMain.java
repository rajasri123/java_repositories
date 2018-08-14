package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class AddExpenseMain {

	public static void main(String[] args) {
		FERService ferservice = new FERServiceImpl();

		Expense expense = new Expense();

		expense.setExpenseId(4);
		expense.setExpenseType("force");
		expense.setDate("23-2-19");
		expense.setPrice(500);
		expense.setNoOfItems(15);
		expense.setTotal("200");
		expense.setByWhom("david");
		expense.setUserId(1);

		boolean isExpense = ferservice.addExpense(expense);

		if (isExpense) {
			System.out.println("addExpense done Successfully");
		} else {
			System.out.println("addExpense failed");
		}
	}

}

package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class EditExpenseMain {

	public static void main(String[] args) {
	FERService ferservice = new FERServiceImpl();
	
	Expense expense = new Expense();
	
	expense.setExpenseType("gopi");
	expense.setDate("1234");

	boolean isExpense = ferservice.editExpense(expense);

	if (isExpense) {
		System.out.println("editExpense done Successfully");
	} else {
		System.out.println("editExpense failed");
	}
}




	}



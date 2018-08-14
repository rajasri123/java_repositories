package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class DeleteExpenseMain {

	public static void main(String[] args) {
		FERService ferservice = new FERServiceImpl();
		Expense expense = new Expense();
		int id = expense.getExpenseId();
		boolean deleteExpense = ferservice.deleteExpense(id);

		
		
		if (deleteExpense) {
			System.out.println("deleteExpense done Successfully");
		} else {
			System.out.println("deleteExpense failed");
		}
	}

}

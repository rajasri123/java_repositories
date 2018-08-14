package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetExpenseReportMain {

	public static void main(String[] args) {
		FERService ferservice = new FERServiceImpl();
		
		List<Expense> expenseReport= ferservice.getexpenseReport("gopi","1234","455");
		
		if (expenseReport == null) {
			System.out.println("no records found");
		} else {
			for (Expense expense : expenseReport) {
				System.out.println(expense.getExpenseId()+","+expense.getExpenseType()+","
			+expense.getDate()+","+expense.getPrice()+","+expense.getNoOfItems()+","+expense.getTotal()+","
						+expense.getByWhom()+","+expense.getUserId()+",");
			}
		}
	}

	



	}



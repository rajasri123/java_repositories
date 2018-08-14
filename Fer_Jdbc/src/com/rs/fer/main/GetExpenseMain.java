package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetExpenseMain {

	public static void main(String[] args) {
		FERService ferservice = new FERServiceImpl();
		List<Expense> expense= ferservice.getexpense();
		
		if (expense == null) {
			System.out.println("no records found");
		} else {
			for (Expense expense1 : expense) {
				System.out.println(expense1.getExpenseId()+","+expense1.getExpenseType()+","+expense1.getDate()+","+expense1.getPrice()+","+expense1.getNoOfItems()+","+expense1.getTotal()+","+expense1.getByWhom()+","+expense1.getUserId()+",");
			}
		}
	}


	}



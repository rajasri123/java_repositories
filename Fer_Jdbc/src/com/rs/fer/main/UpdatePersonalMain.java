  package com.rs.fer.main;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class UpdatePersonalMain {

	public static void main(String[] args) {

		FERService ferservice = new FERServiceImpl();
		User user = new User();
		                      
		user.setFirstName("a");
		user.setMiddleName("b");
		user.setLastName("cdd");
		user.setUsername("ghrty");
		user.setPassword("123456");
		user.setEmail("qwer@gmail.com");
		user.setMobile("9876543211");
		user.setId(103);
  
		Address address = new Address();

		address.setAddressLine1("nanadigama");
		address.setAddressLine2("sdfgh");
		address.setCity("hyd");
		address.setState("andhra");
		address.setZip("234567");
		address.setCountry("india");
		address.setUserId(103);
		address.setId(1);
		
		boolean updatepersonalinfo = ferservice.updatePersonalInfo(user, address);
		if (updatepersonalinfo) {
			System.out.println("personalInfo updated");
		}else
		{
			System.out.println("personalinfo not updated");
		}

	}

}

package com.rs.fer.main;

import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetPersonalInfoMain {

	public static void main(String[] args) {
		
		FERService ferservice = new FERServiceImpl();
		PersonalInfo getPersonalInfoFlag = ferservice.getPersonalInfo(101);
		
		
		System.out.println(getPersonalInfoFlag.getAddress().getAddressLine1());
		System.out.println(getPersonalInfoFlag.getAddress().getAddressLine2());
		System.out.println(getPersonalInfoFlag.getUser().getFirstName());
		System.out.println(getPersonalInfoFlag.getUser().getMiddleName());
		System.out.println(getPersonalInfoFlag.getUser().getLastName());
		System.out.println(getPersonalInfoFlag.getUser().getUsername());
		System.out.println(getPersonalInfoFlag.getUser().getPassword());
		System.out.println(getPersonalInfoFlag.getUser().getEmail());
		System.out.println(getPersonalInfoFlag.getUser().getMobile());
		System.out.println(getPersonalInfoFlag.getAddress().getAddressLine1());
		System.out.println(getPersonalInfoFlag.getAddress().getAddressLine2());
		System.out.println(getPersonalInfoFlag.getAddress().getCity());
		System.out.println(getPersonalInfoFlag.getAddress().getState());
		System.out.println(getPersonalInfoFlag.getAddress().getZip());
		System.out.println(getPersonalInfoFlag.getAddress().getCountry());
		System.out.println(getPersonalInfoFlag.getAddress().getUserId());

		
	}

}

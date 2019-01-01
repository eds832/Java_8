package com.epam.cdp;

public class BusinessTaskUpdateCustomerAge implements BusinessTask {

	@Override
	public void updateStateInDB() {
		System.out.println("We are doing that");
	}

}

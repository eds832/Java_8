package com.epam.cdp;

public class BusinessTaskUpdateCustomerAgeOnThread extends Thread implements BusinessTask {
	
	@Override
	public void run() {
		updateStateInDB();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Massive updates are gonna be");
	}

	@Override
	public void updateStateInDB() {
		System.out.println("We are doing that");
	}

}

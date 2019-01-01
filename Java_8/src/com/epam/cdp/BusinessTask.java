package com.epam.cdp;

public interface BusinessTask {
	
	default void updateStateInDBByDefault() {
		System.out.println("I am not an abstract method in interface");
	}
	
	void updateStateInDB();
}

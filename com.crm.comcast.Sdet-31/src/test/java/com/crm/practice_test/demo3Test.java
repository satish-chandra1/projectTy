package com.crm.practice_test;

import org.testng.annotations.Test;

public class demo3Test {
	@Test(invocationCount=5)
	public void createAccount() {
	System.out.println("createAccount succesfully");	
		
	}
	
	@Test(dependsOnMethods="createAccount")
	public void homepage() {
		
	System.out.println(" homepage succesfully");	
		
	}
	@Test(dependsOnMethods="homepage")
	public void sendmoney() {
	System.out.println("sendmoney  succesfully");	
		
	}
	@Test(dependsOnMethods="sendmoney")
	public void logout() {
	System.out.println("logout  succesfully");	
		
	}
}

package com.crm.practice_test;

import org.testng.annotations.Test;

public class Depedencyonmethods_test {

	@Test
	public void CreateAccount() throws Throwable {
		System.out.println("login");
		System.out.println("create account");
		System.out.println("logout");
		//throw new Exception();
	}
	
	@Test(dependsOnMethods="CreateAccount")//depends on method create dependency between modules
	public void modifyAccount() {
		System.out.println("login");
		System.out.println("modifyaccount");
		System.out.println("logout");
	}
	
	@Test(dependsOnMethods="modifyAccount")
	public void	deleteaccount() {
		System.out.println("login");
		System.out.println("delete account");
		System.out.println("logout");
	}
}

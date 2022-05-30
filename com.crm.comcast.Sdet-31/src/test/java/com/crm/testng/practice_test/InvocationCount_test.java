package com.crm.testng.practice_test;

import org.testng.annotations.Test;

public class InvocationCount_test {

	@Test(invocationCount=10)
	public void demo() {
		System.out.println("execute demo method");
	}
}

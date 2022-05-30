package com.crm.practice_test;

import org.testng.annotations.Test;

public class Demo2_Test {

	
	@Test(groups="integrationTest")
	public void  sample1() {
		System.out.println("sample1 is executed");
	}
	@Test(groups="functionalTest")
	public void  sample2() {
		System.out.println("sample2 is executed");
	}
	@Test(groups="integrationTest")
	public void  sample3() {
		System.out.println("sample3 is executed");
	}
	@Test(groups="functionalTest")
	public void  sample4() {
		System.out.println("sample4 is executed");
	}
}

package com.crm.practice_test;

import org.testng.annotations.Test;

public class Demo1_Test {

	@Test(groups="functionalTest")
	public void  demo1() {
		System.out.println("demo1 is executed");
	}
	@Test(groups="integrationTest")
	public void  demo2() {
		System.out.println("demo2 is executed");
	}
	@Test(groups="functionalTest")
	public void  demo3() {
		System.out.println("demo3 is executed");
	}
	@Test(groups="integrationTest")
	public void  demo4() {
		System.out.println("demo4 is executed");
	}
}

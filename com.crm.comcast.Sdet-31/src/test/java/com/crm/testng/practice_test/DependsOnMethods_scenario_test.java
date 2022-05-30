package com.crm.testng.practice_test;

import org.testng.annotations.Test;

public class DependsOnMethods_scenario_test {

	@Test(dependsOnMethods="m2")
	public void m1() {
		System.out.println("execute m1 method");
	}
	@Test(dependsOnMethods="m1")
	public void m2() {
		System.out.println("execute m2 method");
	}
}

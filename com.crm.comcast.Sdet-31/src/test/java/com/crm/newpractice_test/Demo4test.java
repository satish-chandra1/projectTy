package com.crm.newpractice_test;

import org.testng.annotations.Test;

import com.crm.autodesk.genricutility.BaseClass;

public class Demo4test extends BaseClass {

	@Test(groups={"avinash","satish"})
	public void d1() {
		System.out.println("d1 running");
	}
	@Test(groups={"rajesh","satish"})
	public void d2() {
		System.out.println("d2 running");
	}
	@Test(groups="satish")
	public void d3() {
		System.out.println("d3 running");
	}
}

package com.crm.newpractice_test;

import org.testng.annotations.Test;

import com.crm.autodesk.genricutility.BaseClass;

public class Demo2test extends BaseClass {
	@Test(groups="satish")
	public void c1() {
		System.out.println("c1 execute");
	}
	@Test(groups="satish")
	public void c2() {
		System.out.println("c2 execute");
	}
	@Test(groups="satish")
	public void c3() {
		System.out.println("c3 execute");
	}

}

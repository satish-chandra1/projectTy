package com.crm.newpractice_test;

import org.testng.annotations.Test;

import com.crm.autodesk.genricutility.BaseClass;

public class Demo1test extends BaseClass {
	@Test(groups="satish")
	public void m1() {
		System.out.println("m1 execute");
	String value=	System.getProperty("value");
	System.out.println(value);
	}
	@Test(groups="avinash")
	public void m2() {
		System.out.println("m2 execute");
	}
	@Test(groups="rajesh")
	public void m3() {
		System.out.println("m3 execute");
	}


}

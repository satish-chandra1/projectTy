package com.crm.practice_test;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.genricutility.BaseClass;
@Listeners(com.crm.autodesk.genricutility.ListnerImplementationClass.class)
public class PracticeExtentReportTest  extends BaseClass{
	@Test
	public void demo1() {
		System.out.println("execute demo1");
	}
	@Test
	public void demo2() {
		
		System.out.println("execute demo2");
		Assert.fail();
		
	}
	@Test
	public void demo3() {
		throw new SkipException("skipped");
	}
	

}

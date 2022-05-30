package com.crm.practice_test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryanalyzerTest {

	@Test(retryAnalyzer=com.crm.autodesk.genricutility.RetryAnalyzerImplementationClass.class)
	public void create() {
		System.out.println("retry");
		Assert.assertEquals(true, true);
	}
}

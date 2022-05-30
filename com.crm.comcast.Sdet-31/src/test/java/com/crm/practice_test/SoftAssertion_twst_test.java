package com.crm.practice_test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion_twst_test {

	@Test
	public void hardassert() {
		
		String name="krishna";
		String name1="krishna";
		
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(name, name1);
		soft.assertAll();
		
		int a=20;
		int b=30;
		
	//	soft.assertEquals(a, b);
	//	soft.assertAll();
		
		char c1='A';
		char c2='A';
		
	//	soft.assertEquals(c1, c2);
	//	soft.assertAll();
		
		Object[][] objarray=new Object[2][2];
		
		objarray[0][0]="krishna";
		objarray[0][1]="ram";
		
		objarray[1][0]="sam";
		objarray[1][1]="alex";
		
		//soft.
		
		
		
	}
}

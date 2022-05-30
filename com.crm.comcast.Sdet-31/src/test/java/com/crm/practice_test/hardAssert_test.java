package com.crm.practice_test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class hardAssert_test {

	@Test
	public void hassert() {
		String name1="krishna";
		String name2="ram";
		//	Assert.assertEquals(name1, name2);
		
		String a="alex";
		String b="alex";
//		Assert.assertEquals(a, b);
		
		int aa=100;
		int bb= 100;
		//Assert.assertEquals(aa, bb);

		boolean pass=true;
		boolean fail=false;
	//	Assert.assertEquals(pass, fail);
		
		char gender='M';
		char gender1='F';
		Assert.assertEquals(gender, gender1);
		
		//Assert.assert
		
		
		
		
		

	}
}

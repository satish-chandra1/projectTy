package com.crm.practice_test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoDataProvider_test {

	@Test(dataProvider="sendMoney")
	public void receiveMoney(int money,String name,long account) {
		System.out.println(money);
		System.out.println(name);
		System.out.println(account);
	
	}
	@DataProvider
	public Object[][] sendMoney(){
		Object[][] objarray=new Object[3][3];
		
    	objarray[0][0]=10000;
		objarray[0][1]="Krishna";
		objarray[0][2]=545345435345l;
		
		objarray[1][0]=20000;
		objarray[1][1]="ram";
		objarray[1][2]=3413131231324l;
		
		objarray[2][0]=30000;
		objarray[2][1]="shyam";
		objarray[2][2]=6003434343230l;
				return objarray;
	}
}

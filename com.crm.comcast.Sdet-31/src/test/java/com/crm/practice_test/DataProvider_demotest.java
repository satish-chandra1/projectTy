package com.crm.practice_test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_demotest {

		@Test(dataProvider="getdata") 
		public void multipledata(String name,String company,String mailid,String contact) {
			System.out.println(name);
			System.out.println(company);
			System.out.println(mailid);
			System.out.println(contact);
			
			
		}
		@DataProvider
		public Object[][] getdata(){
			Object[][] objArray=new Object[2][4];
			objArray[0][0]="satish";
			objArray[0][1]="delloite";
			objArray[0][2]="satish@gmail.com";
			objArray[0][3]="123456789";
			
			
			objArray[1][0]="krishna";
			objArray[1][1]="universe";
			objArray[1][2]="krishna@gmail.com";
			objArray[1][3]="0000000000";
			
			return objArray;
			
			
		}
}

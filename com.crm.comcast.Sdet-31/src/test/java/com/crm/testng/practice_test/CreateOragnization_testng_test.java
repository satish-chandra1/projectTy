package com.crm.testng.practice_test;

import org.testng.Assert;
import org.testng.annotations.Test; 

import com.crm.autodesk.genricutility.BaseClass;
import com.crm.autodesk.genricutility.ExcelUtility;
import com.crm.autodesk.genricutility.JavaUtility;
import com.crm.pom.objectrepository.CreateOragnizationPage;
import com.crm.pom.objectrepository.HomePage;
import com.crm.pom.objectrepository.OragnizationInformationPage;
import com.crm.pom.objectrepository.OragnizationPage;

public class CreateOragnization_testng_test extends BaseClass{
	
	@Test(groups="FunctionalTest")
	public void createOragnization() throws Throwable {
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		
		String oragnizationname=elib.getDataFromExcel("Sheet2", 1, 0)+jlib.getRandDomNumber();

		
		HomePage home=new HomePage(driver);
		home.clickOnOragnizationLink();
		
		OragnizationPage org=new OragnizationPage(driver);
		org.CreateOragnization();
		
		
		
		
		CreateOragnizationPage create=new CreateOragnizationPage(driver);
		create.oragnizationCreate(oragnizationname);
		create.saveButton();
		
		OragnizationInformationPage info=new  OragnizationInformationPage(driver);
		String header=info.getoragnizationText();
		
		Assert.assertEquals(header.contains(oragnizationname),true);
	//	Assert.assertTrue(header.contains(oragnizationname));
//		if(header.contains(oragnizationname))
//		{
//			System.out.println("is verified :pass");
//		}
//		else {
//			System.out.println("not verified");
//		}
	}
}

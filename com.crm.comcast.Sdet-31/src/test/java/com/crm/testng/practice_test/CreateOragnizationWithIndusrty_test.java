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

public class CreateOragnizationWithIndusrty_test  extends BaseClass{
	@Test(groups="IntegrationTest")
	public void oragnizationIndustry() throws Throwable {
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib= new JavaUtility();
		String oragname=elib.getDataFromExcel("Sheet2", 2, 1)+jlib.getRandDomNumber();
		String industryname=elib.getDataFromExcel("Sheet2",3, 1);
		
		HomePage home=new HomePage(driver);
		home.clickOnOragnizationLink();
		
		OragnizationPage org=new OragnizationPage(driver);
		org.CreateOragnization();
		
		CreateOragnizationPage create=new CreateOragnizationPage(driver);
		create.createoragnization(oragname, industryname);
		create.saveButton();
		
		OragnizationInformationPage info= new OragnizationInformationPage(driver);
		String text=info.getoragnizationText();
//		if(text.contains(oragname)) {
//			System.out.println("verisication is pass");
//		}
//		else {
//			System.out.println("verifcation is fail");
//		}
		Assert.assertEquals(text.contains(oragname),true);
		
		
		
		
	}

}

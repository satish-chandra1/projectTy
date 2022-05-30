package com.crm.testng.practice_test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genricutility.BaseClass;
import com.crm.autodesk.genricutility.ExcelUtility;
import com.crm.autodesk.genricutility.JavaUtility;
import com.crm.pom.objectrepository.ContactInformationPage;
import com.crm.pom.objectrepository.ContactPage;
import com.crm.pom.objectrepository.CreateContactPage;
import com.crm.pom.objectrepository.HomePage;

public class CreateContacts_Test extends BaseClass{
	
	@Test(groups="SmokeTest")
	public void contacts() throws Throwable {
		ExcelUtility elib= new ExcelUtility();
		JavaUtility jlib =new JavaUtility();
		String contactName=elib.getDataFromExcel("Sheet2", 1, 1)+jlib.getRandDomNumber();
	

		
		HomePage homepage=new HomePage(driver);
		homepage.clickContacts();
		
		ContactPage contact= new ContactPage(driver);
		contact.clickOnCreateContacts();
		
		CreateContactPage create=new CreateContactPage(driver);
		create.CreateContact(contactName);
		create.saveButton();
		
		ContactInformationPage info=new ContactInformationPage(driver);
		String actual=info.getContactsText();
		Assert.assertEquals(actual.contains(contactName), true);
		
		
	}

}

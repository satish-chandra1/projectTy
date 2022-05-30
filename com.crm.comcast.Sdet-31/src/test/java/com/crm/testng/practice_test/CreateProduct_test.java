package com.crm.testng.practice_test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genricutility.BaseClass;
import com.crm.autodesk.genricutility.ExcelUtility;
import com.crm.autodesk.genricutility.JavaUtility;
import com.crm.pom.objectrepository.CreateNewProductPage;
import com.crm.pom.objectrepository.HomePage;
import com.crm.pom.objectrepository.ProductInformationPage;
import com.crm.pom.objectrepository.Productpage;

public class CreateProduct_test extends BaseClass {

	@Test(groups="SmokeTest")
	public void createproduct() throws Throwable {
		ExcelUtility elib= new ExcelUtility();
		JavaUtility jlib =new JavaUtility();
		String productName=elib.getDataFromExcel("Sheet2", 1, 1)+jlib.getRandDomNumber();
		
		HomePage homepage=new HomePage(driver);
		homepage.clickOnproduct();
		
		Productpage product=new Productpage(driver);
		product.clickOnAddIcon();
		//Assert.fail();
		
		CreateNewProductPage create=new CreateNewProductPage(driver);
		create.createProducts(productName);
		create.saveButton();
		
		ProductInformationPage info=new ProductInformationPage(driver);
		String actual=info.productInformationText();
		Assert.assertTrue(actual.contains(productName));
		
		
		
	}
}

package com.crm.testng.practice_test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genricutility.BaseClass;
import com.crm.autodesk.genricutility.ExcelUtility;
import com.crm.autodesk.genricutility.JavaUtility;
import com.crm.pom.objectrepository.CampaignInformationPage;
import com.crm.pom.objectrepository.CampaignsPage;
import com.crm.pom.objectrepository.ContactInformationPage;
import com.crm.pom.objectrepository.CreateCampaignsPage;
import com.crm.pom.objectrepository.CreateNewProductPage;
import com.crm.pom.objectrepository.HomePage;
import com.crm.pom.objectrepository.Productpage;

public class CreateCampaignAndProduct_test extends BaseClass {

	@Test(groups="IntegrationTest")
	public void campaignAndProduct() throws Throwable  {
		ExcelUtility elib= new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		
		String productName=elib.getDataFromExcel("sheet2", 1, 1)+jlib.getRandDomNumber();
		String campaignName=elib.getDataFromExcel("Sheet2", 2, 1)+jlib.getRandDomNumber();
		
		HomePage homepage=new HomePage(driver);
		homepage.clickOnproduct();
		
		Productpage product=new Productpage(driver);
		product.clickOnAddIcon();
		
		CreateNewProductPage create= new CreateNewProductPage(driver);
		create.createProducts(productName);
		create.saveButton();
		
		homepage.mouseOverOnMoreImg(driver);
		
		CampaignsPage campaign=new  CampaignsPage(driver);
		campaign.CreateCampaign();
		
		CreateCampaignsPage camp=new CreateCampaignsPage(driver);
		camp.CreateCampaign(campaignName);
		camp.productLookup();
		camp.productName(driver, "Products", "Campaigns", productName);
		camp.savebutton();
		
		CampaignInformationPage info=new CampaignInformationPage(driver);
		
		String actual= info.getCampaignText();
		Assert.assertEquals(actual.contains(campaignName),true);
		
		
	}
}

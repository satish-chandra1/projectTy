package com.crm.testng.practice_test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.genricutility.BaseClass;
import com.crm.autodesk.genricutility.ExcelUtility;
import com.crm.autodesk.genricutility.JavaUtility;
import com.crm.pom.objectrepository.CampaignInformationPage;
import com.crm.pom.objectrepository.CampaignsPage;
import com.crm.pom.objectrepository.CreateCampaignsPage;
import com.crm.pom.objectrepository.HomePage;
@Listeners(com.crm.autodesk.genricutility.ListnerImplementationClass.class)
public class CreateCampaignTest extends BaseClass {

	@Test(groups="FunctionalTest")
	public void campaign() throws Throwable {
		ExcelUtility elib= new ExcelUtility();
		JavaUtility jlib =new JavaUtility();
		String campaignName=elib.getDataFromExcel("Sheet2", 1, 1)+jlib.getRandDomNumber();
		//Assert.fail();
		HomePage homepage=new HomePage(driver);
		homepage.mouseOverOnMoreImg(driver);
		
		CampaignsPage campaign=new CampaignsPage(driver);
		campaign.CreateCampaign();
		
		
		CreateCampaignsPage create=new  CreateCampaignsPage(driver);
		create.CreateCampaign(campaignName);
		create.savebutton();
		
		CampaignInformationPage info =new CampaignInformationPage(driver);
		String actual=info.getCampaignText();
		Assert.assertEquals(actual.contains(campaignName), true);
	}
}

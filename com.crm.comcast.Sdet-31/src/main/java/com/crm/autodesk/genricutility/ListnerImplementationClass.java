 package com.crm.autodesk.genricutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementationClass implements ITestListener{
	ExtentTest test;
	ExtentReports report;
	
	public void onTestStart(ITestResult result) {
		//step 3==>create a test method during the test execution starts
		
		//test=report.createTest(result.getMethod().getMethodName());
		test=report.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		//step4==>log the pass method
		test.log(Status.PASS,result.getMethod().getMethodName());
	}


	public void onTestFailure(ITestResult result) {
		//step 6==>log the failed method,take screenshot and exception log 
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
		WebDriverUtilty wlib=new WebDriverUtilty();
		String path=null;
		try {
			path=wlib.takeScreenshot(BaseClass.sDriver, result.getMethod().getMethodName());
		}
		catch(Throwable e){
			e.printStackTrace();	
		}
		test.addScreenCaptureFromPath(path);
		
		
	}

	public void onTestSkipped(ITestResult result) {
	//	Step 5==>log the skip method
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());

	}


	public void onStart(ITestContext context) {
		//step1==>extent report configuration
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./extentreport"+new JavaUtility().getSystemDateWithFormate()+".html");
		htmlreport.config().setReportName("regression execution report");
		htmlreport.config().setDocumentTitle("autodesk automation execution report");
		htmlreport.config().setTheme(Theme.DARK);
		
		//step2==>attach the physical report and do the system configuration
	    report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("os", "windows 11");
		report.setSystemInfo("Environment", "Testing Environment");
		report.setSystemInfo("url", "http://localhost:8888");
		report.setSystemInfo("ReporterName", "Satish");
		
		
	}

	public void onFinish(ITestContext context) {
		report.flush();
		}
	
	

}

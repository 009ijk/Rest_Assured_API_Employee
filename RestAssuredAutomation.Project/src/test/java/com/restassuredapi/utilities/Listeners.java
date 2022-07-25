package com.restassuredapi.utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners  extends TestListenerAdapter{
	
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	//public ExtentHtmlReporter htmlReporter;

	
	//set the parameter in the extent report
	public void onStart(ITestContext textContext)
	{
		//htmlReporter= new ExtentSparkReporter();// specify the location of the html file
			String path=System.getProperty("user.dir")+"/reports/myReport.html";
			System.out.println(path);
		//htmlReporter= new ExtentSparkReporter(path);
		htmlReporter= new ExtentSparkReporter("C:/Users/inderjeet.kumar_vvdn/eclipse-workspace/RestAssuredAutomation.Project/reports/myReport.html");
		htmlReporter.config().setDocumentTitle("Rest Assured Automation Project");
		htmlReporter.config().setReportName("Funcational Testing ");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("User", "Inder");
		extent.setSystemInfo("Environment", "QA");
		
		
	}
	// create for pass test cases
	public void onTestSuccess(ITestResult result)
	{
		test= extent.createTest(result.getName());// get the test class name 
		test.log(Status.PASS, "Test case Passed ID "+result.getName());
		
	}
	
	//create for fail test cases
	public void onTestFailure(ITestResult result)
	{
		test= extent.createTest(result.getName());// create the entry in report
		test.log(Status.FAIL, "Test case failled ID "+result.getName());
		test.log(Status.FAIL, "Test cases failled ID "+result.getThrowable()); //add the error message in the log file
		
	}

	//on Test cases SKIP
	public void onTestSkip(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIP ID "+result.getName());
		
	}
	
	//on finish flush the extent
	@AfterMethod
	public void onFinish()
	{
		extent.flush();
	}
	
	
}

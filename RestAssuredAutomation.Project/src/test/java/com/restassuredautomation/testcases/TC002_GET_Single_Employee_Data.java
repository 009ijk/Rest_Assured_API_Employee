package com.restassuredautomation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.restassuredapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_GET_Single_Employee_Data extends TestBase{
	

	@BeforeClass
	void getSingleEmployee() throws InterruptedException
	{
		logger.info("***Starting getting the Single Employee data******* ");
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1/employee";
		httpsRequest=RestAssured.given();
		response=httpsRequest.request(Method.GET, empID);
		Thread.sleep(3000);
		
	}
	
	@Test
	void checkResponseCode()
	{
		logger.info("**Checking the response code the 1 employee**");
		int responseCode=response.getStatusCode();
		logger.info("** Response Code is "+responseCode);
		Assert.assertEquals(responseCode,200);
	}
	
	
	@Test
	void checkResponseBody()
	{
		logger.info("**Check the response body**");
		String responseBody= response.getBody().asString();
		logger.info("***response body**"+responseBody.concat(empID));
		Assert.assertEquals(responseBody.contains(empID),true);
		
		
	}
	
	@AfterClass
	void tearDown()
	{
		logger.info("***Closing the TC002_GET_Single_Employee_Data ***");
	}
	
	
}

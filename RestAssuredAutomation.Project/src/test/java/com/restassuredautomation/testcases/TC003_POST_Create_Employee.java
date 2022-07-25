package com.restassuredautomation.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.restassuredapi.base.TestBase;
import com.restassuredapi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC003_POST_Create_Employee extends TestBase {
	
	String empName=RestUtils.empName();
	String empSalary=RestUtils.empSalary();
	String empAge=RestUtils.empAge();
	
	
	@BeforeClass
	void createEmployee() throws InterruptedException
	{
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		httpsRequest=RestAssured.given();
		
		
		// Create JSONObject
		JSONObject jsonpara=new JSONObject();
		
		jsonpara.put("name", empName);
		jsonpara.put("salary", empSalary);
		jsonpara.put("age", empAge);
		
		httpsRequest.header("Content-Type","application/json");
		
	// Add the request to the response of the Body
     httpsRequest.body(jsonpara.toJSONString());
     
     //Send the JSON body to the cloud 
     response=httpsRequest.request(Method.POST, "/create");
     Thread.sleep(5000);
	
		
	}
	 @Test
     void checkResponseBody()
     {
    	 logger.info("** Check response body is started***");
    	 String responseBody= response.getBody().asString();
    	 Assert.assertEquals(responseBody.concat(empName),true);
    	 Assert.assertEquals(responseBody.concat(empSalary),true);
    	 Assert.assertEquals(responseBody.concat(empAge),true);
    	 
     }
	 
	 @Test
	 void checkStatusCode()
	 {
		 logger.info("**Check the response status code**");
		 int statusCode=response.statusCode();
		 Assert.assertEquals(statusCode,200);
		 
	 }
	 
	 @AfterClass
	 void tearDown()
	 {
		 logger.info("***Employee creation is done**");
		 
	 }

}

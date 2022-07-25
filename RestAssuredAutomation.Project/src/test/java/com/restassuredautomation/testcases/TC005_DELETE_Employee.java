package com.restassuredautomation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.restassuredapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC005_DELETE_Employee extends TestBase {

	
	@BeforeClass
	void deleteEmployee() throws InterruptedException
	{
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		httpsRequest=RestAssured.given();
		
		//Create the json object 
		JsonPath jsonEvaluator= response.jsonPath();
		
		// Get the id of the Json object
		String newempID= jsonEvaluator.get("[0].id");
		
		response=httpsRequest.request(Method.DELETE, "/delete/"+newempID); // pass to delete the id
		
		Thread.sleep(3000);
		
	}
	
	@Test
	void checkResponseBody()
	{
		logger.info("****Check the response body will start.*****");
		String responseBody= response.getBody().asString();
		Assert.assertEquals(responseBody.concat("Successfully deleted Recored"), true);
	}
	
	@Test
	void checkStatusCode()
	{
		int statusCode= response.getStatusCode();
		Assert.assertEquals(statusCode,200);
		
	}
	
	@AfterClass
	void tearDown()
	{
		logger.info("***Closing the test cases*****");
	}
}

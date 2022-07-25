package com.restassuredautomation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.restassuredapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_GET_AllEmployee extends TestBase {
	
	
	

	@BeforeClass
	void getAllEmployee() throws InterruptedException
	
	{
		logger.info("************Started getting All Employee details ******************");
		RestAssured.baseURI= "https://dummy.restapiexample.com/api/v1";
		httpsRequest= RestAssured.given();
		response =  httpsRequest.request(Method.GET, "/employees");
		
		Thread.sleep(500);
	
	}
	
	
	@Test
	void checkResponseBody()
	{
		logger.info("**************Checking response Body*******************");
		String responseBody= response.getBody().asString();
		logger.info("response Body==>"+responseBody);
		Assert.assertTrue(responseBody!=null);
	
	}
	
	@Test 
	void checkResponseCode()
	{
		logger.info("*******Check the response code*****");
		int responseCode= response.getStatusCode();
		logger.info("response code==>"+responseCode);// 200
		Assert.assertEquals(responseCode, 200);
		
		
	}
	
	@Test 
	void checkResponseTime()
	{
		logger.info("****Check the response time taken ****");
		long responseTime= response.getTime();
		logger.info("response Time==> "+responseTime);
		
		if(responseTime<3000)
		logger.warn("Response time is less than 2000");
		
		Assert.assertTrue(responseTime<3000);
		
			
	}
	
	@Test
	void getStatusLine()
	{
      logger.info("*********Check the status line*************");
      
      String statusLine= response.getStatusLine();
      logger.info("status line ==>"+statusLine);
      Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@Test
	void checkContaintType()
	{
		logger.info("****check the containt type****");
		String containtType= response.contentType();
		logger.info("ContaintType is ==>"+containtType);
		Assert.assertEquals(containtType,"text/html; charset=UTF-8");
	}
	
//	@Test
//	void checkContentLenght()
//	{
//		logger.info("****check the containt lenght of the hearder***");
//		String contentLenght= response.header("Content-Lenght");
//		logger.info("Content lenght is "+ contentLenght);
//		if(Integer.parseInt(contentLenght)<100)
//			logger.warn("Content lenght is less then 100");
//		Assert.assertTrue(Integer.parseInt(contentLenght)>100);
//	
//		
//	}
	
	@Test
	void checkCookies()
	{
		logger.info("***check the cookies***");
		String checkCookies= response.getCookie("sdfsdf");
		
	}
	
	@AfterClass
	void tearDown()
	{
		logger.info("*****Closing the TC001_GET_AllEmployee*******");
	}
	
	
}

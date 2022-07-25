package com.restassuredapi.base;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	public static RequestSpecification httpsRequest;
	public static Response response;
	public  String empID="1";// hard code input 
	

	
	public Logger logger;
	
	@BeforeClass
	public void setup()
	{
		logger =Logger.getLogger("RestEmployeeAPI");// added logger 
		PropertyConfigurator.configure("test-output/log4j.properties");// added  logger
		
		logger.setLevel(Level.DEBUG);
	}

}

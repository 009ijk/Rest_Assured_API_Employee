package com.restassuredapi.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

	public static String empName()
	{
		String genratedName=RandomStringUtils.randomAlphabetic(1);
		return ("John"+genratedName);
		
	}
	
	public static String empSalary()
	{
		String genratedSalary=RandomStringUtils.randomAlphabetic(5);
		return (genratedSalary);
		
	}
	
	public static String empAge()
	{
		String genratedAge=RandomStringUtils.randomAlphabetic(2);
		return (genratedAge);
		
	}
	
	
	
}

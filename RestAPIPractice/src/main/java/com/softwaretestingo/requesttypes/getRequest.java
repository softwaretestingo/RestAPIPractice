package com.softwaretestingo.requesttypes;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getRequest 
{
	int statusCode;
	String statusLine;
	
	@Test
	public void getSingleUser()
	{
		RestAssured.baseURI="https://reqres.in/api/users/2";
		
		RequestSpecification reqSpec=RestAssured.given();
		Response response=reqSpec.get();
		
		statusCode=response.getStatusCode();
		statusLine=response.getStatusLine();
		
		System.out.println("Status Code: "+statusCode);
		System.out.println("Status Line: "+ statusLine);
		
		//Validate Status Code
		Assert.assertEquals(statusCode, 200, "Correct Status Code Received");
		
		//Validate Status Line
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Correct Status line Received");
	}
}

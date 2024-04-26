package com.softwaretestingo.autherization;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BasicAuthorization 
{
	@Test
	public void basicAuth()
	{
		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.baseUri("https://postman-echo.com");
		reqSpec.basePath("/basic-auth");
		reqSpec.auth().basic("postman", "password").get();
	}	
}
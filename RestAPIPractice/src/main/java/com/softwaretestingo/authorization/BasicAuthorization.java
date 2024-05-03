package com.softwaretestingo.authorization;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class BasicAuthorization 
{
	@Test
	public void basicAuthorizationTest()
	{
		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.baseUri("https://postman-echo.com");
		reqSpec.basePath("/basic-auth");
		Response response= reqSpec.auth().basic("postman", "password").get();
		System.out.println(response.asPrettyString());
	}	
}
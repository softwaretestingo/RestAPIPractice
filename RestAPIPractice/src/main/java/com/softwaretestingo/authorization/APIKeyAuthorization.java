package com.softwaretestingo.authorization;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class APIKeyAuthorization 
{
	@Test
	public void apiKeyAuthorizationTest()
	{
		RestAssured.baseURI = "http://api.weatherapi.com";
		RestAssured.basePath="/v1/current.json";
		
		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.queryParam("q", "London")
				.queryParam("aqi", "no")
				.queryParam("key", "0b7567ac66234b9daba104729230806");
		Response response=reqSpec.get();
		
		System.out.println(response.asPrettyString());
	}
}
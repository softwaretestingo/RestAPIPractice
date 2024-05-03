package com.softwaretestingo.requesttypes;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class HeadRequest 
{
	@Test
	public void headRequestTest() 
	{
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api/users/2";

		RequestSpecification reqSpec = RestAssured.given();
		Response response = reqSpec.head();
		
		//Print All The Header Values
		Headers headers=response.headers();
		for(Header header : headers)
		{
			System.out.println("Header Name: "+header.getName());
			System.out.println("Header Value: "+header.getValue());
			System.out.println();
		}
	}
}
package com.softwaretestingo.differentoperations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PrintAllHeaderValues 
{
	@Test
	public void allHeadersValues()
	{
		RestAssured.baseURI="https://gorest.co.in";
		RestAssured.basePath="/public/v2/users";
		
		RequestSpecification reqSpec=RestAssured.given();
		Response response=reqSpec.get();
		
		System.out.println("All Header Values");
		System.out.println("****************************");
		
		Headers headers=response.getHeaders();
		for(Header header : headers)
		{
			System.out.println("Header Name: "+header.getName());
			System.out.println("Header Value:"+header.getValue());
			System.out.println();
		}
	}
}

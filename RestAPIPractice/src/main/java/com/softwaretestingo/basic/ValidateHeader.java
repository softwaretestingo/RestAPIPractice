package com.softwaretestingo.basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateHeader 
{
	int statusCode;
	String contentTypeHeader;

	@Test
	public void validateHeader() 
	{
		RestAssured.baseURI = "https://reqres.in/api/users/2";

		RequestSpecification reqSpec = RestAssured.given();
		Response response = reqSpec.get();

		statusCode = response.getStatusCode();
		if (statusCode == 200) 
		{
			// Validating a Single Header
			contentTypeHeader = response.getHeader("Content-Type");
			System.out.println("Content-Type Values: " + contentTypeHeader);
			if (contentTypeHeader.contains("application/json"))
			{
				// Print All HeaderValues
				Headers headerList = response.getHeaders();
				System.out.println("==================================================");
				for (Header header : headerList) 
				{
					System.out.println(header.getName() + " " + header.getValue());
				}
				System.out.println("==================================================");
			}
		}
	}
}

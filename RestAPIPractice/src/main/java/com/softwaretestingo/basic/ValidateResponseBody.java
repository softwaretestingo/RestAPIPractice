package com.softwaretestingo.basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseBody 
{
	@Test
	public void validateSingleAttributeValue()
	{
		RestAssured.baseURI="https://reqres.in/api/users/2";
		
		RequestSpecification reqSpec=RestAssured.given();
		Response response=reqSpec.get();
		
		ResponseBody respBody=response.getBody();
		String respBodyString=respBody.asString();
		
		//Validating Is ResponseBody Contains that Specific Values
		if(respBodyString.contains("Weaver"))
		{
			System.out.println("Weaver Value Found In The Response Body");
		}
		else
			System.out.println("Weaver Is Not Available In ResponseBody");
	}
}

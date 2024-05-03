package com.softwaretestingo.differentoperations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetResponseBody 
{
	@Test
	public void getResponseBody()
	{
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/users/2";
		
		RequestSpecification reqSpec=RestAssured.given();
		Response response=reqSpec.get();
		
		//Get Response Body From Response
		ResponseBody respBody=response.getBody();
		String respString=respBody.asString();
		
		//Print the Response Body
		System.out.println("The Response Body Is: "+respString);
		System.out.println();
		
		//Print the Response Body in Pretty Format
		System.out.println("Print The Response Body In Pretty Format:"+response.asPrettyString());
	}
}

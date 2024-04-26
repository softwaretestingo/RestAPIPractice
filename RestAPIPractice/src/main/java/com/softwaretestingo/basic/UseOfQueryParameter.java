package com.softwaretestingo.basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class UseOfQueryParameter 
{
	@Test
	public void QueryParamUse()
	{
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/users/";
		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.queryParam("page", 2);
		Response response= reqSpec.get();
		String responseBody=response.asString();
		System.out.println("Print The Response: "+response.asPrettyString());
		
	}
}

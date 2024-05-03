package com.softwaretestingo.pathparameter;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SinglePathParameter {
	
	
	//https://simple-books-api.glitch.me
	@Test
	public void SinglePathParameterTest()
	{
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/users/";
		
		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.pathParam("userId", 1);
		Response response=reqSpec.get("/{userId}");
		
		System.out.println(response.asPrettyString());
	}

}

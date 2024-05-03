package com.softwaretestingo.specificationuses;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class RequestSpecificationUses 
{
	public static RequestSpecification RequestSpecificationTest()
	{
		RequestSpecification reqSpec=new RequestSpecBuilder()
										.setBaseUri("https://reqres.in")
										.setBasePath("/api/users")
										.build();
		
									  return reqSpec;
	}
	
	@Test
	public void getUsers()
	{
		Response response= RestAssured.given().spec(RequestSpecificationTest()).get();
		System.out.println(response.asPrettyString());
	}
}
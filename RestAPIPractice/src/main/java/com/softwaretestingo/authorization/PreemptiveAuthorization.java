package com.softwaretestingo.authorization;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class PreemptiveAuthorization 
{
	//Not Working Need to Check
	@Test
	public void preemptiveAuthorizationTest()
	{
		RestAssured.baseURI="https://the-internet.herokuapp.com";
		RestAssured.basePath="/basic_auth";
		
		RequestSpecification reqSpec=RestAssured.given();
		Response response = reqSpec.auth().preemptive().basic("admin", "admin").get();
		
		System.out.println(response.asPrettyString());
	}
}
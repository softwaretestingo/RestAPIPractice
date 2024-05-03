package com.softwaretestingo.differentoperations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PrintSingleHeader 
{
	@Test
	public void singleHeader()
	{
		RestAssured.baseURI="https://gorest.co.in";
		RestAssured.basePath="/public/v2/users";
		
		RequestSpecification reqspec=RestAssured.given();
		Response response=reqspec.get();
		
		System.out.println("Print The Date Of Response: "+response.getHeader("Date"));
	}
}
package com.softwaretestingo.differentoperations;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class PrintStatusCodeAndStatusLine 
{
	@Test
	public void statusCodeAndStatusLine()
	{
		RestAssured.baseURI="https://gorest.co.in";
		RestAssured.basePath="/public/v2/users";
		
		RequestSpecification reqSpec=RestAssured.given();
		Response response= reqSpec.get();
		
		System.out.println("Status Code: "+ response.getStatusCode());
		System.out.println("Status Line: "+ response.getStatusLine());
	}
}
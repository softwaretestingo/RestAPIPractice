package com.softwaretestingo.requesttypes;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class DeleteRequest 
{
	@Test
	public void deleteRequestTest()
	{
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api/users/2";

		RequestSpecification reqSpec = RestAssured.given();
		Response response = reqSpec.delete();
		
		int statusCode=response.getStatusCode();
		Assert.assertEquals(204, statusCode);
	}
}

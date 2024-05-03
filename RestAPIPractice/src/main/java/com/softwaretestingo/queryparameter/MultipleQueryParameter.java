package com.softwaretestingo.queryparameter;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class MultipleQueryParameter 
{
	@Test
	public void SingleQueryParameter()
	{
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/users/";
		
		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.queryParam("page", 2).queryParam("id", 7);
		Response response= reqSpec.get();
		System.out.println(response.asPrettyString());
	}
}

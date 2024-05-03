package com.softwaretestingo.differentoperations;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class PrintResponseBody 
{
	@Test
	public void responseBody()
	{
		RestAssured.baseURI="https://gorest.co.in";
		RestAssured.basePath="/public/v2/users";
		
		RequestSpecification reqSpec=RestAssured.given();
		Response response= reqSpec.get();

		//Print the ResponseBody
		System.out.println(response.asString());
		
		//Print The ResponseBody In Readable Format 
		System.out.println("******************************");
		System.out.println(response.asPrettyString());
	}
}

package com.softwaretestingo.differentoperations;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
public class ValidateResponseBodyContains 
{
	@Test
	public void validateResponseBody()
	{
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/users/2";
		
		RequestSpecification reqSpec=RestAssured.given();
		Response response=reqSpec.get();
		
		ResponseBody respBody=response.getBody();
		String respString=respBody.asString();
		
		//Check Response Contains "Janet"
		System.out.println(respString.contains("Janet"));
	}
}

package com.softwaretestingo.specificationuses;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
public class ResponseSpecificationUses 
{
	public static ResponseSpecification responseValidation()
	{
		ResponseSpecBuilder builder=new ResponseSpecBuilder();
		builder.expectStatusCode(200);
		builder.expectStatusLine("HTTP/1.1 200 OK");
		builder.expectContentType(ContentType.JSON);
		builder.expectResponseTime(Matchers.lessThan(30000L));
		
		ResponseSpecification responseSpec=builder.build();
		return responseSpec;
	}
	
	@Test
	public void getUserResult()
	{
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/users/2";
		
		RestAssured.given().get().then().spec(responseValidation());
	}	
}
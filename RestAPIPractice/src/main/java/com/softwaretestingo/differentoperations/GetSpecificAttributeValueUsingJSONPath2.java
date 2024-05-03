package com.softwaretestingo.differentoperations;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class GetSpecificAttributeValueUsingJSONPath2
{	
	@Test
	public void getFirstNameAttributeValue()
	{
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/users/2";
		
		RequestSpecification reqSpec=RestAssured.given();
		Response response=reqSpec.get();
		
		JsonPath js=response.jsonPath();
		String firstName = js.getString("data.first_name");
		System.out.println("First Name is: "+firstName);
	}
}
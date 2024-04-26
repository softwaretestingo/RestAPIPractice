package com.softwaretestingo.basic;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateValueUsingJsonPath {
	@Test
	public void ValidateSpecificAttributeValue()
	{
		RestAssured.baseURI = "https://reqres.in/api/users/2";

		RequestSpecification reqSpec = RestAssured.given();
		Response response = reqSpec.get();
		
		JsonPath pathview=response.jsonPath();
		String lastname=pathview.get("data.last_name");
		System.out.println("Last Name Is: "+lastname);
		Assert.assertEquals(lastname, "Weaver", "Value Not Found In That Field");
	}

}

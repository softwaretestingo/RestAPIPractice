package com.softwaretestingo.requesttypes;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest 
{
	@Test
	public void putRequestTest()
	{
		JSONObject payload = new JSONObject();
		payload.put("name", "SoftwareTestingO");
		payload.put("job", "Admin");

		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://reqres.in");
		reqSpec.basePath("/api/users/2");
		
		reqSpec.header("Content-type","application/json")
				.contentType(ContentType.JSON)
				.body(payload.toJSONString());
		Response response = reqSpec.put();
		System.out.println(response.asPrettyString());
		Assert.assertEquals(200, response.getStatusCode());
	}
}
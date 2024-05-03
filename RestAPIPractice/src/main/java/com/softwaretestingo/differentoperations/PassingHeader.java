package com.softwaretestingo.differentoperations;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PassingHeader 
{
	@Test
	public void passingHeaderTest()
	{
		JSONObject payload = new JSONObject();
		payload.put("name", "SoftwareTestingO");
		payload.put("job", "Blog");

		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://reqres.in");
		reqSpec.basePath("/api/users");

		//Passing Header
		reqSpec.header("Content-type","application/json");
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(payload.toJSONString());
		Response response = reqSpec.post();
		System.out.println("The Response Body is: " + response.asPrettyString());
	}
}

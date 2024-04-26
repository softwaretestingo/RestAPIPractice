package com.softwaretestingo.requesttypes;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithOutToken 
{
	@Test
	public void postRequest()
	{
		JSONObject payload=new JSONObject();
		payload.put("name", "SoftwareTestingO");
		payload.put("job", "Blog");
		
		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.baseUri("https://reqres.in/");
		reqSpec.basePath("/api/users");
		
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(payload.toJSONString());
		Response response= reqSpec.post();
		System.out.println("The Response Body is: "+response.asPrettyString());		
	}
}
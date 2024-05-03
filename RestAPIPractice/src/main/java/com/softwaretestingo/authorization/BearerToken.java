package com.softwaretestingo.authorization;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class BearerToken 
{
	@Test
	public void postRequestAuthorizationTest()
	{
		JSONObject payload = new JSONObject();
		payload.put("name", "SoftwareTestingO");
		payload.put("email", "test1@gmail.com");
		payload.put("gender", "female");
		payload.put("status", "inactive");

		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://gorest.co.in");
		reqSpec.basePath("/public/v2/users");
		
		//If You Got Authorization Failure Issue Then You Need to Check Bearer Token
		String token="Bearer 1ca8e3450e4a08c05c669534d8e9591245c5d260289c7418ad924c2e98c2996b";
		reqSpec.header("Authorization", token)
				.contentType(ContentType.JSON)
				.body(payload.toJSONString());
		
		Response response=reqSpec.post();
		System.out.println("Status Code: "+response.getStatusCode());
		System.out.println("Status Line: "+response.getStatusLine());
		System.out.println();
		System.out.println(response.asPrettyString());
	}
}
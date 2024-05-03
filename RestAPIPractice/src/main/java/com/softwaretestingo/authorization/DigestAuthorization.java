package com.softwaretestingo.authorization;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class DigestAuthorization 
{
	@Test
	public void digestAuthorizationTest()
	{
		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.baseUri("https://httpbin.org");
		reqSpec.basePath("/digest-auth/undefined/softwaretestingo/softwaretestingo");
		Response response = reqSpec.auth().digest("softwaretestingo", "softwaretestingo").get();
		System.out.println(response.asPrettyString());
	}
}

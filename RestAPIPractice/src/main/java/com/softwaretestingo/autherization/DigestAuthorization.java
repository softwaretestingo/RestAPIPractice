package com.softwaretestingo.autherization;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class DigestAuthorization 
{
	@Test
	public void digestAuth()
	{
		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.baseUri("https://httpbin.org");
		reqSpec.basePath("/digest-auth/undefined/softwaretestingo/softwaretestingo");
		reqSpec.auth().digest("softwaretestingo", "softwaretestingo").get();
	}
}

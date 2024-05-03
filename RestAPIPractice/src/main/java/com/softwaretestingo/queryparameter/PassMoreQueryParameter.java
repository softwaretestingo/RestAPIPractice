package com.softwaretestingo.queryparameter;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class PassMoreQueryParameter 
{
	@Test
	public void passMoreQueryParameterTest()
	{
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/users/";
		
		RequestSpecification reqSpec=RestAssured.given();
		
		Map<String, String> queryParamMap= new HashMap<String, String>();		
		queryParamMap.put("page", "2");
		queryParamMap.put("id", "7");
		queryParamMap.put("first_name", "Michael");
		queryParamMap.put("last_name", "Lawson");
		
		reqSpec.queryParams(queryParamMap);
		Response response=reqSpec.get();
		System.out.println("The Response Is: "+response.asPrettyString());
	}
}

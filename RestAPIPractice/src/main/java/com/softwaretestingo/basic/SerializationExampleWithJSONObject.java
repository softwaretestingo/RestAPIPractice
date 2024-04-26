package com.softwaretestingo.basic;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

class employee
{
	public String name;
	public String job;
	public int id;
	public String createdAt;
}
public class SerializationExampleWithJSONObject 
{
	String empJSON;
	emp obj;
	ObjectMapper mapper;
	//serialization = Object Data to JSON Data example
	@Test (priority = 1)
	public void SerData() throws JsonProcessingException
	{
	RequestSpecification reqSpec=RestAssured.given();
	reqSpec.baseUri("https://reqres.in/");
	reqSpec.basePath("/api/users");
	
	JSONObject payload=new JSONObject();
	payload.put("name", "SoftwareTestingo Blog");
	payload.put("job", "Content Writter");
	payload.put("id", 20);
	
	reqSpec.contentType(ContentType.JSON);
	reqSpec.body(payload.toJSONString());
	Response response= reqSpec.post();
	System.out.println(response.getBody().asString());
	}
}

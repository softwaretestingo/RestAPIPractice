package com.softwaretestingo.basic;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

class emp
{
	public String name;
	public String job;
	public int id;
	public String createdAt;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
}
public class SerializationExample 
{
	String empJSON;
	emp obj;
	ObjectMapper mapper;
	//serialization = Object Data to JSON Data
	@Test (priority = 1)
	public void SerData() throws JsonProcessingException
	{
	RequestSpecification reqSpec=RestAssured.given();
	reqSpec.baseUri("https://reqres.in/");
	reqSpec.basePath("/api/users");
	
	obj=new emp();
	obj.setName("SoftwareTestingo Blog");
	obj.setJob("Content Writter");
	obj.setId(10);

	mapper=new ObjectMapper();
	empJSON= mapper.writeValueAsString(obj);
	System.out.println(empJSON);
	}
	
	// Convert JSON Data to Object Data
	@Test (priority = 2)
	public void DeserializationExample()
	{
		System.out.println(empJSON);
		
		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.baseUri("https://reqres.in/");
		reqSpec.basePath("/api/users");
		
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(empJSON);
		Response response= reqSpec.post();
		Assert.assertEquals(response.getStatusCode(), 201, "Record is Not Created");
		ResponseBody rBody=response.getBody();
		
		
		
		System.out.println(response.asPrettyString());
		System.out.println("=================================");
		emp obj1=rBody.as(emp.class);
		System.out.println(obj1.getName());
		System.out.println(obj1.getJob());
		System.out.println(obj1.getId());
		
	}
}

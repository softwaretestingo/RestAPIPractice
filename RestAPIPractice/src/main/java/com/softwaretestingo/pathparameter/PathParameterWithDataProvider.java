package com.softwaretestingo.pathparameter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class PathParameterWithDataProvider {
	
	@Test(dataProvider = "getCircuitsYearData")
	public void pathParameterWithDataProviderTest(int year, int total)
	{
		RestAssured.baseURI="http://ergast.com";
		RestAssured.basePath="/api/f1/{year}/circuits.json";
		
		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.pathParam("year", year);
		
		Response response=reqSpec.get();
		
		JsonPath js=response.jsonPath();
		String totalTrack=js.get("MRData.total");
		System.out.println(totalTrack);
		System.out.println(total);
		System.out.println();
		
		Assert.assertEquals(Integer.parseInt(totalTrack), total);
	}
	
	@DataProvider
	public Object[][] getCircuitsYearData()
	{
		return new Object[][]
		{
			{2016,21},
			{2017,20},
			{2018,21},
			{2016,21},
		};
	}
}
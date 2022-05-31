package com.api.test.APITesting;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class HotelGet {

	@Test
	public void test_01()
	{
		Response resp=RestAssured.given().headers("X-RapidAPI-Host", "hotels4.p.rapidapi.com")
				.headers("X-RapidAPI-Key", "https://rapidapi.com/apidojo/api/hotels4/")
				.relaxedHTTPSValidation().when()
				.get("https://hotels4.p.rapidapi.com/locations/v2/search?query=new york&locale=en_US&currency=USD");
		System.out.println(resp.asString());
		Assert.assertEquals(resp.getStatusCode(),403);
	}
}

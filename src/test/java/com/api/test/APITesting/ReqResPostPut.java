package com.api.test.APITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class ReqResPostPut {
	
	@Test
	public void test_01()
	{
		Response resp=RestAssured.given().relaxedHTTPSValidation().
				when().contentType(ContentType.JSON).body(" ")
				.post("https://reqres.in/api/register");
		System.out.println(resp.asString());
		Assert.assertEquals(resp.getStatusCode(),400);
	}
	
	@Test
	public void test_02()
	{
		Response resp=RestAssured.given().relaxedHTTPSValidation().
				when().contentType(ContentType.JSON).body("{\r\n" + 
						"\r\n" + 
						"    \"email\": \"eve.holt@reqres.in\",\r\n" + 
						"\r\n" + 
						"    \"password\": \"test\"\r\n" + 
						"\r\n" + 
						"}")
				.post("https://reqres.in/api/login");
		System.out.println(resp.asString());
		Assert.assertEquals(resp.getStatusCode(),200);
	}
	
	@Test
	public void test_03()
	{
		Response resp=RestAssured.given().relaxedHTTPSValidation().
				when().contentType(ContentType.JSON).body("{\r\n" + 
						"    \"email\": \"eve.holt@reqres.in\",\r\n" + 
						"    \"password\": \"pistol\"\r\n" + 
						"}")
				.post("https://reqres.in/api/register");
		System.out.println(resp.asString());
		Assert.assertEquals(resp.getStatusCode(),200);
	}
	
	@Test
	public void test_04()
	{
		Response resp=RestAssured.given().relaxedHTTPSValidation().
				when().contentType(ContentType.JSON).body("{\r\n" + 
						"    \"name\": \"morpheus\",\r\n" + 
						"    \"job\": \"zion\"\r\n" + 
						"}")
				.put("https://reqres.in/api/users/2");
		System.out.println(resp.asString());
		Assert.assertEquals(resp.getStatusCode(),200);
	}
}

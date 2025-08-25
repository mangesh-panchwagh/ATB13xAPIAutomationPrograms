package ex_04_RestAssured_HTTP_Methods.GET;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class APITesting009_GET_NonBDDStyle {

	RequestSpecification r;	// pre request - given part
	Response response;		// making the request - when part
	ValidatableResponse vr;	// post request - then part
	String pincode;
	@Test
	public void test_GET_NonBDD() {
		
		pincode = "110001";
		r = RestAssured.given();
		r.baseUri("https://api.zippopotam.us");
		r.basePath("/IN/" + pincode);
		
		// Part 2 When part
		response = r.when().log().all().get();
		
		// Part 3 then part
		vr = response.then().log().all();
		vr.statusCode(200);
	}
	
	@Test
	public void test_GET_NonBDDNegative() {
		
		pincode = "@";
		r = RestAssured.given();
		r.baseUri("https://api.zippopotam.us");
		r.basePath("/IN/" + pincode);
		
		// Part 2 When part
		response = r.when().log().all().get();
		
		// Part 3 then part
		vr = response.then().log().all();
		vr.statusCode(400);
	}
	
	
}

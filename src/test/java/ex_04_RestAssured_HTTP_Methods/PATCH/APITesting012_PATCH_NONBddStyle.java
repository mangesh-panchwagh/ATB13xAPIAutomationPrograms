package ex_04_RestAssured_HTTP_Methods.PATCH;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class APITesting012_PATCH_NONBddStyle {

	// PATCH 
	
		// token , booking id 
	    // public void get_token(){ }
	    // public void get_booking_id(){}
		
		RequestSpecification r;
		Response response;
		ValidatableResponse vr;
		
		@Test
		public void test_patch_non_bdd() {
			
			String bookingid = "3130";
			String token = "50e7b9b11b9cd73";
			
			String payload = "{\r\n"
					+ "    \"firstname\" : \"James\",\r\n"
					+ "    \"lastname\" : \"Bond\"\r\n"
					+ "}";
			
			r = RestAssured.given();
			r.baseUri("https://restful-booker.herokuapp.com");
			r.basePath("/booking/" + bookingid);
			r.contentType(ContentType.JSON);
			//r.header("Cookie","token="+token);
			r.cookie("token",token);
			r.body(payload).log().all();
			
			response = r.when().log().all().patch();
			
			vr = response.then().log().all();
			vr.statusCode(200);
			
			 // we have not verified the response, we have only verified the status code.
			
		}
}

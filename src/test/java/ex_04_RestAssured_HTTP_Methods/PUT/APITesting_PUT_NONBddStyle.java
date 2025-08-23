package ex_04_RestAssured_HTTP_Methods.PUT;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class APITesting_PUT_NONBddStyle {

	// PUT 
	
	// token , booking id 
    // public void get_token(){ }
    // public void get_booking_id(){}
	
	RequestSpecification r;
	Response response;
	ValidatableResponse vr;
	
	@Test
	public void test_put_non_bdd() {
		
		String bookingid = "3130";
		String token = "50e7b9b11b9cd73";
		
		String payload = "{\r\n"
				+ "    \"firstname\" : \"Mangesh Updated\",\r\n"
				+ "    \"lastname\" : \"Panchwagh\",\r\n"
				+ "    \"totalprice\" : 3000,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2025-07-22\",\r\n"
				+ "        \"checkout\" : \"2025-07-27\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";
		
		r = RestAssured.given();
		r.baseUri("https://restful-booker.herokuapp.com");
		r.basePath("/booking/" + bookingid);
		r.contentType(ContentType.JSON);
		//r.header("Cookie","token="+token);
		r.cookie("token",token);
		r.body(payload).log().all();
		
		response = r.when().log().all().put();
		
		vr = response.then().log().all();
		vr.statusCode(200);
		
		 // we have not verified the response, we have only verified the status code.
		
	}
	
}

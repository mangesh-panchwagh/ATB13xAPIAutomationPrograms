package ex_06_TestAssetions;

import java.net.Authenticator.RequestorType;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class APITesting025_RestAsssured_Assertions {

	RequestSpecification requestSpecification;
	Response response;
	ValidatableResponse validatableResponse;
	String token;
	Integer bookingID;
	
	
	@Test
	public void test_createBooking_POST() {
		
		// payload
		// given - setting up the body, url ,base path, url
		// when - making the request
		// then - extraction
		
		String request_payload = "{\r\n"
				+ "    \"firstname\" : \"Mangesh\",\r\n"
				+ "    \"lastname\" : \"Panchwagh\",\r\n"
				+ "    \"totalprice\" : 3000,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2025-07-22\",\r\n"
				+ "        \"checkout\" : \"2025-07-27\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";
		
		requestSpecification = RestAssured.given();
		requestSpecification.baseUri("https://restful-booker.herokuapp.com");
		requestSpecification.basePath("/booking");
		
		// header information
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.body(request_payload);
				
		response = 	requestSpecification.log().all().post();
		
		// Get validate response to perform validation
		
		validatableResponse = response.then().log().all();
		
		// Rest Assured assertions
		validatableResponse.statusCode(200);
		
		//  Boooking ID !=null , firstname == Mangesh
		//  Extract the response body and do it
		
//		System.out.println(response.asString());
		
		System.out.println("My Assertins using Rest ASsured assertions method : ");
		validatableResponse.body("bookingid", Matchers.notNullValue());
		validatableResponse.body("booking.firstname", Matchers.equalTo("Mangesh"));
		validatableResponse.body("booking.lastname", Matchers.equalTo("Panchwagh"));
		validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));
		//validatableResponse.body("booking.bookingdates.checkin", Matchers.equalTo(true));
								  
		
	}
}

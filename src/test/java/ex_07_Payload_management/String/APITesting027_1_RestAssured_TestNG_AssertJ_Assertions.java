package ex_07_Payload_management.String;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class APITesting027_1_RestAssured_TestNG_AssertJ_Assertions {

	RequestSpecification requestSpecification;
	Response response;
	ValidatableResponse validatableResponse;

	String token;
	Integer bookingId;
	
	@Test
	public void test_POST() {
		
		String name = "Mangesh";
		
		String payload_POST = "{\r\n"
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
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.body(payload_POST);
		
		response = requestSpecification.when().log().all().post();
		
		validatableResponse = response.then().log().all();
		validatableResponse.statusCode(200);
		
	}
	
}

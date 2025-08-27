package ex_07_Payload_management.Map;

import java.util.LinkedHashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class APITesting028_RestAssured_Payload_Map {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingId;

    @Test
    public void test_POST() {
    	
//    	String payload_POST = "{\r\n"
//				+ "    \"firstname\" : \"Mangesh\",\r\n"
//				+ "    \"lastname\" : \"Panchwagh\",\r\n"
//				+ "    \"totalprice\" : 3000,\r\n"
//				+ "    \"depositpaid\" : true,\r\n"
//				+ "    \"bookingdates\" : {\r\n"
//				+ "        \"checkin\" : \"2025-07-22\",\r\n"
//				+ "        \"checkout\" : \"2025-07-27\"\r\n"
//				+ "    },\r\n"
//				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
//				+ "}";
    	
    	Map<String,Object> jsonBodyUsingMap = new LinkedHashMap<>();
    	
    	jsonBodyUsingMap.put("firstname", "Mangesh");
    	jsonBodyUsingMap.put("lastname", "Panchwagh");
    	jsonBodyUsingMap.put("totalprice", 32000);
    	jsonBodyUsingMap.put("depositpaid", true);
    	
    	Map<String,Object> bookingDatesMap = new LinkedHashMap<>();
    	bookingDatesMap.put("checkin", "2025-07-22");
    	bookingDatesMap.put("checkout", "2025-07-27");
    	
    	jsonBodyUsingMap.put("bookingdates", bookingDatesMap);
    	jsonBodyUsingMap.put("additionalneeds", "Breakfast");
    	
    	System.out.println(jsonBodyUsingMap);
    	
    	requestSpecification = RestAssured.given();
    	requestSpecification.baseUri("https://restful-booker.herokuapp.com");
    	requestSpecification.basePath("/booking");
    	requestSpecification.contentType(ContentType.JSON);
    	requestSpecification.body(jsonBodyUsingMap);
    	
    	response = requestSpecification.when().log().all().post();
    	
    	validatableResponse = response.then().log().all();
    	validatableResponse.statusCode(200);
    	
    	// Rest Assured -> import org.hamcrest.Matchers; %4-%5
        // Matchers.equalto()
    	
    	validatableResponse.body("booking.firstname", Matchers.equalTo("Mangesh"));
    	validatableResponse.body("booking.lastname", Matchers.equalTo("Panchwagh"));
    	validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));
    	validatableResponse.body("bookingid", Matchers.notNullValue());
    	//validatableResponse.body("bookingid", Matchers.notNullValue());
    }
}

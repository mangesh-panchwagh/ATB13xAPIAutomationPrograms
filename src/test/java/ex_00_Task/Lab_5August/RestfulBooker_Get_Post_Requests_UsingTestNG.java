package ex_00_Task.Lab_5August;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class RestfulBooker_Get_Post_Requests_UsingTestNG {

	@Test
	public void get() {
		
		// Get Ping Request
		RestAssured
			.given()
				.baseUri("https://restful-booker.herokuapp.com")
				.basePath("/ping")
			.when()
				.log()
				.all()
				.get()
			.then()
				.log()
				.all()
				.statusCode(201);
	}
	
	@Test
	public void post() {
		
		Map<String, Object> bookingDates = new HashMap<>(); 
	    bookingDates.put("checkin", "2025-07-22");
	    bookingDates.put("checkout", "2025-07-27");
	    
	    Map<String,Object> booking = new HashMap<>();
	    booking.put("firstname", "Mangesh");
	    booking.put("lastname", "Panchwagh");
	    booking.put("totalprice", 3000);   
	    booking.put("depositpaid", true);  
	    booking.put("bookingdates", bookingDates); 
	    booking.put("additionalneeds", "Breakfast");
	    
	    RestAssured
	            .given()
	                .baseUri("https://restful-booker.herokuapp.com")
	                .basePath("/booking")
	                .header("Content-Type","application/json")
	                .body(booking)
	            .when()
	                .log().all()
	                .post()
	            .then()
	                .log().all()
	                .statusCode(200);   
	                
	}
}

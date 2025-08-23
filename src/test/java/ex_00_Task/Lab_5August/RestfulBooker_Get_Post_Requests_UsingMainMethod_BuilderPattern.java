package ex_00_Task.Lab_5August;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class RestfulBooker_Get_Post_Requests_UsingMainMethod_BuilderPattern {

	public RestfulBooker_Get_Post_Requests_UsingMainMethod_BuilderPattern get() {
		
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
				
		
		return this;
	}
	
	public RestfulBooker_Get_Post_Requests_UsingMainMethod_BuilderPattern post() {
		
		Map<String, Object> bookingDates = new HashMap<>(); 
		bookingDates.put("checkin", "2025-07-22");
		bookingDates.put("checkout", "2025-07-27");
		
		Map<String,Object> booking = new HashMap<>();
		booking.put("firstname", "Mangesh");
		booking.put("lastname", "Panchwagh");
		booking.put("totalprice", "3000");
		booking.put("depositpaid", "true");
		booking.put("bookingDates", bookingDates);
		booking.put("additionalneeds", "Breakfast");
		
		
		RestAssured
				.given()
					.baseUri("https://restful-booker.herokuapp.com")
					.basePath("/booking")
					.header("Content-Type","application/json")
					/*
					.body("{\r\n"
							+ "    \"firstname\" : \"Mangesh\",\r\n"
							+ "    \"lastname\" : \"Panchwagh\",\r\n"
							+ "    \"totalprice\" : 3000,\r\n"
							+ "    \"depositpaid\" : true,\r\n"
							+ "    \"bookingdates\" : {\r\n"
							+ "        \"checkin\" : \"2025-07-22\",\r\n"
							+ "        \"checkout\" : \"2025-07-27\"\r\n"
							+ "    },\r\n"
							+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
							+ "}")
						*/
					.body(booking)
				.when()
					.log()
					.all()
					.post()
				.then()
					.log()
					.all()
					.statusCode(200);
					
				
		return this;
	}
	
	public static void main(String[] args) {
		
		RestfulBooker_Get_Post_Requests_UsingMainMethod_BuilderPattern gp = new RestfulBooker_Get_Post_Requests_UsingMainMethod_BuilderPattern();
		gp.get().post();
	}
}

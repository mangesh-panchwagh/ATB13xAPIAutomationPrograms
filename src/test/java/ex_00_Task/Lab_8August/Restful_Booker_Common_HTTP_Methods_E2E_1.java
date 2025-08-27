package ex_00_Task.Lab_8August;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

// - Create a List of the Test cases with different methods like GET, POST, DELETE, PUT PATCH for 
// Restfulbooker and Use TestNG and Set Different Priority and also Generate Allure report.

// :- Run the Test case  Parallel with Method Level, Class Level, Test Level.
public class Restful_Booker_Common_HTTP_Methods_E2E_1 {

	RequestSpecification r;
	Response response;
	ValidatableResponse vr;
	
	String baseURL = "https://restful-booker.herokuapp.com";
	String token;
	int bookingId;
	String firstname;
	
	@Test(priority = 1)
	public void createBooking() {
		
		String payload = "{\r\n"
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
		
		r = RestAssured.given();
		r.baseUri(baseURL);
		r.basePath("/booking");
		r.contentType(ContentType.JSON);
		r.body(payload).log().all();
		
		response = r.when().log().all().post();
		bookingId = response.jsonPath().getInt("bookingid");
		System.out.println("Booking id is : " + bookingId);
		vr = response.then().log().all();
		vr.statusCode(200);
	}
	
	@Test(priority=1)
	public void createAuthToken() {
		
		String payload = "{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}";
		
		r = RestAssured.given();
		r.baseUri(baseURL);
		r.basePath("/auth");
		r.contentType(ContentType.JSON);
		r.body(payload).log().all();
		
		response = r.when().log().all().post();
		token = response.jsonPath().getString("token");
		System.out.println(token);
		vr = response.then().log().all();
		vr.statusCode(200);
	}
	
	@Test(priority=2)
	public void updateBookingById() {
		
		String payload = "{\r\n"
				+ "    \"firstname\" : \"James\",\r\n"
				+ "    \"lastname\" : \"Brown Pune\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";
		
		r = RestAssured.given();
		r.baseUri(baseURL);
		r.basePath("/booking/" + bookingId);
		r.contentType(ContentType.JSON);
		r.cookie("token",token);
		r.body(payload).log().all();
		
		response = r.when().log().all().put();
		
		vr = response.then().log().all();
		vr.statusCode(200);
	}
	
	@Test(priority=3)
	public void getBookingById() {
		
		r = RestAssured.given();
		r.baseUri(baseURL);
		r.basePath("/booking/" + bookingId);
		r.contentType(ContentType.JSON);
		
		response = r.when().log().all().get();
		firstname = response.jsonPath().get("firstname");
		
		vr = response.then().log().all();
		vr.statusCode(200);
		firstname.equalsIgnoreCase("James");
	}
	
	@Test(priority=3)
	public void partialUpdateBooking() {
		
		String payload = "{\r\n"
				+ "    \"firstname\" : \"James\",\r\n"
				+ "    \"lastname\" : \"Brown\"\r\n"
				+ "}";
		
		r = RestAssured.given();
		r.baseUri(baseURL);
		r.basePath("/booking/1");
		r.contentType(ContentType.JSON);
		r.cookie("token", token);
		r.body(payload).log().all();
		
		response = r.when().log().all().patch();
		firstname = response.jsonPath().get("firstname");
		
		vr = response.then().log().all();
		vr.statusCode(200);
		firstname.equalsIgnoreCase("James");
	}
	
	@Test(priority=4)
	public void deleteBookingById() {
		
		r = RestAssured.given();
		r.baseUri(baseURL);
		r.basePath("/booking/" + bookingId);
		r.contentType(ContentType.JSON);
		r.cookie("token",token).log().all();
		
		response = r.when().log().all().delete();
		
		vr = response.then().log().all();
		vr.statusCode(201);
		
	}
	
}

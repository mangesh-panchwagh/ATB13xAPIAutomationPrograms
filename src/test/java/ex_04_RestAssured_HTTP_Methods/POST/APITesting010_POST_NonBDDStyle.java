package ex_04_RestAssured_HTTP_Methods.POST;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class APITesting010_POST_NonBDDStyle {

	RequestSpecification r;
	Response response;
	ValidatableResponse vr;
	
	
	@Test
	public void test_POST_NonBDDStyle_Create_Token(){
		
//		We need following while making the POST Request	
//		URL : https://restful-booker.herokuapp.com
//		Payload : {
//	    			"username" : "admin",
//	    			"password" : "password123"
//					}
//		Header : Content-Type : application/json
//		Cookie : NA
//		Auth : NA
//		Validate : 200 OK
//		Body Response : Token is generated or not
		
		String payload = "{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}";
		
		System.out.println(" ----    Part 1 ---- ");

        // Part 1 - Pre Condition - Preparing Request - URL, Headers, Auth...
		
		r = RestAssured.given();
		r.baseUri("https://restful-booker.herokuapp.com");
		r.basePath("/auth");
		r.contentType(ContentType.JSON);
//		r.header("Content-length","1000");
//		r.auth().basic("username", "password123");
//		r.auth().oauth2("44011701f8bab10");
//		r.header("Autorization","Bearer ey239823820328083");
		r.body(payload).log().all();
		
		 System.out.println(" ----    Part 2 ---- ");
	     // Making HTTP Request -> Part 2
		response = r.when().log().all().post();
		
		  System.out.println(" ----    Part 3 ---- ");
	        // Verification Part -> Part 3
		  vr = response.then().log().all();
	      vr.statusCode(200);
	}
}
















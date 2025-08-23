package ex_04_RestAssured_HTTP_Methods.DELETE;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class APITesting013_DELETE_NONBddStyle {

	// DELETE 
	
			// token , booking id 
		    // public void get_token(){ }
		    // public void get_booking_id(){}
			
			RequestSpecification r;
			Response response;
			ValidatableResponse vr;
			
			@Test
			public void test_delete_non_bdd() {
				
				String bookingid = "1514";
				String token = "c0757f8f13b4906";
				

				
				r = RestAssured.given();
				r.baseUri("https://restful-booker.herokuapp.com");
				r.basePath("/booking/" + bookingid);
				r.contentType(ContentType.JSON);
				//r.header("Cookie","token="+token);
				r.cookie("token",token);
			
				
				response = r.when().log().all().delete();
				
				vr = response.then().log().all();
				vr.statusCode(201);
				
				 // we have not verified the response, we have only verified the status code.
				
			}
}

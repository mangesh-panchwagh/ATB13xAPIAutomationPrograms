package ex_04_RestAssured_HTTP_Methods.POST;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class APITesting011_POST_BDDStyle {

	@Test
	public void  test_POST_Auth() {
		
		// https://restful-booker.herokuapp.com/auth
        // {
        //    "username" : "admin",
        //    "password" : "password123"
        //}

		String payload = "{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}";
		
		RestAssured
				.given()
					.baseUri("https://restful-booker.herokuapp.com")
					.basePath("/auth")
					.contentType(ContentType.JSON)
					.log()
					.all()
					.body(payload)
				.when()
					.log()
					.all()
					.post()
					
				.then()
					.log()
					.all()
					.statusCode(200);
	}
}

package ex_04_RestAssured_HTTP_Methods.GET;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class APITesting008_GET_BDDStyle {

	@Test
	public void test_GET_Request() {
		
		String pincode = "110048";
		RestAssured
			.given()
				.baseUri("https://api.zippopotam.us")
				.basePath("/IN/" + pincode)
			.when()
				.log()
				.all()
				.get()
			.then()
				.log()
				.all()
				.statusCode(200);
	}
}

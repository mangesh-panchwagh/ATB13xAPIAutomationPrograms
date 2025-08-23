package ex_02_RA_Concepts;

import io.restassured.RestAssured;

public class APITesting_Lab05_Multiple_TestCase {

	public static void main(String[] args) {
		
		String pincode = "110048";
		// This is direct BDD style. Not scalable People dont prefer to use it as it has duplicate codes.
		// Instead we can use classes and objects provided by RestAssured
		RestAssured.given()
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
		
		pincode = "@";
		RestAssured.given()
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
		
		pincode = " ";
		RestAssured.given()
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

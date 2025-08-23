package ex_01_RA_Basics;

import java.util.Scanner;

import io.restassured.RestAssured;

public class APITesting_Lab02_RA {

	public static void main(String[] args) {
		
		// Gherkins Syntax
        // Given() -> Pre Req. - URL, Headers, Auth, Body....
        // When() -> HTTP method? - GET/POST/PUT/PATCH, DELETE...
        // Then() -> Validation -> 200 oK, firstname == MANGESH
		
		// Full URL is divided into baseURL and base path 
		// Full URL - https://api.zippopotam.us/IN/560016
        // base URI - https://api.zippopotam.us
        // bath Path - /IN/560016
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the pincode !");
		String pincode = scan.nextLine();
		
		RestAssured.given()	
				.baseUri("https://api.zippopotam.us")
				.basePath("/IN/" + pincode)
				.log()
				.all()
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

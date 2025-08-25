package ex_06_TestAssetions;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.assertj.core.api.Assertions.*;

public class APITesting027_RestAssured_TestNG_AssertJ_Assertions {

	RequestSpecification requestSpecification;
	Response response;
	ValidatableResponse validatableResponse;
	String token;
	Integer bookingId;
	
	@Test
	public void test_POST() {
		
		String payload_POST = "{\r\n"
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
		
		requestSpecification = RestAssured.given();
		requestSpecification.baseUri("https://restful-booker.herokuapp.com");
		requestSpecification.basePath("/booking");
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.body(payload_POST).log().all();
	
		
		response  =  requestSpecification.when().log().all().post();
		
		 // Get Validate response to perform validation
		validatableResponse = response.then().log().all();
		validatableResponse.statusCode(200);
		
		// Rest Assured -> import org.hamcrest.Matchers; %4-%5
        // Matchers.equalto()
		
		validatableResponse.body("bookingid", Matchers.notNullValue());
		validatableResponse.body("booking.firstname", Matchers.equalTo("Mangesh"));
		validatableResponse.body("booking.lastname", Matchers.equalTo("Panchwagh"));
		validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));
		
		// Extraction
		// Concept #1 - Normal( TestNG or Assertj) IS IMP
        bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");
        
        // Concept #2 - (Jsonpath class) Another mechanism to extract the Keys, value by JSON Path
        JsonPath jp = new JsonPath(response.asString());
        String bookingID1 = jp.getString("bookingid");
        
//        assertThat(jp.getInt("bookingid")).isEqualTo(5164);
        assertThat(jp.getString("booking.firstname")).isEqualTo("Mangesh");
        assertThat(jp.getString("booking.lastname")).isEqualTo("Panchwagh");
        assertThat(jp.getInt("booking.totalprice")).isEqualTo(3000);
        assertThat(jp.getBoolean("booking.depositpaid")).isTrue();
		
        // TestNG - Extract the details of the firstname, bookingId, lastname from Response.
        // TestNG Assertions - 75%
        // SoftAssert vs HardAssert (90%)
        // This means that if any assertion fails,
        // the remaining statements in that test method will not be executed.
        Assert.assertEquals(firstname,"Mangesh");
        Assert.assertEquals(lastname,"Panchwagh");
        Assert.assertNotNull(bookingId);
		
        if(!firstname.contains("Mangesh")){
            Assert.fail("Failed kar diya Test");
        }
        
        // AssertJ( 3rd- Lib to Assertions) - 20%
        
        assertThat(bookingId).isNotZero().isNotNull().isPositive();
        assertThat(firstname).isNotBlank().isNotEmpty().isNotNull().isEqualTo("Mangesh");
		
	}
	
}

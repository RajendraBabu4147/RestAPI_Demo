package apidemopack;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestfulBooker_CreateDemo {
  @Test
  public void CreateBooking() 
  {
	  //json string for the parameters required for booking
	  String jsonStr = "{\n"
	  		+ "    \"firstname\" : \"Rajendra\",\n"
	  		+ "    \"lastname\" : \"Babu\",\n"
	  		+ "    \"totalprice\" : 111,\n"
	  		+ "    \"depositpaid\" : true,\n"
	  		+ "    \"bookingdates\" : {\n"
	  		+ "        \"checkin\" : \"2023-03-01\",\n"
	  		+ "        \"checkout\" : \"2023-03-05\"\n"
	  		+ "    },\n"
	  		+ "    \"additionalneeds\" : \"Breakfast\"\n"
	  		+ "}";
	  
	  RestAssured.given()
	  .relaxedHTTPSValidation()
	  .baseUri("https://restful-booker.herokuapp.com/booking")   //baseurl
	  .cookie("token","ac13e9c0ae30978")                         //auth token
	  .contentType(ContentType.JSON)                             //json with login creds
	  .body(jsonStr)                                             //json body with all parametrs for booking
	  .when()
	  .post()                                                     //post method
	  .then()
	  .assertThat()
	  .statusCode(200);                                          //assert status is 200 (success)
	  
	
  }
}

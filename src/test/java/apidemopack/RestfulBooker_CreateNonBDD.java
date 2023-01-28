package apidemopack;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestfulBooker_CreateNonBDD {
  @Test
  public void CreateBooking() {
	  
	  RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";
	  
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
	  
	  
	  RequestSpecification newReq = RestAssured.given().relaxedHTTPSValidation();
	  newReq.body(jsonStr);
	  newReq.cookie("token","ac13e9c0ae30978");
	  newReq.contentType(ContentType.JSON);
	  
	  Response resp = newReq.post();
	  System.out.println(resp.getStatusCode());
	  System.out.println(resp.getStatusLine());
	  System.out.println(resp.prettyPrint());
	  
	  
	  
  }
}

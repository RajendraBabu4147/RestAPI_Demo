package apidemopack;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestfulBooker_UpdateBooking {
  @Test
  public void UpdateBooking() {
	  
	  
	  
	  RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking/10";
	  
	  String jsonStr = "{\n"
		  		+ "    \"firstname\" : \"Rajendra\",\n"
		  		+ "    \"lastname\" : \"Babu\",\n"
		  		+ "    \"totalprice\" : 111,\n"
		  		+ "    \"depositpaid\" : true,\n"
		  		+ "    \"bookingdates\" : {\n"
		  		+ "        \"checkin\" : \"2023-03-03\",\n"
		  		+ "        \"checkout\" : \"2023-03-05\"\n"
		  		+ "    },\n"
		  		+ "    \"additionalneeds\" : \"Breakfast\"\n"
		  		+ "}";
	  
	  
	  RequestSpecification newReq = RestAssured.given().relaxedHTTPSValidation();
	  newReq.contentType(ContentType.JSON);
	  newReq.cookie("token","f3b1f95606ff63e");
	  newReq.body(jsonStr);

 
	  Response resp = newReq.put();
	  System.out.println(resp.getStatusCode());
	  System.out.println(resp.getStatusLine());
	  System.out.println(resp.prettyPrint());
  }
}

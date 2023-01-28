package apidemopack;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;

public class RestfulBooker_TestNG {
	
	String respToken;

  @BeforeTest
  public void beforeTest() 
  {
	  
	    String jsonString = "{\"username\": \"admin\",\"password\": \"password123\"}";
		
		RequestSpecification newReq = RestAssured.given().relaxedHTTPSValidation();
		newReq.contentType(ContentType.JSON);
		newReq.baseUri("https://restful-booker.herokuapp.com/auth");
		newReq.body(jsonString);
		Response resp = newReq.post();
		
		//Variable to store the reponse token
		respToken = resp.getBody().jsonPath().getString("token");	
		System.out.println("Resp token " +respToken);
  }
  
  @Test
  public void CreateBooking() 
  {
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
	  newReq.contentType(ContentType.JSON);
	  newReq.cookie("token",respToken);
  
	  newReq.baseUri("https://restful-booker.herokuapp.com/booking/10");
	  newReq.body(jsonStr);
	  
	  
	  Response resp = newReq.put();
	  System.out.println(resp.getStatusCode());
	  System.out.println(resp.getStatusLine());
	  System.out.println(resp.prettyPrint());
  }

}









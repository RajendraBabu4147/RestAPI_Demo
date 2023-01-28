package apidemopack;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestfulBooker_DELETE 
{
	
	public static void main(String[] args) 
	{
		
	  //DELETE Method
       RequestSpecification newReq = RestAssured.given().relaxedHTTPSValidation();
       newReq.cookie("token","1ecefd36a949ad1");
       
       newReq.baseUri("https://restful-booker.herokuapp.com/booking/15");
       
       Response resp = newReq.delete();
       
       //System.out.println(resp.getStatusLine());
       
       System.out.println(resp.asString());
       System.out.println(resp.getStatusCode());
      
       
	}

}


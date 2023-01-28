package apidemopack;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RestfulBook_POST {

	public static void main(String[] args) {
		
		//POST Method
		//pass username and passwd as json		
		String jsonString = "{\"username\": \"admin\",\"password\": \"password123\"}";
		
		RequestSpecification newReq = RestAssured.given().relaxedHTTPSValidation();
		
		newReq.contentType(ContentType.JSON);
		
		newReq.baseUri("https://restful-booker.herokuapp.com/auth");
		
		newReq.body(jsonString);
		
		Response resp = newReq.post();
		
		System.out.println(resp.asString());
		
		ValidatableResponse vResp = resp.then();
		 
		vResp.statusCode(200); //validate response code
		
		vResp.body("token",Matchers.notNullValue()); //validate token is not null
		vResp.body("token",Matchers.matchesRegex("^[a-z0-9]+$"));  //validate token is alphanumeric

	}

}


//400 series- client error
//098714b69270ccb from postman
//ac13e9c0ae30978  from code

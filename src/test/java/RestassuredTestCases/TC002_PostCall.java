package RestassuredTestCases;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TC002_PostCall {

	@Test
	public void createNewUserTest() {
	    HashMap map = new HashMap();
	    
	    //Creating Random Name
	    String CustName = RandomStringUtils.randomAlphabetic(7);
	    System.out.println(CustName);
	    //Creating Random Email
	    String CustEmail = "Thomas"+RandomStringUtils.randomNumeric(3)+"@gmail.com";
	    System.out.println(CustEmail);
	    
	    //creating Payload
        map.put("name", CustName);
	    map.put("email", CustEmail);
	    map.put("gender", "male");
    	map.put("status", "active");
    	
    	RestAssured.baseURI = "https://gorest.co.in";
    	RestAssured.basePath = "/public/v2/users"; 
    	
    	given()
    	       // Content Type
    	       .contentType("application/json")
    	       //Token
    	       .headers("Authorization", "Bearer e803433dffa6870f7c5bb755a8b135041e28fbfe649cf756ff7ebcb5677777b9")
    	       //body
    	       .body(map)
		.when()
		       .post()
		.then()
		     .statusCode(201) 
		     .contentType("application/json; charset=utf-8")
		     .body("name", equalTo(CustName))
		     .body("email", equalTo(CustEmail))
		     .log().all();
	
}	
}

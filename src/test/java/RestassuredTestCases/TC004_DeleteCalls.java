package RestassuredTestCases;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TC004_DeleteCalls {
	
         @Test(priority = 1)
	     public void DeleteUserWithToken() {
	    	 RestAssured.baseURI = "https://gorest.co.in";
	    	 RestAssured.basePath = "/public/v2/users/" +1301480; //Enter the user ID you want to Delete
	    	 
	    	 given()
  	         //Token
  	              .headers("Authorization", "Bearer e803433dffa6870f7c5bb755a8b135041e28fbfe649cf756ff7ebcb5677777b9")
		     .when()
		          .delete()
		     .then()
		          .statusCode(204)
	    	 .log().all();  
	     }
	     
         @Test(priority = 2)
         public void DeleteUserWithoutToken() {
	    	 RestAssured.baseURI = "https://gorest.co.in";
	    	 RestAssured.basePath = "/public/v2/users/" +1301480; //Enter the user ID you want to Delete
	    	 
	    	 given()
  	         //Not giving any token
		          .delete()
		     .then()
		          .statusCode(401)
		          .assertThat()
	              .body("message", equalTo("Authentication failed"))
	    	 .log().all();  
	     }
         
         @Test(priority = 3)
	     public void DeleteUserWithWrongToken() {
	    	 RestAssured.baseURI = "https://gorest.co.in";
	    	 RestAssured.basePath = "/public/v2/users/" +1301480; //Enter the user ID you want to Delete
	    	 
	    	 given()
  	         //Token
  	              .headers("Authorization", "Bearer e****Wrong*****Token****")
		     .when()
		          .delete()
		     .then()
		          .statusCode(401)
		          .assertThat()
		              .body("message", equalTo("Authentication failed"))
	    	 .log().all();  
	     }
}

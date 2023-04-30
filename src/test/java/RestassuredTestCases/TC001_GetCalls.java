package RestassuredTestCases;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.codehaus.groovy.transform.EqualsAndHashCodeASTTransformation;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC001_GetCalls {
	@Test
	public void getDetailsTest() {
		given()
		.when()
		       .get("https://ergast.com/api/f1/2017/circuits.json")
		.then()
		      // Checking Status code
		      .statusCode(200)
		      //.contentType("application/json; charset=utf-8")
		      .assertThat()
		      // Verifying headers
		      .header("Content-Type", "application/json; charset=utf-8")
	          .body("MRData.limit", equalTo("30"))
	          // Verifying if the following names are available in circuit Id.
	          .body("MRData.CircuitTable.Circuits.circuitId", hasItems("albert_park","americas","bahrain"))
		      .log().all();
		
	/*   Response resp =	given().when().get("https://ergast.com/api/f1/2017/circuits.json");
	   System.out.println(resp.prettyPrint());
		*/
	}

}

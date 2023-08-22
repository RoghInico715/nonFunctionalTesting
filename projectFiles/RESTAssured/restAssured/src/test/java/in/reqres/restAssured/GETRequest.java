package in.reqres.restAssured;

import java.io.IOException;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class GETRequest extends TestBase{
	
	@Test
	public void getRequest() throws IOException {
		RestAssured
		.given()
			.contentType("application/json")
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
			.assertThat()
			.statusCode(200)
			.log().all();
		logger.info("User detials are displayed");
	}
}

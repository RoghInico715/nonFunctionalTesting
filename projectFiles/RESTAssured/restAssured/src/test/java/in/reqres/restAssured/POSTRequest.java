package in.reqres.restAssured;

import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class POSTRequest extends TestBase{

	HashMap<String, String> map = new HashMap<String, String>();
	Response response;
	JsonPath jsonPath;
	
	@BeforeMethod
	public void createPayLoad() {
		map.put("name", "Morpheus");
		map.put("job", "painter");
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath = "/api/users";
		logger.info("Payload Created Successfully");
	}
	
	@Test
	public void postRequest() {
		response = RestAssured
			.given()
				.contentType("application/json")
				.body(map)
			.when()
				.post()
			.then()
				.statusCode(201)
				.log().all()
				.extract().response();
		logger.info("User Created Successfully");
		jsonPath = response.jsonPath();
		Assert.assertTrue(jsonPath.get("name").equals("Morpheus"));
	}
}

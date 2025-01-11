package datadrivenTesting;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddMultipleProjectWithoutDPTest {
	
	@Test
	public void sampleTest()
	{
		String pName="Google1";
		String status="Created";
		String requestBody = "{\r\n"
				+ "  \"createdBy\": \"Minit\",\r\n"
				+ "  \"projectName\": \""+pName+"\",\r\n"
				+ "  \"status\": \""+status+"\",\r\n"
				+ "  \"teamSize\": 0\r\n"
				+ "}";
		
		given()
			.contentType(ContentType.JSON)
			.body(requestBody)
		.when()
			.post("http://49.249.29.5:8091/addProject")
		.then()	
			.log().all();

		
	}

}

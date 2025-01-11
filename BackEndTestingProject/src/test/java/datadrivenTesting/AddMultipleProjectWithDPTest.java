package datadrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddMultipleProjectWithDPTest {
	
	@Test(dataProvider = "getData")
	public void sampleTest(String pName, String status)
	{
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
	
	@DataProvider
	public Object[][] getData() {
		Object[][] objArr = new Object[3][2];
		objArr[0][0] = "AirIndia_1";
		objArr[0][1] = "Created";

		objArr[1][0] = "AirIndia_2";
		objArr[1][1] = "Created";

		objArr[2][0] = "AirIndia_3";
		objArr[2][1] = "Created";

		return objArr;

	}

	
	
}

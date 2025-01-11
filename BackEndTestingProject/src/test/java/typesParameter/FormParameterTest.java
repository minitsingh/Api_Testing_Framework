package typesParameter;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class FormParameterTest {
	
	@Test
	public void sampleTest()
	{
		given()
			.formParam("teamSize", "10")
			.log().all()              //to log the request//
		.when()
			.post("http://49.249.28.218:8091/project")
		.then()
			.log().all();
	}

}

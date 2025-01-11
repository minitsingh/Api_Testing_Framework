package practice.responseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class VerifyResponseBodyViaJSonPathTest {
	
	@Test
	public void sampleTest()
	{
		
		/* for displaying the data */
//		given()
//			.get("http://49.249.28.218:8091/projects-paginated")
//		.then()
//			.log().all();
		
		/* for capturing put semi colon as we dont want to go for method chaining*/
		
		Response resp = given()
		.get("http://49.249.28.218:8091/projects-paginated");
		
		resp.then()
			.log().all();
				
		
		int data = resp.jsonPath().get("numberOfElements");
		System.out.println(data);
		
		boolean data1 = resp.jsonPath().get("pageable.sort.unsorted");
		System.out.println(data1);
		
		String data2 = resp.jsonPath().get("content[0].projectId");
		System.out.println(data2);
		
		/*
		 * assertion / validation
		 */
		
		resp.then().assertThat().body("numberOfElements", Matchers.greaterThanOrEqualTo(20));
		resp.then().assertThat().body("pageable.sort.unsorted", Matchers.equalTo(true));
		resp.then().assertThat().body("content[0].projectId", Matchers.equalTo("NH_PROJ_983"));
		
	}

}

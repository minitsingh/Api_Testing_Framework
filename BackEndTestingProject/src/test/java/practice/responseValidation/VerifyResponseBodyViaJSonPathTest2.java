package practice.responseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
/*
 * this is the class for capturing multiple data
 */
public class VerifyResponseBodyViaJSonPathTest2 {
	
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
				
		/*
		 * assertion / validation
		 */
		
		resp.then().assertThat().body("numberOfElements", Matchers.greaterThanOrEqualTo(20));
		resp.then().assertThat().body("pageable.sort.unsorted", Matchers.equalTo(true));
		resp.then().assertThat().body("content[0].projectId", Matchers.equalTo("NH_PROJ_979"));
		
		/*
		 * regex (*) is not allowed in rest assured json xpath 
		 * so the below expression will give an error
		 */
		
		
		ArrayList<String> lst = resp.jsonPath().get("content[*].projectId");
		/* the below expression will fetch us all the projectId */
	//	ArrayList<String> lst = resp.jsonPath().get("content.projectId");
		System.out.println(lst);
		
	}

}

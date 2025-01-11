package request_chaining;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.utility.ProjectPojo;

public class Scenario_1_DeleteProject {

	@Test
	public void postDataFromServer() {
		Random random = new Random();
		int ranNum = random.nextInt(5000);
		
		//create a object to pojo class		
		//API-1 ==> add a project inside the server
		
		ProjectPojo pObj = new ProjectPojo("Airtel"+ranNum, "Created", "Minit Singh", 0);
		
		Response resp = given()
							.contentType(ContentType.JSON)
							.body(pObj)
						.when()
							.post("http://49.249.28.218:8091/addProject");
		
						resp.then()
							.assertThat().statusCode(201)
							.and()
							.assertThat().body("msg", Matchers.equalTo("Successfully Added"))
							.log().all();
						
				// capture the projectName from the response	
				String projectId	=	resp.jsonPath().get("projectId");
				System.out.println(projectId);
				
		//API-2 delete Project 
				given()
					.delete("http://49.249.28.218:8091/project/"+projectId)
					
				.then()
					.log().all();
				
				
			
						
						
		
    	
		
	}
	

}

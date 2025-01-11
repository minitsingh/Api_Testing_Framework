package request_chaining;

import static io.restassured.RestAssured.*;
import java.util.Random;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.utility.EmployeePOJO;
import pojoclass.utility.ProjectPojo;

public class Scenario_2_AddAEmployeeToProject {
	
	@Test
	public void sampleTest()
	{
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
				String projName	=	resp.jsonPath().get("projectName");
				System.out.println(projName);
				
		//API-2 ==> Add employee to the same project
		
		EmployeePOJO empObj = new EmployeePOJO("Architect", "24/04/1983", "minitsingh@gmail.com", "user_"+ranNum, 18, "0987654321", projName, "ROLE_EMPLOYEE","user_"+ranNum);		
				
						given()
							.contentType(ContentType.JSON)
							.body(empObj)
						.when()
							.post("http://49.249.28.218:8091/employees")
						.then()
							.assertThat().statusCode(201)
							.log().all();
						
				
				
	}

}

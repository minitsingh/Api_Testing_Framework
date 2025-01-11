package practice.postRequestTypes;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoclass.utility.ProjectPojo;

public class PostReq_via_PojoClassTest {

	@Test
	public void postDataFromServer() {
		
		Random random = new Random();
		int ranNum = random.nextInt(5000);
		
		//create a object to pojo class
		ProjectPojo pObj = new ProjectPojo("kiwi"+ranNum, "Created", "Minit Singh", 0);
		
		given()
			.contentType(ContentType.JSON)
			.body(pObj)
		.when()
			.post("http://49.249.28.218:8091/addProject")
		.then()
			.assertThat().statusCode(201)
			.log().all();
			
		
    	
		
	}
	

}

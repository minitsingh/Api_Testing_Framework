package practice.postRequestTypes;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReq_via_JsonObjectTest {
	
	
	@Test
	public void postDataFromServer()
	{
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("createdBy", "Minit Singh");
		jsonObj.put("projectName", "NagDevta");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
		
		
		given()
			.contentType(ContentType.JSON)
			.body(jsonObj.toJSONString())
		.when()
			.post("http://49.249.28.218:8091/addProject")
		.then()
			.assertThat().statusCode(201)
			.log().all();
			
		
    	
		
	}
	

}

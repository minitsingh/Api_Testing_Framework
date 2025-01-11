package com.sample.crud.withbddtest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

/**
 * @author MINIT SINGH
 * sample test for practice create(put)
 * json simple and json object creation
 */
public class SampleTestForCreateTest {
	
	@Test
	public void postDataFromServer()
	{
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("createdBy", "Minit Singh");
		jsonObj.put("projectName", "NgDevta");
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

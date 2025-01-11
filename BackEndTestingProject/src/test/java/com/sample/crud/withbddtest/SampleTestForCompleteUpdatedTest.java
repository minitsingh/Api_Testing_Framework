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
public class SampleTestForCompleteUpdatedTest {
	
	@Test
	public void putDataFromServer()
	{
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("createdBy", "Minit Singh");
		jsonObj.put("projectName", "NagDevi");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
		
		
		given()
			.contentType(ContentType.JSON)
			.body(jsonObj.toJSONString())
		.when()
			.put("http://49.249.28.218:8091/project/NH_PROJ_3303")
		.then()
			.assertThat().statusCode(200)
			.log().all();
			
		
	}
	
	

}

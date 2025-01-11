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
public class SampleTestForPartialUpdateTest {
	
	@Test
	public void putDataFromServer()
	{
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("createdBy", "Minit Singh");
		jsonObj.put("projectName", "NagDevtaya");
		
		
		given()
			.contentType(ContentType.JSON)
			.body(jsonObj.toJSONString())
		.when()
			.patch("http://49.249.28.218:8091/project/NH_PROJ_3303")
		.then()
			.assertThat().statusCode(200)
			.log().all();
		
		
	}
	
	

}

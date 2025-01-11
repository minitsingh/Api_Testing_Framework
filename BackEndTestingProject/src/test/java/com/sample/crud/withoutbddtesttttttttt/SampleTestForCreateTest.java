package com.sample.crud.withoutbddtesttttttttt;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

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
		jsonObj.put("projectName", "NagDevta");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
		
		
		
		
    	RequestSpecification reqSpec = RestAssured.given();
    	reqSpec.contentType(ContentType.JSON);
    	reqSpec.body(jsonObj.toJSONString());
    	Response resp = reqSpec.post("http://49.249.28.218:8091/addProject");
    	resp.then().log().all();
    	//resp.then().log().headers();
    	resp.then().assertThat().statusCode(201);
		
	}
	
	

}

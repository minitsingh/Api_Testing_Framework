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
public class SampleTestForPartialUpdateTest {
	
	@Test
	public void putDataFromServer()
	{
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("createdBy", "Minit Singh");
		jsonObj.put("projectName", "NagDevtaya");
		
		
		
    	RequestSpecification reqSpec = RestAssured.given();
    	reqSpec.contentType(ContentType.JSON);
    	reqSpec.body(jsonObj.toJSONString());
    	Response resp = reqSpec.patch("http://49.249.28.218:8091/project/NH_PROJ_3245");
    	resp.then().log().all();
    	//resp.then().log().headers();
    	resp.then().assertThat().statusCode(200);
		
	}
	
	

}

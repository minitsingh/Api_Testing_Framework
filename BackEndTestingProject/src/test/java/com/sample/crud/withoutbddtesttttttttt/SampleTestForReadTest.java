package com.sample.crud.withoutbddtesttttttttt;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * @author MINIT SINGH
 * sample test for practice get
 */
public class SampleTestForReadTest {
	
	@Test
	public void getDataFromServer()
	{
		Response resp = RestAssured.get("http://49.249.28.218:8091/projects");
		System.out.println(resp.prettyPrint());
		
		resp.then().assertThat().statusCode(200);
		//resp.then().log().headers();
		resp.then().log().all();
		
	}
	
	

}

package com.sample.crud.withoutbddtesttttttttt;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTestForDeleteTest {
	
	@Test
	public void deleteDataFromServer()
	{
		Response resp = RestAssured.delete("http://49.249.28.218:8091/project/NH_PROJ_982");
		System.out.println(resp.prettyPrint());
		
		resp.then().assertThat().statusCode(204);
		//resp.then().log().headers();
		resp.then().log().all();
		
	}

}

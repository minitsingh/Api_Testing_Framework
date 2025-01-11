package com.sample.crud.withbddtest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


/**
 * @author MINIT SINGH
 * sample test for practice get
 */
public class SampleTestForDeleteTest {
	
	@Test
	public void deleteDataFromServer()
	{
		given()
			.delete("http://49.249.28.218:8091/project/NH_PROJ_3303")
		.then()	
			.assertThat().statusCode(204)
			.log().all();
	}
	
	

}

package practice.responseValidation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class VerifyDataFromComplexJSON_XpathForDynamicPayload {
	
	@Test
	public void sampleTest()
	{

		Response resp = given()
		.get("http://49.249.28.218:8091/projects-paginated");
		
		resp.then()
			.log().all();
		
		/* like below we can capture data from complex json x-path and use regex(*) also */
		
		List<String> list = JsonPath.read(resp.asString(),".content[*].projectName");
		for(String data : list)
		{
			System.out.println(data);
		}
		
		List<String> list1 = JsonPath.read(resp.asString(),".content[*].[?(@.projectName=='Apple100')].projectId");
		String actualProjectId = list1.get(0);
		
		Assert.assertEquals(actualProjectId, "NH_PROJ_979");
		
		//extract firstProjectId 
		//DB validation
		//Request Chaining
		
		
		
	}

}

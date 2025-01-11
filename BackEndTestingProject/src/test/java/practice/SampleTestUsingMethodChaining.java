package practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class SampleTestUsingMethodChaining {
	@Test
	public void getRequestTest() {
		
		
		get("https://reqres.in/api/users?page=2")
		.then()
		.log()
		.all();
		
		
		//RestAssured.get("https://reqres.in/api/users?page=2").prettyPrint();
		
		//Response resp = RestAssured.get("https://reqres.in/api/users?page=2");
		//System.out.println(resp.prettyPrint());
	}

}

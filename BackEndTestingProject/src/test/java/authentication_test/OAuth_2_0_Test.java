package authentication_test;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


/**
 * Aouth2 protocol and saved in notepad 
 * 
 */
public class OAuth_2_0_Test {
	@Test
	public void sampleTest()
	{
		
		//1st api-1 to fetch the token received from response then captured
		
		 Response resp=given()
			.formParam("client_id", "ninza-client")
			.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
			.formParam("grant_type", "client_credentials")
		
		.when()
			.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		
		 resp.then()
			.log().all();
		
		// capture token from the response [KeyClock(Oauth2.0]
		
		String token=resp.jsonPath().get("access_token");
		
		//after capturing rest program is exactly similar to bearer token
		
		given()
			.auth().oauth2(token)
			.log().all()
		.when()
			.get("http://49.249.28.218:8091/projects")
		.then()
			.log().all();
		
		
	}
	

}

package practice.postRequestTypes;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReq_via_HashMapTest {

	@Test
	public void postDataFromServer() {
		HashMap<String, Object> map = new HashMap();

		map.put("createdBy", "Minit Singh");
		map.put("projectName", "NagDevta1");
		map.put("status", "Created");
		map.put("teamSize", 0);

		given()
			.contentType(ContentType.JSON)
			.body(map)
		.when()
			.post("http://49.249.28.218:8091/addProject")
		.then()
			.assertThat().statusCode(201)
			.log().all();

	}

}

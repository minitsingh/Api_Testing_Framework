package panCardMock;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import net.minidev.json.JSONObject;

import static io.restassured.RestAssured.*;
public class PaymentTest {
	
	@Test
	public void sampleTest()
	{
		//pass the request payload in the form of json
		/*
		 * String body ="{\r\n" + " \"creditcard\" : \"1234567891234\",\r\n" +
		 * " \"cvv\" : \"123\",\r\n" + " \"cardName\" : \"Minit\"\r\n" + "}";
		 */
		
		JSONObject obj = new JSONObject();
		obj.put("creditcard", "1234567891234");
		obj.put("cvv", "123");
		obj.put("cardName", "Minit");
		
		
		given()
			.contentType(ContentType.JSON)
			.body(obj)
		.when()
			.post("http://localhost:8999/credit-card")   //mocking solution running in local system
		.then().log().all();
	}

}

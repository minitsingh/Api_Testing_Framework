package encryption;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;


/**
 * here 500 giving both in sir and mine but the message from the server is different
 * sir's message : illegal server error
 * my message in console : Illegal base64 character 7b
 */
public class UpdatePayInfoViaAESEncryptionTest {
	
	@Test
	public void sampleTest() throws Exception
	{
		EncrypAndDecryptUtility ed = new EncrypAndDecryptUtility();
		
		
		String jBody = " { \"employee\": { \"empId\":\"NH_00013\", \"designation\": \"string\", \"dob\": \"dd/MM/yyyy\", \"email\": \"string\", \"empName\": \"string\", \"experience\": 0, \"mobileNo\": \"string\", \"project\": \"string\", \"role\": \"string\", \"username\": “string” }, \"basicPlusVda\": 0, \"hra\": 0, \"insurance\": 0, \"lta\": 0, \"lwf\": 0, \"netPay\": 5000, \"payroll_id\": 0, \"pf\": 0, \"pt\": 0, \"stat_bonus\": 0, \"status\": “Active/Disabled” }";
		
		String jRequestBody = ed.encrypt(jBody, "Ac03tEam@j!tu_#1");
		System.out.println(jRequestBody);
		
		Response resp = given()
			.body(jRequestBody)
		.when()
			.put("http://49.249.28.218:8091/payroll");
		resp.then()
			.log().all();	
		
		String respBody = ed.decrypt("ATI1EfliChXkNB9Qy2m5K/heQzaNBduFMk5tH1VIK99PuoJNTbwtg47XNdlfJWFCCc5npvPRUwEbPoH97D6a3ze8O3AKyhRv1UZrKrRkVZw+6+qS2pxTBahPzFLGv7c6PGAWsK+zOk6/r+0+C0zTo4NJ8saGOsxeinMRrbvb/Sb40BWZ+5KjQMcNlpvTYwmIuhPgg/vUabZhgSjuM4+hRx6Mj8U+bOeAvh5zUgge+WRN3a1K1f1FNmoI1R07rc5FUvLzJkFNejqhsEL0CnE52TruhjOJLIe/q0jq3TmsCzu6ZxGtoZpVs2qmyn9rHJnVNbtg5CkdKgr0BfM1Qd9XRXhtOf+5/DNZfnI56TijOl6/vAysTUd5ZIt8BHBNh/w/tMvWs9cWIq5n8yPubYnP0Nnv/77x84tecWtU56+T51ZO1CilKEcQBCFFqT4Fzw7BUKoLc/331trOfYx2iPhYgwghMQsukItEeu3GgluuvV5zNACROkgbhAra21RRJNnwbleP/U/G3S4mxv//sI/QEA==", "Ac03tEam@j!tu_#1");
		System.out.println(respBody);
		
	}

}

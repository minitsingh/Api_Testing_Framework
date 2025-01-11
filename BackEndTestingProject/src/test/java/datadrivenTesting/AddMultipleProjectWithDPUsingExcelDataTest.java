package datadrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddMultipleProjectWithDPUsingExcelDataTest {
	
	@Test(dataProvider = "getData")
	public void sampleTest(String pName, String status)
	{
		String requestBody = "{\r\n"
				+ "  \"createdBy\": \"Minit\",\r\n"
				+ "  \"projectName\": \""+pName+"\",\r\n"
				+ "  \"status\": \""+status+"\",\r\n"
				+ "  \"teamSize\": 0\r\n"
				+ "}";
		
		given()
			.contentType(ContentType.JSON)
			.body(requestBody)
		.when()
			.post("http://49.249.29.5:8091/addProject")
		.then()	
			.log().all();

		
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
		int count = eLib.getRowCount("project");
		Object[][] objArr = new Object[count][2];

		for (int i = 0; i < count; i++) {
			objArr[i][0] = eLib.getDataFromExcel("project", i + 1, 0);
			objArr[i][1] = eLib.getDataFromExcel("project", i + 1, 1);
		}

		return objArr;

	}

	
	
}

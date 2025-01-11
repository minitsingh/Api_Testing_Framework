package practice.responseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.concurrent.TimeUnit;

public class VerifyResponseTimeTest {

	@Test
	public void verifyHeader() {
		/*
		 * given() .get("http://49.249.28.218:8091/projects") .then().log().all();
		 */

		/* to capture the response */

		Response resp = given()
				.get("http://49.249.28.218:8091/projects");

		resp.then().log().all();

		/* response time in millisecond */
		long timeTaken = resp.time();

		/* time taken in second */
		/* if the time is less than 1 second then it'll show 0 */
		long timeTakenSeconds = resp.timeIn(TimeUnit.SECONDS);

		System.out.println(timeTaken);
		System.out.println(timeTakenSeconds);

		/*
		 * validation using matcher class and at the end provide L because it takes long
		 * type of data
		 */

		resp.then().assertThat().time(Matchers.lessThan(900L));
		resp.then().assertThat().time(Matchers.greaterThan(300L));

		/* validation for both greater and less than */

		resp.then().assertThat().time(Matchers.both(Matchers.lessThan(900L)).and(Matchers.greaterThan(300L)));
		
		 
	}
}

package practice;

import org.testng.annotations.Test;

import static com.backend.testing.AA.*;

public class Run2 {

	/**
	 * for method chaining
	 */
	
	@Test
	public void sampleTest()
	{
		a().b().c().d();
		
		/* all the method a,b,c are static and d is not static */ 
		/* still we'll be able to access  */
				
	}
}

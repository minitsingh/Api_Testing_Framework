package panCardMock;

import org.mockito.Mockito;
import org.testng.Assert;

/**
 *   Development of Stub 
 */


class PANCard{
	
	
	// here development of stub and the dummy data using mockito
	// method we'll use the getMockData method 
	
	public static PANCard getMockObject()
	{
		PANCard mockObj = Mockito.mock(PANCard.class);
						  Mockito.when(mockObj.isvalid("ABCDE1234A")).thenReturn("valid Pan Card");
						  Mockito.when(mockObj.isvalid("ABCDE1234B")).thenReturn("valid Pan Card");
						  Mockito.when(mockObj.isvalid("ABCDE1234C")).thenReturn("invalid Pan Card");
						  
		return mockObj;
		
	}
	
	
	
	/*
	 * static because we want to call this method inside the main method
	 * this the buisness library for validation
	 */
	public String isvalid(String panCard)
	{
		// validation of pancard using Matches Class
		// even if you take one at the end or not doesnt matter for one character
		if(panCard.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")==true)
		{
			return "is valid pan";
		}
		else
			return "is in-valid pan";
	}
	
	
}


public class MockingTest {
	
	public static void main(String[] args) {
		
		PANCard obj = PANCard.getMockObject();
		//assertion 
		Assert.assertEquals(obj.isvalid("ABCDE1234C"), "valid pan card");
		System.out.println(obj.isvalid("ABCDE1234A"));
		
		
		
		
		
	}

}

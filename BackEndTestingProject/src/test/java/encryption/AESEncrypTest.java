package encryption;

import org.testng.annotations.Test;
/*
 * Encryption and Decryption of plain test 
 */
public class AESEncrypTest {
	
	@Test
	public void sampleTest() throws Exception
	{
		String privateKey = "Ac03tEam@j!tu_#1";
		String data = "minit";
		
		EncrypAndDecryptUtility ed = new EncrypAndDecryptUtility();
		System.out.println(ed.encrypt(data,privateKey));
		
		System.out.println(ed.decrypt("75mZ2BXSq4ztBd+mA0xuyg==",privateKey));
		
		
		
	}

}

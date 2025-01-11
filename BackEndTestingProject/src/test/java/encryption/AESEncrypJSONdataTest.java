package encryption;

import org.testng.annotations.Test;
/*
 * Encryption and Decryption of JSON Data
 */
public class AESEncrypJSONdataTest {
	
	@Test
	public void sampleTest() throws Exception
	{
		String privateKey = "Ac03tEam@j!tu_#1";
		String data = "{\"name\" : \"minit\",\r\n"
				+ " \"id\"	: \"tp-05\"\r\n"
				+ "} ";
		
		EncrypAndDecryptUtility ed = new EncrypAndDecryptUtility();
		System.out.println(ed.encrypt(data,privateKey));
		
		System.out.println(ed.decrypt("5u7bQhK/gANkAGslJjGIC2ecPsJ1gR/RMj96bwYagE8glkLQM6oCmNgLAMuAossw",privateKey));
		
		
		
	}

}

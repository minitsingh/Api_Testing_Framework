package practice_serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author MINIT SINGH
 * to achieve Deserialization
 */

public class Run1_DeserialzationTest {
	
	public static void main(String[] args) throws Throwable {
		
	
	FileInputStream input = new FileInputStream("./f.txt");
	ObjectInputStream objIn = new ObjectInputStream(input);
	NFSGame user1Obj = (NFSGame) objIn.readObject();
	
	System.out.println(user1Obj.name);
	System.out.println(user1Obj.level);
	System.out.println(user1Obj.score);
	System.out.println(user1Obj.life);


	
	
	
	}
}

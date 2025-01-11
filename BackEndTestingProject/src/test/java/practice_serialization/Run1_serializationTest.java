package practice_serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * @author MINIT SINGH
 * to achieve serialization
 */


class NFSGame implements Serializable{

	String name;
	int level;
	long score;
	int life;
	
	
	public NFSGame(String name, int level, long score, int life) {
		super();
		this.name = name;
		this.level = level;
		this.score = score;
		this.life = life;
	}
	
	
	
}


public class Run1_serializationTest {
	
	public static void main(String[] args) throws Throwable{
		
		
		NFSGame user1Obj = new NFSGame("deepak", 15, 50000, 2);
		FileOutputStream fileOut = new FileOutputStream("./f.txt");
		ObjectOutputStream objOut =  new  ObjectOutputStream(fileOut);
		
		objOut.writeObject(user1Obj);
		
		System.out.println("=====Completed=====");
		
		
		
		
		
		
	}
	
	

}

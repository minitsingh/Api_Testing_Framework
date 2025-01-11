package practice_serialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Run1_jacksonDeserializationTest {

	public static void main(String[] args) throws Throwable, DatabindException, IOException {
		
		ObjectMapper objM = new ObjectMapper();
		File file = new File("./project.json");
		Project pObj =objM.readValue(file, Project.class);
		System.out.println(pObj.getProjectName());
		System.out.println(pObj.getTeamSize());
		System.out.println(pObj.getStatus());
		System.out.println(pObj.getCreatedBy());
		
		
		
	}
}

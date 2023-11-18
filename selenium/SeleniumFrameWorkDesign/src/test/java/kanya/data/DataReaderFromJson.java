package kanya.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.reporters.Files;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReaderFromJson {

	public static void main(String[] args) throws IOException {
		//read json to String
		String jsonContent = Files.readFile(new File(System.getProperty("user.dir") + "\\src\\test\\java\\kanya\\data\\DataReaderFromJson.java"));
	
		//read String to HashMap, for this Jackson Databin dependency is required
		
		
		
	}
	
	public List<HashMap<String, String>> readDataFromJson(String filePath) throws IOException {
		// read json to String
		String jsonContent = Files.readFile(new File(System.getProperty("user.dir") + "\\src\\test\\java\\kanya\\data\\DataReaderFromJson.java"));

		// read String to HashMap, for this Jackson Databin dependency is required
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
		});

		return data;		
	}
	
}

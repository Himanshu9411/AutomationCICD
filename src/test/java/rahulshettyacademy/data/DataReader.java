package rahulshettyacademy.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.*;

import tools.jackson.databind.ObjectMapper;
import tools.jackson.core.type.TypeReference;

public class DataReader {
	
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
		
		//Read Json to String
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"/src/test/java/rahulshettyacademy/data/PurchseOrder.json"));
		
		//String to HashMap Jackson Databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
	}

}

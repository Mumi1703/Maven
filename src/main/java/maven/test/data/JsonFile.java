package maven.test.data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFile {
public static void main(String[] args) throws IOException {
	FileReader read = new FileReader("C:\\Users\\INN\\SampleWorkspace\\MavenSample\\src\\main\\resources\\TestData\\file.json");
	JSONParser parse = new JSONParser();

	Object object;
	try {
		object = parse.parse(read);
	
		JSONObject jsonobj = (JSONObject) object;
		
		String name = (String)jsonobj.get("Trainer");
		String course = (String)jsonobj.get("Batch");
		System.out.println(name);
		System.out.println(course);
		JSONArray jarr = (JSONArray)jsonobj.get("Students");
		for (Object object2 : jarr) {
			System.out.println(object2);
		}
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}


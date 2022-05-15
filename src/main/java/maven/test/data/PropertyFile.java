package maven.test.data;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {

	public static void readFile() throws IOException {
		FileReader read = new FileReader("C:\\Users\\INN\\SampleWorkspace\\MavenSample\\src\\main\\resources\\TestData\\file.properties");
		
		Properties prop = new Properties();
		prop.load(read);
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		
	}
	
	public static void writeFile() throws IOException {
		FileWriter write = new FileWriter("C:\\Users\\INN\\SampleWorkspace\\MavenSample\\src\\main\\resources\\TestData\\file.properties");
		
		Properties prop = new Properties();
		prop.setProperty("Aiite", "Yuvaraj");
		prop.setProperty("User", "Jalal");
		prop.store(write, "File Write One");
		
	}
	
	public static String readFileReusable(String key) throws IOException {
		FileReader read = new FileReader("C:\\Users\\INN\\SampleWorkspace\\MavenSample\\src\\main\\resources\\TestData\\file.properties");
		
		Properties prop = new Properties();
		prop.load(read);
		prop.get(key);
		return key;	
	}

	public static void main(String[] args) throws IOException {
		readFileReusable("Muthulakshmi");
	}
}

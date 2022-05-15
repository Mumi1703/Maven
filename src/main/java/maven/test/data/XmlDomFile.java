package maven.test.data;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlDomFile {
	public static void xmlread() throws ParserConfigurationException, SAXException, IOException {
		File f = new File("C:\\Users\\INN\\SampleWorkspace\\MavenSample\\src\\main\\resources\\TestData\\file.xml");

		DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder = newInstance.newDocumentBuilder();

		Document doc = builder.parse(f);

		System.out.println(doc.getDocumentElement().getNodeName());
		
		NodeList byTagName = doc.getElementsByTagName("user");
		
		for (int i = 0; i < byTagName.getLength(); i++) {
			
			Node item = byTagName.item(i);
			
			Element ele = (Element)item;
			
		System.out.println("Username " + ele.getElementsByTagName("username").item(0).getTextContent());
		System.out.println("Password " + ele.getElementsByTagName("password").item(0).getTextContent());	
		}	
	}

	}
			

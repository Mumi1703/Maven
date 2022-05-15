package maven.test.data;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class XmlJDomFile {
	public static void xmlReadByJdom() throws JDOMException, IOException {
	File f = new File("C:\\Users\\INN\\SampleWorkspace\\MavenSample\\src\\main\\resources\\TestData\\file.xml");
	
	SAXBuilder builder = new SAXBuilder();
	Document xml = null;
	xml = builder.build(f);
	
	Element root = xml.getRootElement();
	//System.out.println(root);
	String rootValue = root.getName();
	System.out.println(rootValue);
	
	List<Element> children = root.getChildren();
	Iterator<Element> itr = children.iterator();
	
	while(itr.hasNext()) {
		Element data = itr.next();
		System.out.println(data.getName());
		System.out.println(data.getChildText("username"));
		System.out.println(data.getChildText("password"));	
	}
	}
	
	public static void main(String[] args) throws JDOMException, IOException {
		xmlReadByJdom();
		}
	}
	


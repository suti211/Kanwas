package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import user.Mentor;
import user.Student;
import user.User;

public class PersistentStorage {

	private static File xmlFile;
	static private String filePath = "webapps/Kanwas/WEB-INF/classes/io/user-db.xml";
	static PersistentStorage storage;

	private static final int EMAIL = 0;
	private static final int FIRSTNAME = 1;
	private static final int LASTNAME = 2;
	private static final int ROLE = 4;
	private static final int PASSWORD = 3;

	public PersistentStorage() {

	}

	public static PersistentStorage newInstance() {
		if (storage == null) {
			storage = new PersistentStorage();
			
			xmlFile = new File(filePath);
			
			//file creation here
			fileCheck(xmlFile);
		}
		return storage;
	}

	public List<User> loadUsers() throws Exception {
		List<User> users = new ArrayList<>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(xmlFile);
		doc.normalize();

		Element root = doc.getDocumentElement();
		NodeList nodes = root.getElementsByTagName("user");

		for (int i = 0; i < nodes.getLength(); i++) {
			User u = null;

			String firstName = nodes.item(i).getAttributes().item(FIRSTNAME).getTextContent();
			String lastName = nodes.item(i).getAttributes().item(LASTNAME).getTextContent();
			String email = nodes.item(i).getAttributes().item(EMAIL).getTextContent();
			String role = nodes.item(i).getAttributes().item(ROLE).getTextContent();
			String password = nodes.item(i).getAttributes().item(PASSWORD).getTextContent();

			if (role.equals("student")) {
				u = new Student(firstName, lastName, email, role, password, false);
			} else if (role.equals("mentor")) {
				u = new Mentor(firstName, lastName, email, role, password, false);
			}
			System.out.println(u);
			users.add(u);
		}

		return users;
	}

	public void addUser(User user)
			throws SAXException, IOException, ParserConfigurationException, TransformerException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(xmlFile);
		doc.normalize();

		Element root = doc.getDocumentElement();

		Element newUser = doc.createElement("user");
		newUser.setAttribute("first-name", user.getFirstName());
		newUser.setAttribute("last-name", user.getLastName());
		newUser.setAttribute("email", user.getEmailAddress());
		newUser.setAttribute("role", user.getRole());
		newUser.setAttribute("password", user.getPassword());

		root.appendChild(newUser);

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();

		t.setOutputProperty(OutputKeys.INDENT, "yes");
		t.setOutputProperty(OutputKeys.METHOD, "xml");
		t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(xmlFile);
		t.transform(source, result);

	}

	public void modifyUser(User u) throws TransformerException, ParserConfigurationException, SAXException, IOException {
		String fEmail = u.getEmailAddress();

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(xmlFile);
		doc.normalize();

		Element root = doc.getDocumentElement();

		NodeList nodes = root.getElementsByTagName("user");
		Element result = null;
	
		for (int i = 0; i < nodes.getLength(); i++) {
			
			String email = nodes.item(i).getAttributes().item(EMAIL).getTextContent();
			if(fEmail.equals(email)){
				result = (Element) nodes.item(i);
				break;
			}
		}
		
		
		result.setAttribute("first-name", u.getFirstName());
		result.setAttribute("last-name", u.getLastName());
		result.setAttribute("role", u.getRole());
		result.setAttribute("password", u.getPassword());
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();

		t.setOutputProperty(OutputKeys.INDENT, "yes");
		t.setOutputProperty(OutputKeys.METHOD, "xml");
		t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
		DOMSource source = new DOMSource(doc);
		StreamResult res = new StreamResult(xmlFile);
		t.transform(source, res);
		
	}
	
	private static void fileCheck(File file){
		if(!file.exists()){
			try{
				file.createNewFile();
				
				FileWriter fw = new FileWriter(file);
				fw.write("<users>\n</users>");
				fw.close();
				
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}

}

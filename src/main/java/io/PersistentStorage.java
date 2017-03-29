package io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import user.User;

public class PersistentStorage {

	private File xmlFile;
	private String filePath;
	static PersistentStorage storage;

	public PersistentStorage() {

	}

	public PersistentStorage(String filePath) {

	}

	public PersistentStorage newInstance() {
		if (storage == null) {
			storage = new PersistentStorage();
		}
		return storage;
	}

//	public List<User> loadUsers() throws Exception {
//		List<User> users = new ArrayList<>();
//		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//		DocumentBuilder db = dbf.newDocumentBuilder();
//		Document doc = db.parse(xmlFile);
//		doc.normalize();
//		
//		Element root = doc.getDocumentElement();
//		
//	}
	
	public void addUser(User user) throws SAXException, IOException, ParserConfigurationException{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(xmlFile);
		doc.normalize();
		
		Element root = doc.getDocumentElement();
		
		Element newUser = doc.createElement("user");
		
		
//		root.appendChild(newChild)
		
		
	}

}

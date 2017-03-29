package io;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import user.User;

public class PersistentStorage {
	
	private File xmlFile;
	private String filePath;
	static PersistentStorage storage;
	private Document doc;
	
	public PersistentStorage(){
		
	}
	
	public PersistentStorage(String filePath) {
		
	}
	
	public PersistentStorage newInstance(){
		if(storage == null){
			storage = new PersistentStorage();
		}
		return storage;
	}
	
	public List<User> loadUsers(){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
	}

}

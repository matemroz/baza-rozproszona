package pw.bdwsr.rozproszonaprojekt.xmlparser;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import pw.bdwsr.rozproszonaprojekt.xmlparser.User;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Parser {

	Set<User> userSet;
	public Parser(String fileName){
		setCollection(fileName);
    }
	
	public void setCollection(String fileName){
		
	     try {
	            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	            DocumentBuilder db = dbf.newDocumentBuilder();
	            File file = new File(fileName);
	            userSet = new TreeSet<User>();
	            if (file.exists()) {
	            	User newUser;
	                Document doc = db.parse(file);
	                Element docEle = doc.getDocumentElement();
	  
	                NodeList userList = docEle.getElementsByTagName("klient");
	 
	                if (userList != null && userList.getLength() > 0) {
	                    for (int i = 0; i < userList.getLength(); i++) {
	 
	                        Node node = userList.item(i);
	 
	                        if (node.getNodeType() == Node.ELEMENT_NODE) {
	                        	
	                            Element e = (Element) node;
	                            newUser = new User();
	                           
	                            NodeList nodeList = e.getElementsByTagName("imie");
	                            if (nodeList != null)
	                            newUser.setmName(nodeList.item(0).getChildNodes().item(0).getNodeValue());
	                            
	             
	                            nodeList = e.getElementsByTagName("nazwisko");
	                            if (nodeList != null)
	                            newUser.setmLastName(nodeList.item(0).getChildNodes().item(0)
	                                            .getNodeValue());
	                            
	                            
	                            nodeList = e.getElementsByTagName("ulicaZamieszkania");
	                            if (nodeList != null)
	                            newUser.setmStreet(nodeList.item(0).getChildNodes().item(0)
	                                            .getNodeValue());
	                            
	                            
	                            nodeList = e.getElementsByTagName("numerDomu");
	                            if (nodeList != null)
	                            newUser.setmStreetNumber(Integer.parseInt(nodeList.item(0).getChildNodes().item(0)
	                                            .getNodeValue()));
	                            
	                            
	                            nodeList = e.getElementsByTagName("numerMieszkania");
	                            if (nodeList != null)
	                            newUser.setmHomeNumber(Integer.parseInt(nodeList.item(0).getChildNodes().item(0)
	                                            .getNodeValue()));
	                            
	                            
	                            nodeList = e.getElementsByTagName("numerTelefonu");
	                            if (nodeList != null)
	                            newUser.setmPhoneNumber(Integer.parseInt(nodeList.item(0).getChildNodes().item(0)
	                                            .getNodeValue()));
	                            
	                            
	                            nodeList = e.getElementsByTagName("numerDowoduOsobistego");
	                            if (nodeList != null)
	                            newUser.setmIDNumber(nodeList.item(0).getChildNodes().item(0)
	                                            .getNodeValue());
	                            
	                            
	                            nodeList = e.getElementsByTagName("numerPaszportu");
	                            if (nodeList != null)
	                            newUser.setmPassportNumber(Long.parseLong(nodeList.item(0).getChildNodes().item(0)
	                                            .getNodeValue()));
	                             
	                            
	                            nodeList = e.getElementsByTagName("pesel");
	                            if (nodeList != null)
	                                    newUser.setPesel(Long.parseLong(nodeList.item(0).getChildNodes().item(0)
	                                            .getNodeValue()));
	                                    
	                            userSet.add(newUser);
	                        }
	                    }
	                    System.out.println(userSet.size());
	                    
	                    Iterator<User> iter = userSet.iterator();
	                    while(iter.hasNext()){
	                    	
	                    	System.out.println(iter.next().toString());
	                    }
	                    	
	                } else {
	                    System.exit(1);
	                }
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	
	public Set<User> getCollection(){
		return userSet;
	}
	
	public Set<User> getCollection(String fileName){
		setCollection(fileName);
		return userSet;
	}
}

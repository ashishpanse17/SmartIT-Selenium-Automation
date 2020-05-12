package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import testsmartit.SmartITObjectTest_TestNG;

public class PropertiesFile {

	static Properties prop  = new Properties();
	static String ProjectPath  = System.getProperty("user.dir");

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		setProperties();
		getProperties();
		
	}

	public static void getProperties() throws IOException{

		try {
			InputStream   input = new FileInputStream(ProjectPath+"/src/test/java/config/config.properties");
			prop.load(input);
			
			//String browser		= prop.getProperty("browser");
			String protocol     = prop.getProperty("protocol");
			String url          = prop.getProperty("url");
			String username     = prop.getProperty("username");
			String password		= prop.getProperty("password");
			String textSearch   = prop.getProperty("textSearch");
			String Note 		= prop.getProperty("Note");
	/*		
			System.out.println("Browser: "+browser);
			System.out.println("Protocol: "+protocol);
			System.out.println("URL: "+url);
			//System.out.println("Username : "+username);
			//System.out.println("Password : "+password);
			System.out.println("Global Search Text : "+textSearch);
			System.out.println("Add Note  : "+Note);
		*/	
			//SmartITObjectTest_TestNG.browsername = browser;
			SmartITObjectTest_TestNG.protocol= protocol;
		    SmartITObjectTest_TestNG.url=url;
			//SmartITObjectTest_TestNG.username=username;
			//SmartITObjectTest_TestNG.password=password;
			SmartITObjectTest_TestNG.textSearch=textSearch;
			SmartITObjectTest_TestNG.Note=Note;

			
		} catch (FileNotFoundException ex) {
			// TODO Auto-generated catch block
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			ex.printStackTrace();
		}
	}

	public static void setProperties() throws IOException{

		try {
			OutputStream output = new FileOutputStream(ProjectPath+"/src/test/java/config/config.properties");
			//prop.setProperty("browser", "chrome");
			prop.setProperty("protocol", "https");
			prop.setProperty("url", "tenant-smartit.bmc.com");
			//prop.setProperty("username", "05600-Test");
			//prop.setProperty("password", "05600-Test");
			prop.setProperty("textSearch", "BService_00003");
			prop.setProperty("Note", "Automation Any Where");
			
			
			prop.store(output, null);
			
			
		} catch (FileNotFoundException ex) {
			// TODO Auto-generated catch block
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			ex.printStackTrace();
		}

	}
}

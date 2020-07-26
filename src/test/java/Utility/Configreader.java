package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configreader {
	
	Properties pro;
	
	public Configreader() throws IOException {
		
		File src = new File("./Config//config.properties");
		FileInputStream fs = new FileInputStream(src);
		
		pro = new Properties();
		pro.load(fs);
		
	}
	
	public String URL() {
		
		String URL = pro.getProperty("url");
		return URL;
		
		
	}
	public String uname_locator() {
		
		String uname_locator = pro.getProperty("uname_locator");
		return uname_locator;
	}
	
	public String enterusername() {
		
		String username = pro.getProperty("username");
		return username;
		
		
	}
	
	

}

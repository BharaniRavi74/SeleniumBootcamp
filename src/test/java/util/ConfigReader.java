package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop;
	private ConfigReader() {
		
	}

	//public static final String URL="Baseurl";
	/*
	 * public static final String UserName="UserName"; public static final String
	 * UserPassword="UserPassword"; public static final String
	 * ChromePath="ChromeDriverPath";
	 */

		

	private static void load() {
		try(InputStream input = new FileInputStream("C:\\Users\\INSURS1\\eclipse-workspace\\SalesForce\\src\\main\\resources\\TestEnv.properties")) {
			prop = new Properties();
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static String getProperty(String propertyName) {
		if(prop == null) {
			load();
		}
		return prop.getProperty(propertyName);
	}

	public static void reload() {
		load();
		
		
	}

}

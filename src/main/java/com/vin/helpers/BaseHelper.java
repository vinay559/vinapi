package com.vin.helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseHelper {

	public static final String propertiesFileName = "APIConfig.properties";
	public static String BASEURL = "";
	public static Properties properties = new Properties();

	static {
		properties = readProperties(propertiesFileName);
		BASEURL = properties.getProperty("BASEURL");
	}

	public static Properties readProperties(String filename) {

		Properties props = new Properties();
		String rootDir = System.getProperty("user.dir");
		try {
			props.load(new FileInputStream(rootDir + "/resources/" + filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return props;
	}

}

package com.test.selenium.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetPropertyValues {

	private static final Logger LOG = LogManager.getLogger(GetPropertyValues.class);
	InputStream inputStream;
	Properties prop;
	String propFileName;
 
	public GetPropertyValues() throws IOException
	{
		LOG.info("Loading configuration properties...");
		prop = new Properties();
		propFileName = "config.properties";
		
		try {

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
	}
	
	/**
	 * Cette fonction renvoie le type du webdriver à utiliser selon le navigateur
	 * @param navigateur
	 * @return
	 */
	public String getDriverType(String navigateur)
	{
		return prop.getProperty(navigateur+"_driver_type");
	}
	
	/**
	 * Cette fonction renvoie le chemin vers le webdriver à utiliser selon le navigateur
	 * @param navigateur
	 * @return
	 */
	public String getDriverPath(String navigateur)
	{
		return prop.getProperty(navigateur+"_driver_path");
	}
	
	/**
	 * Cette fonction renvoie lurl du site
	 * 
	 * @return
	 */
	public final String getUrlSite()
	{
		return prop.getProperty("urlSite");
	}
	
	
	
	
	
}

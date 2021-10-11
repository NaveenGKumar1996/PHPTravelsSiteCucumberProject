package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropUtils {

	// get props file
	public static File getPropFile(final String FILE_PATH, final String FILE_NAME) {
		// Returns the Properties File
		return new File(FILE_PATH, FILE_NAME);
	}

	// get properties file
	public static Properties getProps(final File file) {
		Properties properties = null;
		try {

			properties = new Properties();
			// Reading the properties file
			properties.load(new FileInputStream(file));
		} catch (FileNotFoundException fileNotFoundException) {
			System.err.println(fileNotFoundException);
		} catch (IOException ioException) {
			System.err.println(ioException);
		}
		return properties;
	}

	// get property value based on its key
	public static String getPropValue(Properties properties, String key) {
		return properties.getProperty(key);
	}

	// create/update props file
	public static void setProps(Properties properties, File fileDirectory, String key, String value) {
		Properties props = new Properties();
		try {
			FileInputStream fis = new FileInputStream(fileDirectory);
			props.load(fis);
			fis.close();

			props.setProperty(key, value);
			FileOutputStream output = new FileOutputStream(fileDirectory);
			props.store(output, "USER DATA");
			output.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	// clear properties obj
	public static void clearProps(Properties properties) {
		properties.clear();
	}

}

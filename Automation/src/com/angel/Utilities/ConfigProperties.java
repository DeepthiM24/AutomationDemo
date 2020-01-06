package com.angel.Utilities;

//import static com.tgr.accelerators.Base.log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.angel.accelerators.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties extends Base {
	private static final Logger log = LogManager.getLogger(ConfigProperties.class.getName());

	public static Properties loadFrom(String propertyFilePath, String propertyFileName) throws MyOwnException {

		// log.info("INTEND TO LOAD USER CONFIGURATION PARAMETERS FROM PROPERTIES
		// FILE");
		try {
			if (notEmpty(propertyFileName)) {
				if (formatGiven(propertyFileName) == true) {
					fileFormat = getFileFormat(propertyFileName);
					if (fileFormatIs(".properties")) {
						file = createFileInstance(propertyFilePath + propertyFileName);
						fs = readFile(file);
						properties = createPropertiesInstance();
						loadProperties(fs);
					} else {
						log.error("FILE FORMAT SEEMS TO BE INCORRECT");
						throwException("FILE FORMAT SEEMS TO BE INCORRECT" + "\n");
					}
				} else {
					log.error("FILE FORMAT IS MISSING");
					throwException("FILE FORMAT IS MISSING" + "\n");
				}
			} else {
				log.error("FILE NAME SEEMS TO BE EMPTY");
				throwException("FILE NAME SEEMS TO BE EMPTY" + "\n");
			}
		} catch (Exception e) {
			log.error("UNABLE TO LOAD USER PROPERTIES FROM THE FILE(" + propertyFileName + ")\n" + e.getMessage());
			throwException(
					"UNABLE TO LOAD USER PROPERTIES FROM THE FILE(" + propertyFileName + ")\n" + e.getMessage() + "\n");
		}
		log.info("SUCCESSFULLY LOADED USER CONFIGURATION PARAMETERS FROM PROPERTY FILE(" + propertyFileName
				+ ") UNDER THE LOCATION(" + propertyFilePath + ")");
		return properties;
	}

	private static Properties createPropertiesInstance() throws MyOwnException {

		log.info("INTEND TO CREATE AN INSTANCE OF PROPERTIES");
		try {
			properties = new Properties();
			log.info("AN INSTANCE OF PROPERTIES CLASS CREATED");
		} catch (Exception e) {
			log.error("UNABLE TO CREATE AN INSTANCE OF PROPERTIES CLASS");
			throwException("UNABLE TO CREATE AN INSTANCE OF PROPERTIES CLASS" + "\n");
		}
		log.info("SUCCESSFULLY CREATED AN INSTANCE OF PROPERTIES");
		return properties;
	}

	private static void loadProperties(FileInputStream fs) throws MyOwnException {

		log.info("INTEND TO LOAD PROPERTIES");
		try {
			properties.load(fs);
			log.info("SUCCESSFULLY LOADED THE PROPERTY FILE");
		} catch (IOException e) {
			log.error("UNABLE TO LOAD THE PROPERTY FILE, PLEASE CHECK NAME OR LOCATION");
			throwException("UNABLE TO LOAD THE PROPERTY FILE, PLEASE CHECK NAME OR LOCATION" + "\n");
		}
		log.info("SUCCESSFULLY LOADED PROPERTIES");
	}
}

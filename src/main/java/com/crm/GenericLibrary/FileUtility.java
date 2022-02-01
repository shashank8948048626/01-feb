package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author shashank
 *
 */

public class FileUtility {
	/**
	 * It is used to read the data from commonData.properties file based on key which you pass as an argument.
	 * @param key
	 * @return 
	 * @return
	 * @throws Throwable 
	 * @throws IOException
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.FilePath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
		
		
	}
	

	
}

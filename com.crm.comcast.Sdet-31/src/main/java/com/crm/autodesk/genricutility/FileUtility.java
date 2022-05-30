package com.crm.autodesk.genricutility;


	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

	/**
	 * 
	 * @author satish
	 *
	 */
	public class FileUtility {
		/**
		 * its used to read the data from commonData.properties File based on Key which you pass as an argument
		 * @param key
		 * @throws Throwable 
		 */
	    public String getPropertyKeyValue(String key) throws Throwable {
	    	 FileInputStream fis1 = new FileInputStream(IPathConstants.PROPERTY_FILE);
	    	 Properties pobj = new Properties();
	    	 pobj.load(fis1);
	    	 String value = pobj.getProperty(key);
			return value;
	    	
	    }
	}




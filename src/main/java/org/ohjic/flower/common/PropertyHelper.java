/*****************************************************************************
 * PROJECT NAME   : 대한적십자사 MICR 연계 시스템
 * SUBSYSTEM NAME : Admin Server
 * FILE NAME      : PropertyHelper.java
 * DESCRIPTION    : property 관련 util class.
 *
 * VERSION NO     author           date        content  -> info
 * ----------------------------------------------------------------------------
      1.0       		  Jinny             2012.09.19      init
 *****************************************************************************/
package org.ohjic.flower.common;

import java.io.FileInputStream;
import java.util.Properties;

public abstract class PropertyHelper {

    // --------------------------------------------------- Property Inner Class
    /**
     * Names of properties used in the configuration file.
     */
    public static class Property {
        /**
         * The name of the configuration file.
         * <pre>
         * system.properties
         * </pre>
         */
        public static final String ConfigFileName = "flower.properties";
    }

    // -------------------------------------------------------------- Variables
    /**
     * The default properties loaded from the configuration file.
     */
    private static Properties prop;

    static {
        getDefault();
    }

    // --------------------------------------------------------- Public Methods
    /**
     * Returns the default configuration file. Changes to the returned
     * properties set will affect all Castor functions relying on the
     * default configuration.
     *
     * @return The default configuration
     */
    public static synchronized Properties getDefault() {
        if (prop == null) {
            load();
        }
        return prop;
    }


    // ------------------------------------------------------ Protected Methods
    /**
     * Called by {@link #getDefault} to load the configuration the
     * first time. Will not complain about inability to load
     * configuration file from one of the default directories, but if
     * it cannot find the JAR's configuration file, will throw a
     * run time exception.
     */
    protected static void load() {
        // get properties at KORC/conf
        prop = new Properties();
        FileInputStream fin = null;

        try {
    		String homePath = System.getProperty("flower.home");
    		//fin = new FileInputStream(homePath+"/conf/"+Property.ConfigFileName);
    		fin = new FileInputStream("D:/javaProject/pilot/src/main/webapp/WEB-INF/conf/flower.properties"); 
    		System.out.println("fin : "+fin);
    		prop.load(fin);        	
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
        	if(fin != null)try{fin.close();}catch(Exception e){ e.printStackTrace();}
        }
    }
    
    public static String getPropertyValue(String key, String defaultValue) {
    	String value = defaultValue;
    	try {
    		load();
    		value = prop.getProperty(key, defaultValue);
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	}
    	return value;
    }
    
    public static void main(String[] args) {
    	load();
    	System.out.println("prop = "+getPropertyValue("system.upload.root", ""));
    }

}
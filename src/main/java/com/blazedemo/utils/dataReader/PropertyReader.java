package com.blazedemo.utils.dataReader;

import com.blazedemo.utils.logs.LogsManager;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Collection;
import java.util.Properties;

public class PropertyReader {
    //load Properties function to load all data exists on properties file into system properties
    public static Properties loadProperties(){
        try {
            Properties properties = new Properties();
            Collection<File> propertyFiles;
            propertyFiles = FileUtils.listFiles(new File("src/main/resources"), new String[]{"properties"}, true);
            propertyFiles.forEach(file -> {
                try {
                    properties.load(FileUtils.openInputStream(file));
                } catch (Exception e) {
                    LogsManager.error("Could not load properties file: ", file.getName(), e.getMessage());
                 }
                properties.putAll(System.getProperties());
                System.getProperties().putAll(properties);
            });
            return properties;
        } catch (Exception e) {
            LogsManager.error("Could not load properties file: ", e.getMessage());
            return null;
        }
    }

    public static String getProperty(String key){
        try {
            return System.getProperty(key);
        } catch (Exception e) {
            LogsManager.error("Error getting property for key: ", key, e.getMessage());
            return "";
        }
    }

}

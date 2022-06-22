package com.cydeo.test.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties = new Properties();
    // having static block because static runs first, because in this class we dont have Main method or TestNg to run the class so we will need a "Static block" (which will run one time when we call the class no matter what )

    // try and catch will handle it but throws will just ignore it so it might be better just to handle it , Remember Saim said if you just throw you need to keep doing that everytime you need
    static {
        FileInputStream file = null;
        try {
            file = new FileInputStream("configuration.properties");
            properties.load(file);
            // file.close();
        } catch (IOException e) {
            System.out.println("Error occurred while reading configuration file");
            e.printStackTrace(); // giving a message here, we have it above
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}

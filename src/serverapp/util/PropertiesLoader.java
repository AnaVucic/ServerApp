/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapp.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Lenovo
 */
public class PropertiesLoader {

    private Properties properties;
    private static PropertiesLoader instance;

    private PropertiesLoader() {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("config/serverconfig.properties"));
            properties.load(new FileInputStream("config/dbconfig.properties"));
            System.out.println("Connected to database.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static PropertiesLoader getInstance() {
        if(instance == null){
            instance = new PropertiesLoader();
        }
        return instance;
    }
    
    public String getProperty (String key){
        return properties.getProperty(key, "");
    }

    public void setProperty (String key, String value){
        properties.setProperty(key, value);
    }
   
}

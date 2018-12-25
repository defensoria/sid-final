/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.comun;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author JMATOS
 */
public class Utilitarios {
    
    public String getProperties(String key){
        String value = null;
        try {
            Properties prop = new Properties();
            String propFileName = "gob/dp/sid/comun/resources/sid.properties";
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if(inputStream != null){
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            value = prop.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
            return value;
    }
    
}

package se.seamless;

import java.io.*;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * Created by kranthikumar on 06/07/17.
 */
public class AppPropertyLoader {
    Properties properties;

    public AppPropertyLoader(){

        properties = new Properties();
        InputStream file= null;
        try {
            String delimiter = File.separator;
            String path = MessageFormat.format("src{0}main{0}resources{0}app.properties", delimiter);
            file = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String giveProperty(String propertyKey){
        return properties.getProperty(propertyKey);
    }
}

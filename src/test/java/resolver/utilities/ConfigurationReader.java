package resolver.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    /**
     *  To open properties file and load it to properties object     *
     */
    private static Properties properties;

    static {

        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            properties = new Properties();
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty (String keyword){

        return properties.getProperty(keyword);
    }
}

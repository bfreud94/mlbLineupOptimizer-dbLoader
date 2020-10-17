package mlbLineupOptimizer.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import mlbLineupOptimizer.constants.Constants;

public class Util {

    public static Map<String, String> combineMaps(Map<String, String> map1, Map<String, String> map2) {
        Map<String, String> map = new HashMap<String, String>(map1);
        map.putAll(map1);
        map.putAll(map2);
        return map;
    }

    public static String getMongoUri() {
        File propertiesFile = new File(Constants.properties);
        if(propertiesFile.exists() && !propertiesFile.isDirectory()) {
            try {
                InputStream inputStream = new FileInputStream(Constants.properties);
                Properties properties = new Properties();
                properties.load(inputStream);
                inputStream.close();
                return properties.getProperty(Constants.mongoUrl);
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else {
            return System.getenv(Constants.mongoUrl);
        }
        return "";
    }
}

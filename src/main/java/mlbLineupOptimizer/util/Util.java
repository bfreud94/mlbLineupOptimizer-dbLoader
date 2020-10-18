package mlbLineupOptimizer.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

import mlbLineupOptimizer.constants.Constants;
import mlbLineupOptimizer.model.Team;

public class Util {

    public static List<Team> combineTeamLists(List<Team> listOne, List<Team> listTwo) {
        List<Team> list = Stream.concat(listOne.stream(), listTwo.stream())
                                .collect(Collectors.toList());
        return list;
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

    public static void dropDatabase(String databaseName) {
        MongoClientURI uri = new MongoClientURI(Util.getMongoUri());
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        database.drop();
        System.out.println("Dropped Database: " + databaseName);
        mongoClient.close();
    }
}

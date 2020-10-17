package mlbLineupOptimizer.service;

import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gargoylesoftware.htmlunit.WebClient;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import mlbLineupOptimizer.constants.Constants;
import mlbLineupOptimizer.model.Batter;
import mlbLineupOptimizer.model.Pitcher;
import mlbLineupOptimizer.util.Util;

public class CronService extends TimerTask {
    
    @Override
    public void run() {
        WebClient webClient = new WebClient();
        Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        Logger.getLogger("com.mongodb").setLevel(Level.OFF);
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setUseInsecureSSL(true);
        try {
            MongoClientURI uri = new MongoClientURI(Util.getMongoUri());
            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase(Constants.mlbv2);
            Map<String, String> teamUrlMap = TeamService.getAllTeamsUrlMap(webClient);
            Gson gson = new Gson();
            populateTeams(webClient, database, teamUrlMap);
            populateBatters(webClient, gson, database, teamUrlMap);
            populatePitchers(webClient, gson, database, teamUrlMap);
            mongoClient.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void populateTeams(WebClient webClient, MongoDatabase database, Map<String, String> teamUrlMap) {
        MongoCollection<Document> collection = database.getCollection(Constants.teams);
        for(String team: teamUrlMap.keySet()) {
            collection.insertOne(new Document(team.equals(Constants.cardinalsInvalid) ? Constants.cardinalsValid : team, teamUrlMap.get(team)));
            System.out.println("Added Team: " + team);
        }
    }

    public static void populateBatters(WebClient webClient, Gson gson, MongoDatabase database, Map<String, String> teamUrlMap) {
        Map<String, List<Batter>> battingMap = TeamService.getTeamBattingRosters(webClient, teamUrlMap);
        MongoCollection<Document> battingCollection = database.getCollection(Constants.batters);
        for(String team: battingMap.keySet()) {
            for(Batter batter: battingMap.get(team)) {
                battingCollection.insertOne(Document.parse(gson.toJson(batter)));
                System.out.println("Added Batter: " + batter.getName());
            }
        }
    }

    public static void populatePitchers(WebClient webClient, Gson gson, MongoDatabase database, Map<String, String> teamUrlMap) {
        Map<String, List<Pitcher>> pitcherMap = TeamService.getTeamPitchingRosters(webClient, teamUrlMap);
        MongoCollection<Document> pitcherCollection = database.getCollection(Constants.pitchers);
        for(String team: pitcherMap.keySet()) {
            for(Pitcher pitcher: pitcherMap.get(team)) {
                pitcherCollection.insertOne(Document.parse(gson.toJson(pitcher)));
                System.out.println("Added Pitcher: " + pitcher.getName());
            }
        }
    }
}

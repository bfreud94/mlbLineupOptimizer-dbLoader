package mlbLineupOptimizer.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import mlbLineupOptimizer.constants.Constants;
import mlbLineupOptimizer.model.Batter;
import mlbLineupOptimizer.model.Pitcher;
import mlbLineupOptimizer.util.Util;

public class TeamService {

    public static Map<String, List<Batter>> getTeamBattingRosters(WebClient client, Map<String, String> teamUrlMap) {
        Map<String, List<Batter>> map = new HashMap<String, List<Batter>>();
        for(String team: teamUrlMap.keySet()) {
            String teamUrl = teamUrlMap.get(team);
            try {
                HtmlPage page = client.getPage(teamUrl);
                DomElement hittingTable = getTable(page, Constants.teamBatting);
                DomNodeList<HtmlElement> tableRows = hittingTable.getElementsByTagName(Constants.tr);
                for(HtmlElement row: tableRows) {
                    if(!row.getFirstChild().asText().equals(Constants.rk)) {
                        Batter batter = BatterService.createBatter(row, team);
                        List<Batter> roster = map.containsKey(team) ? map.get(team) : new ArrayList<Batter>();
                        roster.add(batter);
                        map.put(team, roster);
                    }
                }
            } catch(Exception e) {
                e.printStackTrace();
            }

        }
        return map;
    }

    public static Map<String, List<Pitcher>> getTeamPitchingRosters(WebClient client, Map<String, String> teamUrlMap) {
        Map<String, List<Pitcher>> map = new HashMap<String, List<Pitcher>>();
        for(String team: teamUrlMap.keySet()) {
            String teamUrl = teamUrlMap.get(team);
            try {
                HtmlPage page = client.getPage(teamUrl);
                DomElement hittingTable = getTable(page, Constants.teamPitching);
                DomNodeList<HtmlElement> tableRows = hittingTable.getElementsByTagName(Constants.tr);
                for(HtmlElement row: tableRows) {
                    if(!row.getFirstChild().asText().equals(Constants.rk)) {
                        Pitcher pitcher = PitcherService.createPitcher(row, team);
                        List<Pitcher> roster = map.containsKey(team) ? map.get(team) : new ArrayList<Pitcher>();
                        roster.add(pitcher);
                        map.put(team, roster);
                    }
                }
            } catch(Exception e) {
                e.printStackTrace();
            }

        }
        return map;
    }

    public static Map<String, String> getAllTeamsUrlMap(WebClient client) {
        Map<String, String> americanLeagueUrlMap = getTeamUrlMap(client, Constants.standingsAL);
        Map<String, String> nationalLeagueUrlMap = getTeamUrlMap(client, Constants.standingsNL);
        return Util.combineMaps(americanLeagueUrlMap, nationalLeagueUrlMap);
    }

    public static Map<String, String> getTeamUrlMap(WebClient client, String league) {
        try {
            HtmlPage page = client.getPage(Constants.baseUrl);
            DomElement table = getTable(page, league);
            DomNodeList<HtmlElement> rawTeamElements = table.getElementsByTagName(Constants.a);
            return createTeamUrlMap(rawTeamElements);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DomElement getTable(HtmlPage page, String elementName) {
        DomElement table = page.getElementById(elementName);
        Iterator<DomElement> iterator = table.getChildElements().iterator();
        DomElement element = iterator.next();
        while(iterator.hasNext()) {
            element = iterator.next();
            if(element.getLocalName().equals(Constants.tbody)) {
                return element;
            }
        }
        return null;
    }

    public static Map<String, String> createTeamUrlMap(DomNodeList<HtmlElement> rawTeamElements) {
        Map<String, String> teamUrlMap = new HashMap<String, String>();
        for(HtmlElement element: rawTeamElements) {
            String url = element.getAttribute(Constants.href);
            String teamName = element.getAttribute(Constants.title);
            teamUrlMap.put(teamName, Constants.baseUrl + url);
        }
        return teamUrlMap;
    }
    
}

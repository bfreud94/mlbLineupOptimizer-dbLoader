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
import mlbLineupOptimizer.model.Team;
import mlbLineupOptimizer.util.Util;

public class TeamService {

    public static Map<String, List<Batter>> getTeamBattingRosters(WebClient client, List<Team> teams) {
        Map<String, List<Batter>> map = new HashMap<String, List<Batter>>();
        for(Team team: teams) {
            String teamName = team.getName();
            String teamUrl = team.getUrl();
            try {
                HtmlPage page = client.getPage(teamUrl);
                DomElement hittingTable = getTable(page, Constants.teamBatting);
                DomNodeList<HtmlElement> tableRows = hittingTable.getElementsByTagName(Constants.tr);
                for(HtmlElement row: tableRows) {
                    if(!row.getFirstChild().asText().equals(Constants.rk)) {
                        Batter batter = BatterService.createBatter(row, teamName);
                        List<Batter> roster = map.containsKey(teamName) ? map.get(teamName) : new ArrayList<Batter>();
                        roster.add(batter);
                        map.put(teamName, roster);
                    }
                }
            } catch(Exception e) {
                e.printStackTrace();
            }

        }
        return map;
    }

    public static Map<String, List<Pitcher>> getTeamPitchingRosters(WebClient client, List<Team> teams) {
        Map<String, List<Pitcher>> map = new HashMap<String, List<Pitcher>>();
        for(Team team: teams) {
            String teamName = team.getName();
            String teamUrl = team.getUrl();
            try {
                HtmlPage page = client.getPage(teamUrl);
                DomElement hittingTable = getTable(page, Constants.teamPitching);
                DomNodeList<HtmlElement> tableRows = hittingTable.getElementsByTagName(Constants.tr);
                for(HtmlElement row: tableRows) {
                    if(!row.getFirstChild().asText().equals(Constants.rk)) {
                        Pitcher pitcher = PitcherService.createPitcher(row, teamName);
                        List<Pitcher> roster = map.containsKey(teamName) ? map.get(teamName) : new ArrayList<Pitcher>();
                        roster.add(pitcher);
                        map.put(teamName, roster);
                    }
                }
            } catch(Exception e) {
                e.printStackTrace();
            }

        }
        return map;
    }

    public static List<Team> getAllTeamsUrlMap(WebClient client) {
        List<Team> americanLeagueTeams = getTeamsInLeague(client, Constants.standingsAL);
        List<Team> nationalLeagueTeams = getTeamsInLeague(client, Constants.standingsNL);
        return Util.combineTeamLists(americanLeagueTeams, nationalLeagueTeams);
    }

    public static List<Team> getTeamsInLeague(WebClient client, String league) {
        try {
            HtmlPage page = client.getPage(Constants.baseUrl);
            DomElement table = getTable(page, league);
            DomNodeList<HtmlElement> rawTeamElements = table.getElementsByTagName(Constants.a);
            return createTeamList(rawTeamElements);
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

    public static List<Team> createTeamList(DomNodeList<HtmlElement> rawTeamElements) {
        List<Team> teams = new ArrayList<Team>();
        for(HtmlElement element: rawTeamElements) {
            String url = Constants.baseUrl + element.getAttribute(Constants.href);
            String teamName = element.getAttribute(Constants.title);
            teams.add(new Team(teamName, url));
        }
        return teams;
    }
    
}

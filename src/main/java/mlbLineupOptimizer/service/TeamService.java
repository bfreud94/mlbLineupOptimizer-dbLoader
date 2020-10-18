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

    public static List<Team> getAllTeams(WebClient client) {
        List<Team> americanLeagueTeams = getTeamsInLeague(client, Constants.standingsAL);
        List<Team> nationalLeagueTeams = getTeamsInLeague(client, Constants.standingsNL);
        return Util.combineTeamLists(americanLeagueTeams, nationalLeagueTeams);
    }

    public static List<Team> getTeamsInLeague(WebClient client, String leagueElement) {
        try {
            HtmlPage page = client.getPage(Constants.baseUrl);
            DomElement table = getTable(page, leagueElement);
            DomNodeList<HtmlElement> rawTeamElements = table.getElementsByTagName(Constants.a);
            Map<String, List<String>> teamStandingsMap = getTeamStandingsMap(page, table, leagueElement);
            return createTeamList(client, rawTeamElements, leagueElement, teamStandingsMap);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DomElement getTable(HtmlPage page, String leagueElement) {
        DomElement table = page.getElementById(leagueElement);
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

    public static List<Team> createTeamList(WebClient client, DomNodeList<HtmlElement> rawTeamElements, String leagueElement, Map<String, List<String>> teamStandingsMap) {
        List<Team> teams = new ArrayList<Team>();
        for(HtmlElement element: rawTeamElements) {
            String teamName = element.getAttribute(Constants.title);
            String url = Constants.baseUrl + element.getAttribute(Constants.href);
            teams.add(getTeamData(client, teamName, url, leagueElement, teamStandingsMap));
        }
        return teams;
    }

    public static Team getTeamData(WebClient client, String teamName, String teamUrl, String leagueElement, Map<String, List<String>> teamStandingsMap) {
        try {
            HtmlPage page = client.getPage(teamUrl);
            String league = leagueElement.equals(Constants.standingsAL) ? Constants.americanLeague : Constants.nationalLeague;
            List<String> teamStandingsData = teamStandingsMap.get(teamName);
            List<String> teamHittingStats = getTeamStats(page, Constants.teamBatting);
            List<String> teamPitchingStats = getTeamStats(page, Constants.teamPitching);
            Team team = new Team(teamName, teamUrl, league, teamStandingsData.get(0), teamStandingsData.get(1), teamStandingsData.get(2), teamStandingsData.get(3), teamStandingsData.get(4), teamHittingStats.get(0), teamHittingStats.get(1), teamHittingStats.get(2), teamHittingStats.get(3), teamHittingStats.get(4), teamHittingStats.get(5), teamHittingStats.get(6), teamHittingStats.get(7), teamHittingStats.get(8), teamHittingStats.get(9), teamHittingStats.get(10), teamHittingStats.get(11), teamHittingStats.get(12), teamHittingStats.get(13), teamHittingStats.get(14), teamHittingStats.get(15), teamHittingStats.get(16), teamHittingStats.get(17), teamHittingStats.get(18), teamHittingStats.get(19), teamHittingStats.get(20), teamHittingStats.get(21), teamHittingStats.get(22), teamHittingStats.get(23), teamHittingStats.get(24), teamPitchingStats.get(0), teamPitchingStats.get(1), teamPitchingStats.get(2), teamPitchingStats.get(3), teamPitchingStats.get(4), teamPitchingStats.get(5), teamPitchingStats.get(6), teamPitchingStats.get(7), teamPitchingStats.get(8), teamPitchingStats.get(9), teamPitchingStats.get(10), teamPitchingStats.get(11), teamPitchingStats.get(12), teamPitchingStats.get(13), teamPitchingStats.get(14), teamPitchingStats.get(15), teamPitchingStats.get(16), teamPitchingStats.get(17), teamPitchingStats.get(18), teamPitchingStats.get(19), teamPitchingStats.get(20), teamPitchingStats.get(21), teamPitchingStats.get(22), teamPitchingStats.get(23), teamPitchingStats.get(24), teamPitchingStats.get(25));
            return team;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, List<String>> getTeamStandingsMap(HtmlPage page, DomElement table, String leagueElement) {
        Map<String, List<String>> teamStandingsMap = new HashMap<String, List<String>>();
        DomNodeList<HtmlElement> tableRows = table.getElementsByTagName(Constants.tr);
        for(int i = 0; i < tableRows.size(); i++) {
            HtmlElement row = tableRows.get(i);
            String division = Util.getTeamDivision(leagueElement, i);
            if(row.getAttribute(Constants.classAttribute).equals(Constants.emptyString)) {
                String teamName = row.getElementsByTagName(Constants.a).get(0).getAttribute(Constants.title);
                DomNodeList<HtmlElement> dataCells = row.getElementsByTagName(Constants.td);
                List<String> data = new ArrayList<String>();
                data.add(division);
                for(HtmlElement element: dataCells) {
                    data.add(element.getFirstChild().getNodeValue());
                }
                teamStandingsMap.put(teamName, data);
            }
        }
        return teamStandingsMap;
    }

    public static List<String> getTeamStats(HtmlPage page, String tableIdentifier) {
        DomElement hittingTable = getTable(page, tableIdentifier);
        DomElement footer = hittingTable.getNextElementSibling();
        DomNodeList<HtmlElement> totals = footer.getElementsByTagName(Constants.tr).get(0).getElementsByTagName(Constants.td);
        List<String> teamData = new ArrayList<String>();
        for(HtmlElement total: totals) {
            if(total.getFirstChild() != null) {
                if(tableIdentifier.equals(Constants.teamBatting) || (!total.getAttribute(Constants.dataStat).equals(Constants.wins) && !total.getAttribute(Constants.dataStat).equals(Constants.losses) && !total.getAttribute(Constants.dataStat).equals(Constants.games) && !total.getAttribute(Constants.dataStat).equals(Constants.gamesStarted) && !total.getAttribute(Constants.dataStat).equals(Constants.gamesFinished))) {
                    String data = total.getFirstChild().getNodeValue();
                    if(!data.equals(Constants.teamTotals)) {
                        teamData.add(data);
                    }
                }
            }
        }
        return teamData;
    }
    
}

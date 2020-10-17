package mlbLineupOptimizer.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;

import mlbLineupOptimizer.constants.Constants;
import mlbLineupOptimizer.model.Pitcher;

public class PitcherService {

    public static Pitcher createPitcher(HtmlElement row, String team) {
        List<String> pitcherStats = new ArrayList<String>();
        Iterator<DomElement> iterator = row.getChildElements().iterator();
        DomElement currentRow = iterator.next();
        int columnNumber = 0;
        while(iterator.hasNext()) {
            if(columnNumber != 0) {
                if(columnNumber == 2) {
                    String name = currentRow.asText();
                    name = name.charAt(name.length() - 1) == '*' || name.charAt(name.length() - 1) == '#' || name.charAt(name.length() - 1) == '?' ? name.substring(0, name.length() - 2) : name;
                    String url = currentRow.getFirstChild().getAttributes().getNamedItem(Constants.href).getNodeValue();
                    pitcherStats.add(name);
                    pitcherStats.add(url);
                } else {
                    pitcherStats.add(currentRow.asText());
                }
            }
            columnNumber++;
            currentRow = iterator.next();
        }
        pitcherStats.add(currentRow.asText());
        pitcherStats.add(team);
        return new Pitcher(pitcherStats.get(0), pitcherStats.get(1), pitcherStats.get(2), pitcherStats.get(3), pitcherStats.get(4), pitcherStats.get(5), pitcherStats.get(6), pitcherStats.get(7), pitcherStats.get(8), pitcherStats.get(9), pitcherStats.get(10), pitcherStats.get(11), pitcherStats.get(12), pitcherStats.get(13), pitcherStats.get(14), pitcherStats.get(15), pitcherStats.get(16), pitcherStats.get(17), pitcherStats.get(18), pitcherStats.get(19), pitcherStats.get(20), pitcherStats.get(21), pitcherStats.get(22), pitcherStats.get(23), pitcherStats.get(24), pitcherStats.get(25), pitcherStats.get(26), pitcherStats.get(27), pitcherStats.get(28), pitcherStats.get(29), pitcherStats.get(30), pitcherStats.get(31), pitcherStats.get(32), pitcherStats.get(33), pitcherStats.get(34));
    }
}

package mlbLineupOptimizer.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;

import mlbLineupOptimizer.constants.Constants;
import mlbLineupOptimizer.model.Batter;

public class BatterService {

    public static Batter createBatter(HtmlElement row, String team) {
        List<String> batterStats = new ArrayList<String>();
        Iterator<DomElement> iterator = row.getChildElements().iterator();
        DomElement currentRow = iterator.next();
        int columnNumber = 0;
        while(iterator.hasNext()) {
            if(columnNumber != 0) {
                if(columnNumber == 2) {
                    String name = currentRow.asText();
                    name = name.charAt(name.length() - 1) == '*' || name.charAt(name.length() - 1) == '#' || name.charAt(name.length() - 1) == '?' ? name.substring(0, name.length() - 2) : name;
                    String url = currentRow.getFirstChild().getAttributes().getNamedItem(Constants.href).getNodeValue();
                    batterStats.add(name);
                    batterStats.add(url);
                } else {
                    batterStats.add(currentRow.asText());
                }
            }
            columnNumber++;
            currentRow = iterator.next();
        }
        batterStats.add(currentRow.asText());
        batterStats.add(team);
        return new Batter(batterStats.get(0), batterStats.get(1), batterStats.get(2), batterStats.get(3), batterStats.get(4), batterStats.get(5), batterStats.get(6), batterStats.get(7), batterStats.get(8), batterStats.get(9), batterStats.get(10), batterStats.get(11), batterStats.get(12), batterStats.get(13), batterStats.get(14), batterStats.get(15), batterStats.get(16), batterStats.get(17), batterStats.get(18), batterStats.get(19), batterStats.get(20), batterStats.get(21), batterStats.get(22), batterStats.get(23), batterStats.get(24), batterStats.get(25), batterStats.get(26), batterStats.get(27), batterStats.get(28));
    }
}

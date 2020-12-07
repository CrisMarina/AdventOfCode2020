package Day7;

import Utils.AdventUtils;
import javafx.util.Pair;

import java.util.*;

public class AdventDay7Problem2 {
    private static final Map<String, List<Pair<Integer, String>>> bags = new HashMap<>();

    private static Integer numberOfBags() {
        List<String> values = AdventUtils.readFromFileToList("src/main/resources/AdventDay7Problem1Input");

        for (String value : values) {
            String[] contains = value.split("contain");
            String color = contains[0].trim().substring(0, contains[0].trim().lastIndexOf(" "));
            String[] insideBags = contains[1].split(",");
            List<Pair<Integer, String>> colors = new ArrayList<>();
            for (String s : insideBags) {
                int nb = 0;
                String bagCol;
                try {
                    nb = Integer.parseInt(s.trim().substring(0, 1));
                    bagCol = s.trim().substring(2, s.trim().lastIndexOf(" "));
                } catch (NumberFormatException numberFormatException) {
                    bagCol = s.trim().substring(0, s.trim().lastIndexOf(" "));
                }

                Pair<Integer, String> pair = new Pair<>(nb, bagCol);
                colors.add(pair);
            }
            bags.put(color, colors);
        }
        String col = "shiny gold";
        Integer rez;
        Integer sum = 0;
        rez = computeResult(sum, col);
        return rez;
    }

    private static Integer computeResult(Integer sum, String col) {
        List<Pair<Integer, String>> pairs = bags.get(col);
        for (Pair<Integer, String> p : pairs) {
            Integer key = p.getKey();
            String value = p.getValue();
            if (value.contains("no other")) {
                return 0;
            }
            sum = sum + key + key * computeResult(0, value);
        }
        return sum;
    }
}

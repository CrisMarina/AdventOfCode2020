package Day7;

import Utils.AdventUtils;

import java.util.*;

public class AdventDay7Problem1 {

    private static int numberOfBags() {
        List<String> values = AdventUtils.readFromFileToList("src/main/resources/AdventDay7Problem1Input");
        Set<String> results = new HashSet<>();
        List<String> colors = new ArrayList<>();
        colors.add("shiny gold");
        while (!colors.isEmpty()) {
            String currentCol = colors.get(0);
            results.add(colors.get(0));
            for (String s : values) {
                String[] split = s.split("contain");
                if (split[1].contains(currentCol)) {
                    colors.add(split[0].trim().substring(0, split[0].trim().lastIndexOf(" ")));
                }
            }
            colors.remove(currentCol);
        }

        //we need to remove the shiny gold
        return results.size() - 1;
    }
}

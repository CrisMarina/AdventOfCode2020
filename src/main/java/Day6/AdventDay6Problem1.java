package Day6;

import Utils.AdventUtils;

import java.util.*;

public class AdventDay6Problem1 {

    private static int sumOfAnswers() {
        List<String> values = AdventUtils.readFromFileToList("src/main/resources/AdventDay6Problem1Input");
        int count = 0;
        for (int i = 0; i < values.size(); i++) {
            Set<String> letters = new HashSet<>();
            while (i < values.size() && !"".equals(values.get(i))) {
                String[] rowValues = values.get(i).split("");
                letters.addAll(Arrays.asList(rowValues));
                i++;
            }
            count = count + letters.size();
        }
        return count;
    }
}

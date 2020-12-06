package Day6;

import Utils.AdventUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdventDay6Problem2 {

    private static int sumOfAnswers() {
        List<String> values = AdventUtils.readFromFileToList("src/main/resources/AdventDay6Problem1Input");
        int count = 0;
        for (int i = 0; i < values.size(); i++) {
            List<String> collect = new ArrayList<>(Arrays.asList("abcdefghijklmnopqrstuvwxyz".split("")));
            while (i < values.size() && !"".equals(values.get(i))) {
                String[] rowValues = values.get(i).split("");
                collect.retainAll(Arrays.asList(rowValues));
                i++;
            }
            count = count + collect.size();
        }
        return count;
    }
}

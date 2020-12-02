package Day1;

import Utils.AdventUtils;

import java.util.List;

public class AdventDay1Problem1 {

    private static int computeProduct() {
        List<String> values = AdventUtils.readFromFileToList("src/main/resources/AdventDay1Problem1Input");
        for (String s : values) {
            int first = Integer.parseInt(s);
            int second = 2020 - first;
            if (values.contains(Integer.toString(second))) {
                return first*second;
            }
        }
        return -1;
    }
}

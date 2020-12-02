package Day1;

import Utils.AdventUtils;

import java.util.List;

public class AdventDay1Problem2 {

    private static int computeProduct() {
        List<String> values = AdventUtils.readFromFileToList("src/main/resources/AdventDay1Problem1Input");
        for (String s : values) {
            int first = Integer.parseInt(s);
            int tempSum = 2020 - first;
            for (String s2 : values) {
                int third = Integer.parseInt(s2);
                int fourth = tempSum - third;
                if (values.contains(Integer.toString(fourth))) {
                    return first*third*fourth;
                }
            }
        }
        return -1;
    }
}

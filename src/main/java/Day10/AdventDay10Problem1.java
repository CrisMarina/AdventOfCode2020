package Day10;

import Utils.AdventUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdventDay10Problem1 {

    private static int jolts() {
        List<Integer> values = AdventUtils.readFromFileToIntegerList("src/main/resources/AdventDay10Problem1Input");
        Collections.sort(values);
        List<Integer> result = new ArrayList<>();
        int current = 0;
        for (Integer value : values) {
            if (value - current <= 3) {
                result.add(value);
                current = value;
            }
        }
        int oneDiff = 0;
        int threeDiff = 0;
        current = 0;
        result.add(result.get(result.size() - 1) + 3);
        for (Integer value : result) {
            if (value - current == 1) {
                oneDiff++;
            } else if (value - current == 3) {
                threeDiff++;
            }
            current = value;
        }
        return oneDiff * threeDiff;
    }
}

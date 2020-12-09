package Day9;

import Utils.AdventUtils;

import java.math.BigInteger;
import java.util.List;

public class AdventDay9Problem1 {

    private static BigInteger preamble() {
        List<String> values = AdventUtils.readFromFileToList("src/main/resources/AdventDay9Problem1Input");
        int step = 25;
        for (int i = step; i < values.size(); i++) {
            BigInteger currentNumber = BigInteger.valueOf(Long.parseLong(values.get(i)));
            List<String> subValues = values.subList(i - step, i);
            boolean found = false;
            for (int j = 0; j < subValues.size() && !found; j++) {
                BigInteger first = BigInteger.valueOf(Long.parseLong(subValues.get(j)));
                BigInteger temp = currentNumber.subtract(first);
                if (!temp.equals(first)) {
                    if (subValues.contains(String.valueOf(temp))) {
                        found = true;
                    }
                }
            }
            if (!found) {
                return currentNumber;
            }
        }
        return BigInteger.ZERO;
    }
}

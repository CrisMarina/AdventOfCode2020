package Day9;

import Utils.AdventUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdventDay9Problem2 {
    private static final List<String> values = AdventUtils.readFromFileToList("src/main/resources/AdventDay9Problem1Input");

    private static BigInteger findWeakness(BigInteger preamble) {
        for (int i = 0; i < values.size(); i++) {
            BigInteger sum = BigInteger.ZERO;
            List<BigInteger> contiguous = new ArrayList<>();
            for (int j = i; j < values.size(); j++) {
                BigInteger current = BigInteger.valueOf(Long.parseLong(values.get(j)));
                contiguous.add(current);
                sum = sum.add(current);
                if (sum.equals(preamble)) {
                    Collections.sort(contiguous);
                    return contiguous.get(0).add(contiguous.get(contiguous.size() - 1));
                } else if (sum.compareTo(preamble) > 0) {
                    break;
                }
            }
        }
        return BigInteger.ZERO;
    }

    private static BigInteger preamble() {

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

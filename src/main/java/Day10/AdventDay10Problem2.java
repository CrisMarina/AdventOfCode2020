package Day10;

import Utils.AdventUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AdventDay10Problem2 {

    private static BigInteger jolts() {
        List<Integer> values = AdventUtils.readFromFileToIntegerList("src/main/resources/AdventDay10Problem1Input");
        Collections.sort(values);
        values.add(0, 0);

        values.add(values.get(values.size() - 1) + 3);

        BigInteger[] dp = new BigInteger[values.size()];
        Arrays.fill(dp, BigInteger.ZERO);

        return recurse(values, 0, dp);

    }

    private static BigInteger recurse(List<Integer> values, int n, BigInteger[] dp) {
        if (n == dp.length - 1) {
            return BigInteger.ONE;
        }
        if (!dp[n].equals(BigInteger.ZERO)) {
            return dp[n];
        }
        BigInteger answer = BigInteger.ZERO;
        for (int j = n + 1; j < values.size(); j++) {
            if (values.get(j) - values.get(n) <= 3) {
                answer = answer.add(recurse(values, j, dp));
            }
        }
        dp[n] = answer;
        return answer;
    }
}

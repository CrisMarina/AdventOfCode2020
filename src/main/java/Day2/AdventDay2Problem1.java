package Day2;

import Utils.AdventUtils;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class AdventDay2Problem1 {

    private static int computeNumberOfRightPasswords() {
        List<String> values = AdventUtils.readFromFileToList("src/main/resources/AdventDay2Problem1Input");
        int count = 0;
        for (String s : values) {
            // s = 9-10 b: bbktbbbxhfbpb
            // split = 9-10 b, bbktbbbxhfbpb
            String[] split = s.split(":");
            // rule = 9-10 b
            String rule = split[0];
            // rules = 9-10, b
            String[] rules = rule.split(" ");
            // letter = b
            String letter = rules[1];
            // minMax = 9, 10
            String[] minMax = rules[0].split("-");
            // minTimes = 9
            int minTimes = Integer.parseInt(minMax[0]);
            // maxTimes = 10
            int maxTimes = Integer.parseInt(minMax[1]);

            //pass = bbktbbbxhfbpb
            String pass = split[1];

            int letterCount = StringUtils.countMatches(pass, letter);

            if (minTimes <= letterCount && letterCount <= maxTimes) {
                count++;
            }
        }
        return count;
    }
}

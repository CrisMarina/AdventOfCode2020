package Day2;

import Utils.AdventUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class AdventDay2Problem2 {

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
            // firstPos = 9
            int firstPos = Integer.parseInt(minMax[0]);
            // lastPos = 10
            int secondPos = Integer.parseInt(minMax[1]);

            //pass = bbktbbbxhfbpb
            String pass = split[1].trim();

            char c1 = pass.charAt(firstPos - 1);
            char c2 = pass.charAt(secondPos - 1);

            int check = 0;

            if (letter.charAt(0) == c1) {
                check++;
            }

            if (letter.charAt(0) == c2) {
                check++;
            }

            if (check == 1) {
                count++;
            }
        }
        return count;
    }
}

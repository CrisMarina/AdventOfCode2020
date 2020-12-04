package Day4;

import Utils.AdventUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class AdventDay4Problem1 {
    private static final List<String> mandatoryFields = Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");

    private static int computeNumberOfRightPasswords() {
        List<String> values = AdventUtils.readFromFileToList("src/main/resources/AdventDay4Problem1Input");
        int count = 0;
        for (int i = 0; i < values.size(); i++) {
            Map<String, String> passport = new HashMap<>();

            while (i < values.size() && !"".equals(values.get(i))) {
                String[] rowValues = values.get(i).split(" ");
                for (String s1 : rowValues) {
                    String[] keyValue = s1.split(":");
                    passport.put(keyValue[0], keyValue[1]);
                }
                i++;
            }
            count = verifyPassport(passport) ? count + 1 : count;
        }
        return count;
    }

    private static boolean verifyPassport(Map<String, String> passport) {
        for (String s : mandatoryFields) {
            if (!passport.containsKey(s)) {
                return false;
            }
        }
        return true;
    }
}

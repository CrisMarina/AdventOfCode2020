package Day4;

import Utils.AdventUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class AdventDay4Problem2 {
    private static final List<String> mandatoryFields = Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");
    private static final List<String> eyeColours = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");

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
        for (Map.Entry<String, String> entry : passport.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            switch (key) {
                case "byr":
                    int i = Integer.parseInt(value);
                    if (i < 1920 || i > 2002) {
                        return false;
                    }
                    break;
                case "iyr":
                    i = Integer.parseInt(value);
                    if (i < 2010 || i > 2020) {
                        return false;
                    }
                    break;
                case "eyr":
                    i = Integer.parseInt(value);
                    if (i < 2020 || i > 2030) {
                        return false;
                    }
                    break;
                case "hgt":
                    if (!value.endsWith("in") && !value.endsWith("cm")) {
                        return false;
                    }
                    int h = Integer.parseInt(value.substring(0, value.length() - 2));
                    String um = value.substring(value.length() - 2);
                    switch (um) {
                        case "in":
                            if (h < 59 || h > 76) {
                                return false;
                            }
                            break;
                        case "cm":
                            if (h < 150 || h > 193) {
                                return false;
                            }
                            break;
                    }
                    break;
                case "hcl":
                    if (!value.startsWith("#")) {
                        return false;
                    }
                    String col = value.substring(1);
                    boolean matches = Pattern.matches("^[a-f0-9]{6}$", col);
                    if (!matches) {
                        return false;
                    }
                    break;
                case "ecl":
                    if (!eyeColours.contains(value)) {
                        return false;
                    }
                    break;
                case "pid":
                    if (value.length() != 9) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}

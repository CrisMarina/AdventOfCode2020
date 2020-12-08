package Day8;

import Utils.AdventUtils;

import java.util.List;

public class AdventDay8Problem2 {

    private static int accumulator() {
        List<String> values = AdventUtils.readFromFileToList("src/main/resources/AdventDay8Problem1Input");
        for (int j = 0; j < values.size(); j++) {
            String value1 = values.get(j);
            String[] s1 = value1.split(" ");
            String instr1 = s1[0].trim();
            int step1 = Integer.parseInt(s1[1].trim());

            if ("nop".equals(instr1)) {
                value1 = "jmp " + step1;
                values.set(j, value1);
            }

            if ("jmp".equals(instr1)) {
                value1 = "nop " + step1;
                values.set(j, value1);
            }

            int[] visited = new int[values.size()];
            int accumulator = 0;
            boolean found = false;
            int i = 0;
            visited[0] = 1;
            while (!found) {
                String value = values.get(i);
                String[] s = value.split(" ");
                String instr = s[0].trim();
                int step = Integer.parseInt(s[1].trim());
                switch (instr) {
                    case "nop":
                        i++;
                        break;
                    case "acc":
                        i++;
                        accumulator += step;
                        break;
                    case "jmp":
                        i = i + step;
                        break;
                }
                if (i < visited.length && visited[i] != 0) {
                    found = true;
                }
                if (i < visited.length) {
                    visited[i] = 1;
                }
                if (i == values.size()) {
                    return accumulator;
                }
            }

            value1 = values.get(j);
            s1 = value1.split(" ");
            instr1 = s1[0].trim();
            step1 = Integer.parseInt(s1[1].trim());

            if ("nop".equals(instr1)) {
                value1 = "jmp " + step1;
                values.set(j, value1);
            }

            if ("jmp".equals(instr1)) {
                value1 = "nop " + step1;
                values.set(j, value1);
            }
        }
        return 0;
    }
}

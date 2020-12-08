package Day8;

import Utils.AdventUtils;

import java.util.List;

public class AdventDay8Problem1 {

    private static int accumulator() {
        List<String> values = AdventUtils.readFromFileToList("src/main/resources/AdventDay8Problem1Input");
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
            if (visited[i] != 0) {
                found = true;
            }
            visited[i] = 1;
        }
        return accumulator;
    }
}

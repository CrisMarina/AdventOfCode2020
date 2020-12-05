package Day5;

import Utils.AdventUtils;

import java.util.List;

public class AdventDay5Problem1 {

    private static long computeHighestId() {
        List<String> values = AdventUtils.readFromFileToList("src/main/resources/AdventDay5Problem1Input");
        long rez = 0;

        for (String s : values) {
            int low = 0;
            int top = 127;
            int left = 0;
            int right = 7;
            String[] split = s.split("");
            int row = 0;
            for (int i = 0; i < 6; i++) {
                if (split[i].equals("F")) {
                    top = (low + top) / 2;
                } else if (split[i].equals("B")) {
                    low = (low + top) % 2 == 0 ? (low + top) / 2 : (low + top) / 2 + 1;
                }
            }
            //for i = 5 - the last number for the rows
            if (split[6].equals("F")) {
                row = low;
            } else if (split[5].equals("B")) {
                row = top;
            }
            int col = 0;
            for (int i = 7; i < 9; i++) {
                if (split[i].equals("R")) {
                    left = (left + right) % 2 == 0 ? (left + right) / 2 : (left + right) / 2 + 1;
                } else if (split[i].equals("L")) {
                    right = (left + right) / 2;;
                }
            }
            if (split[9].equals("L")) {
                col = left;
            } else if (split[9].equals("R")) {
                col = right;
            }
            long id = row * 8 + col;
            if (id > rez) {
                rez = id;
            }
        }
        return rez;
    }
}

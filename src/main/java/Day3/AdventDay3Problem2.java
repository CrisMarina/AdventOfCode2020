package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AdventDay3Problem2 {

    private static long computeNumberOfTrees() {
        // R1, D1
        int position1 = 1;
        long trees1 = 0;
        // R3, D1
        int position2 = 3;
        long trees2 = 0;
        // R5, D1
        int position3 = 5;
        long trees3 = 0;
        // R7, D1
        int position4 = 7;
        long trees4 = 0;
        // R1, D2
        int position5 = 1;
        long trees5 = 0;
        int currentLine = 0;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "src/main/resources/AdventDay3Problem1Input"));
            String line = reader.readLine();
            while (line != null) {
                currentLine++;
                // read next line
                line = reader.readLine();
                if (line != null) {
                    int lineLength = line.length();

                    // R1, D1
                    char c = line.charAt(position1 % lineLength);
                    if ('#' == c) {
                        trees1++;
                    }
                    position1 += 1;

                    // R3, D1
                    c = line.charAt(position2 % lineLength);
                    if ('#' == c) {
                        trees2++;
                    }
                    position2 += 3;

                    // R5, D1
                    c = line.charAt(position3 % lineLength);
                    if ('#' == c) {
                        trees3++;
                    }
                    position3 += 5;

                    // R7, D1
                    c = line.charAt(position4 % lineLength);
                    if ('#' == c) {
                        trees4++;
                    }
                    position4 += 7;

                    // R1, D2
                    if (currentLine % 2 == 0) {
                        c = line.charAt(position5 % lineLength);
                        if ('#' == c) {
                            trees5++;
                        }
                        position5 += 1;
                    }

                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return trees1 * trees2 * trees3 * trees4 * trees5;
    }
}

package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AdventDay3Problem1 {

    private static int computeNumberOfTrees() {
        int position = 3;
        int trees = 0;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "src/main/resources/AdventDay3Problem1Input"));
            String line = reader.readLine();
            while (line != null) {
                // read next line
                line = reader.readLine();
                if (line != null) {
                    int lineLength = line.length();
                    char c = line.charAt(position % lineLength);
                    if ('#' == c) {
                        trees++;
                    }
                    position += 3;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return trees;
    }
}

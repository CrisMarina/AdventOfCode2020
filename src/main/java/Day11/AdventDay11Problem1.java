package Day11;

import Utils.AdventUtils;

import java.util.List;

public class AdventDay11Problem1 {

    public static int count() {

        char[][] jolts = jolts();
        int count = 0;
        for (int i = 0; i < jolts.length; i++) {
            for (int j = 0; j < jolts[0].length; j++) {
                if (jolts[i][j] == '#') {
                    count++;
                }
            }
        }
        return count;
    }

    private static char[][] jolts() {
        List<String> values = AdventUtils.readFromFileToList("src/main/resources/AdventDay11Problem1Input");
        int length = values.get(0).length();
        char[][] matrix = new char[values.size()][length];
        for (int i = 0; i < values.size(); i++) {
            String s = values.get(i);
            for (int j = 0; j < s.length(); j++) {
                matrix[i][j] = s.charAt(j);
            }
        }
        while (true) {
            char[][] newMatrix = new char[values.size()][length];
            boolean changed = false;
            for (int i = 0; i < values.size(); i++) {
                for (int j = 0; j < length; j++) {
                    int count = 0;
                    if ('L' == matrix[i][j]) {
                        if (i >= 1) {
                            if (j >= 1 && matrix[i - 1][j - 1] != '#') {
                                count++;
                            }
                            if (matrix[i - 1][j] != '#') {
                                count++;
                            }
                            if (j < length - 1 && matrix[i - 1][j + 1] != '#') {
                                count++;
                            }
                        }

                        if (j >= 1 && matrix[i][j - 1] != '#') {
                            count++;
                        }
                        if (j < length - 1 && matrix[i][j + 1] != '#') {
                            count++;
                        }
                        if (i < values.size() - 1) {
                            if (j >= 1 && matrix[i + 1][j - 1] != '#') {
                                count++;
                            }
                            if (matrix[i + 1][j] != '#') {
                                count++;
                            }
                            if (j < length - 1 && matrix[i + 1][j + 1] != '#') {
                                count++;
                            }
                        }
                        if (i == 0 || i == values.size() - 1) {
                            if (j == 0 && count == 3) {
                                newMatrix[i][j] = '#';
                                changed = true;
                            } else if (j == length - 1 && count == 3) {
                                newMatrix[i][j] = '#';
                                changed = true;
                            } else if (count == 5) {
                                newMatrix[i][j] = '#';
                                changed = true;
                            } else {
                                newMatrix[i][j] = 'L';
                            }
                        } else if (j == 0 || j == length - 1) {
                            if (count == 5) {
                                newMatrix[i][j] = '#';
                                changed = true;
                            } else {
                                newMatrix[i][j] = 'L';
                            }
                        } else if (count == 8) {
                            newMatrix[i][j] = '#';
                            changed = true;
                        } else {
                            newMatrix[i][j] = 'L';
                        }
                    } else {
                        newMatrix[i][j] = matrix[i][j];
                    }
                }
            }

            if (!changed) {
                return matrix;
            }

            changed = false;
            matrix = new char[values.size()][length];

            for (int i = 0; i < values.size(); i++) {
                for (int j = 0; j < length; j++) {
                    int count = 0;
                    if ('#' == newMatrix[i][j]) {
                        if (i >= 1) {
                            if (j >= 1 && newMatrix[i - 1][j - 1] == '#') {
                                count++;
                            }
                            if (newMatrix[i - 1][j] == '#') {
                                count++;
                            }
                            if (j < length - 1 && newMatrix[i - 1][j + 1] == '#') {
                                count++;
                            }
                        }

                        if (j >= 1 && newMatrix[i][j - 1] == '#') {
                            count++;
                        }
                        if (j < length - 1 && newMatrix[i][j + 1] == '#') {
                            count++;
                        }
                        if (i < values.size() - 1) {
                            if (j >= 1 && newMatrix[i + 1][j - 1] == '#') {
                                count++;
                            }
                            if (newMatrix[i + 1][j] == '#') {
                                count++;
                            }
                            if (j < length - 1 && newMatrix[i + 1][j + 1] == '#') {
                                count++;
                            }
                        }
                        if (i == 0 || i == values.size() - 1) {
                            if (count >= 4) {
                                matrix[i][j] = 'L';
                                changed = true;
                            } else {
                                matrix[i][j] = '#';
                            }
                        } else if (j == 0 || j == length - 1) {
                            if (count >= 4) {
                                matrix[i][j] = 'L';
                                changed = true;
                            } else {
                                matrix[i][j] = '#';
                            }
                        } else if (count >= 4) {
                            matrix[i][j] = 'L';
                            changed = true;
                        } else {
                            matrix[i][j] = '#';
                        }
                    } else {
                        matrix[i][j] = newMatrix[i][j];
                    }
                }
            }
            if (!changed) {
                return newMatrix;
            }
        }

    }

}

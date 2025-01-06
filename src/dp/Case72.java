package dp;

import java.util.Arrays;

public class Case72 {

    public int minDistance(String word1, String word2) {
        return helper(word1, word2, word1.length() - 1, word2.length() - 1);
    }

    private int helper(String word1, String word2, int i, int j) {

        if (i == -1) return j + 1;
        if (j == -1) return i + 1;

        if (word1.charAt(i) == word2.charAt(j)) {
            return helper(word1, word2, i - 1, j - 1);
        } else {
            return getMin(helper(word1, word2, i - 1, j) + 1,
                    helper(word1, word2, i, j - 1) + 1,
                    helper(word1, word2, i - 1, j - 1) + 1);
        }
    }

    private int getMin(int a, int b, int c) {
        int[] arr = new int[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        Arrays.sort(arr);
        return arr[0];
    }
}

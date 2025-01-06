package dp;

import java.util.Arrays;

/**
 * word1编辑成word2，也就是word1可变，word2不变
 * <p>
 * i遍历 word1，j遍历word2
 * <p>
 * 对于 word1.charAt(i) 和 word2.charAt(j)，
 * 相等：则什么也不做，继续遍历
 * 不等：需要取上一次最少次数变化的结果+1，即为当期值
 * <p>
 * 针对当前 word1.charAt(i)，有3个选择，【删除、插入、替换】一个字符，分别对应：
 * [i-1,j](i删除，所以i前移，j不动)
 * [i,j-1](i插入，所以i不动，j前移)
 * [i-1,j-1](i替换，就是用word2.charAt(j)替换word1.charAt(i)，替换后，i和j均前移)
 */
public class Case72 {


    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] memo = new int[m][n];
        return helper2(word1, word2, m - 1, n - 1, memo);
    }

    private int helper2(String word1, String word2, int i, int j, int[][] memo) {

        if (i == -1) return j + 1;
        if (j == -1) return i + 1;

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = helper2(word1, word2, i - 1, j - 1, memo);
        } else {
            memo[i][j] = getMin(
                    helper2(word1, word2, i - 1, j, memo) + 1,
                    helper2(word1, word2, i, j - 1, memo) + 1,
                    helper2(word1, word2, i - 1, j - 1, memo) + 1);
        }
        return memo[i][j];
    }

    public int minDistance1(String word1, String word2) {
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

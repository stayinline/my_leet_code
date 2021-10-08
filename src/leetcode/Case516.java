package leetcode;

import java.util.Arrays;

public class Case516 {


    public static int longestPalindromeSubseq(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }

        int n = s.length();
        //dp[i][j]记录的是s[i]和s[j]之间的字符串的最长回文子序列的长度
        int[][] dp = new int[n][n];
        //base case: 只有一个字符的时候,也就是i==j，此时显然dp[i][j]==dp[i][i]==1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        /* 状态转移方程：
         * if (s[i] == s[j])
         *     // 它俩一定在最长回文子序列中
         *     dp[i][j] = dp[i + 1][j - 1] + 2;
         * else
         *     // s[i+1..j] 和 s[i..j-1] 谁的回文子序列更长？
         *     dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
         */

        /*
         * i>j是不存在的情况，所以不需要处理，然后根据状态转移方程，显然dp数组需要斜着遍历或者反着遍历
         */

        // 反着遍历保证正确的状态转移
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 状态转移方程
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        // 整个 s 的最长回文子串长度
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        longestPalindromeSubseq(s);
    }
}

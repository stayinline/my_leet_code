package leetcode;

public class Case121 {

    public static int maxProfit(int[] prices) {
        int n = prices.length;

        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_0 - prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
            //持股的收益
            //   dp[i][1]
            // = max(dp[-1][1], dp[-1][0] - prices[i])
            // = max(Integer.MIN_VALUE, 0 - prices[i])
            // = -prices[i]
        }
        return dp_i_0;
    }
}

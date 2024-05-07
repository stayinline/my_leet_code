package dp;

public class Case121 {


    public static int maxProfit(int[] prices) {
        // base case: dp[-1][0] = 0, dp[-1][1] = -infinity
        int dp_i_0 = 0;//第i天不持股的收益
        int dp_i_1 = Integer.MIN_VALUE; //第i天持股的收益
        for (int price : prices) {
            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price); //不持股的收益，取二者较大值
            // dp[i][1] = max(dp[i-1][1], -prices[i])
            dp_i_1 = Math.max(dp_i_1, -price);
            //持股的收益
            //   dp[i][1]
            // = max(dp[-1][1], dp[-1][0] - prices[i])
            // = max(-infinity, 0 - prices[i])
            // = -prices[i]
        }
        return dp_i_0;
    }


    /**
     * 解释一下 为什么
     * min = Math.min(price, min);
     * ret = Math.max(ret, price - min);
     * 这两行代码无论那个先执行，都不会影响结果
     * <p>
     * 假设我们先执行ret = Math.max(ret, price - min);，那么这次的计算用的是上一轮的最低价。
     * 即使在这轮我们找到了新的更低的价格，也不会影响这次收益的计算。
     * 因为这轮如果先计算收益，
     * 那么就是在还没有找到新的最低价之前就已经决定了卖出，所以这个操作和是否能找到更低的价格无关。
     *
     * @param prices
     * @return
     */
    public static int maxProfitAC2(int[] prices) {
        int min = Integer.MAX_VALUE;
        int ret = 0;
        for (int price : prices) {
            min = Math.min(price, min);
            ret = Math.max(ret, price - min);
        }
        return ret;
    }

    public static int maxProfitAC(int[] prices) {
        int min = Integer.MAX_VALUE;
        int ret = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (price - min > ret) {
                ret = price - min;
            }
        }
        return ret;
    }

    public static int maxProfitError3(int[] prices) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                minIdx = i;
            }
        }
        int ret = 0;
        for (int i = minIdx; i < prices.length; i++) {
            ret = Math.max(ret, prices[i] - min);
        }
        return ret;
    }


    public static int maxProfit3(int[] prices) {
        int seal = 0;//第i天不持股的收益
        int have = Integer.MIN_VALUE; //第i天持股的收益
        for (int price : prices) {
            seal = Math.max(seal, have + price); //不持股的收益，取二者较大值
            have = Math.max(have, -price);
        }
        return seal;
    }


    /**
     * 错误之处在于prices[i]右侧存在的那一个最大值，并不适用于每一个 prices[i]
     * 所以需要一个数组 maxRight[] ，maxRight[i] 表示 prices[i]右侧的最大值，
     * 然后遍历数组 maxRight，取出最大值即可
     * <p>
     * 这种算法的复杂度依然没有降低
     *
     * @param prices
     * @return
     */
    public static int maxProfitError2(int[] prices) {
        int max = 0;
        int rMax = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (rMax < prices[i + 1]) {
                for (int j = i + 1; j < prices.length; j++) {
                    rMax = Math.max(rMax, prices[j]);
                }
            }
            max = Math.max(max, rMax - prices[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {2, 4, 1};
        System.out.println(maxProfit(prices));
    }
}

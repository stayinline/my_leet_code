package dp;

import java.util.Arrays;

public class Case322 {


    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        int initNum = Integer.MAX_VALUE - 1;
        Arrays.fill(dp, initNum);

        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin <= -1) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == initNum ? -1 : dp[amount];
    }

    // 1 + dp[i - coin]可能会越界
    public static int coinChangeError(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin <= -1) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    private static int count = Integer.MAX_VALUE;

    public static int coinChange1(int[] coins, int amount) {
        return coinChange1Helper(coins, amount);
    }

    public static int coinChange1Helper(int[] coins, int targetAmount) {
        if (targetAmount == 0) {
            return 0;
        } else if (targetAmount < 0) {
            return -1;
        }
        int curMin = Integer.MAX_VALUE;
        for (int coin : coins) {
            int curCount = coinChange1Helper(coins, targetAmount - coin);
            if (curCount == -1) {
                continue;
            }
            curMin = Math.min(curMin, 1 + curCount);
        }
        return curMin == Integer.MAX_VALUE ? -1 : curMin;
    }


    /**
     * 第一次剪枝，
     * 用memory[i]表示amount=i时的最少硬币数量
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange2(int[] coins, int amount) {
        int[] memory = new int[amount + 1];
        Arrays.fill(memory, Integer.MIN_VALUE);
        return coinChangeHelper2(coins, amount, memory);
    }

    public static int coinChangeHelper2(int[] coins, int amount, int[] memory) {
        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return -1;
        }
        if (memory[amount] != Integer.MIN_VALUE) {
            return memory[amount];
        }
        int curMin = Integer.MAX_VALUE;
        for (int coin : coins) {
            int targetAmount = amount - coin;
            int curCount = coinChangeHelper2(coins, targetAmount, memory);
            if (curCount == -1) {
                continue;
            }
            curMin = Math.min(curMin, 1 + curCount);
        }
        memory[amount] = curMin == Integer.MAX_VALUE ? -1 : curMin;
        return memory[amount];
    }


    public static void main(String[] args) {
        int[] coins = {2};
        System.out.println(coinChange(coins, 3));

    }

}

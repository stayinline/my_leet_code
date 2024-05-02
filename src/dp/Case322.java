package dp;

import java.util.Arrays;

public class Case322 {

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
        int[] coins = {1, 2, 5};
        System.out.println(coinChange2(coins, 11));

    }

}
